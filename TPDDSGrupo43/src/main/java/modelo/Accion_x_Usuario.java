package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Accion_x_Usuario {
	
	protected int IdUsuario;
	protected int IdAccion;
	protected LocalDateTime FechaDeCreacion;
	protected Boolean Activo;
	protected int NroSecuencial;
	public Accion_x_Usuario tabla;
	
	Accion_x_Usuario tablaOriginal = new Accion_x_Usuario();
	
	public int getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}
	
	
	public int getIdAccion() {
		return IdAccion;
	}
	public void setIdAccion(int idAccion) {
		IdAccion = idAccion;
	}
	
	public LocalDateTime getFechaDeCreacion() {
		return FechaDeCreacion;
	}
	public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
		FechaDeCreacion = fechaDeCreacion;
	}
	
	
	public Boolean getActivo() {
		return Activo;
	}
	public void setActivo(Boolean activo) {
		Activo = activo;
	}
	
	public int getNroSecuencial() {
		return NroSecuencial;
	}
	public void setNroSecuencial(int nroSecuencial) {
		NroSecuencial = nroSecuencial;
	}
	
	public Accion_x_Usuario(int idUsuario, int idAccion, LocalDateTime fechaDeCreacion, Boolean activo, int nroSecuencial){
		super();
		IdUsuario = idUsuario;
		IdAccion = idAccion;
		FechaDeCreacion = fechaDeCreacion;
		Activo = activo;
		NroSecuencial = nroSecuencial;
		
	}
	
	public Accion_x_Usuario(){
		super();
	}
	
	int secuencialActual = 0;
	
	public void iniciarProcesoDe(UsuarioAdministrador admin){
		
		secuencialActual = this.getSecuencial()+1;
		this.agregarAccionesAUsuarios(admin);
	}// Por ahora no se me ocurre otra cosa que pasarle el admin que gejecuto el proces para
	 // tener acceso a los metodos getAcciones y getUsuarios
	
	public void agregarAccionesAUsuarios(UsuarioAdministrador admin){

		admin.getUsuariosCandidatos().forEach(usuario->agregarAccionesA(usuario,admin));	
	} // A cada usuario se le agrega la lista de acciones
	
	public void agregarAccionesA(Usuario usuario, UsuarioAdministrador admin){
		Accion.setSecuencialActual(secuencialActual);
		admin.getAccionesAAgregar().forEach(accion->accion.asignarlaA(usuario));
	}// Cada accion perteneciente a lista se agrega una por una al usuario parametro
	
	public void hacerRollBack(){
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT MAX(NroSecuencial) from acciones_x_usuario");
			Integer ru=st.executeUpdate("UPDATE accion_x_usuario SET Activo="+1+" where NroSecuencial ="+(rs.getInt(1)-1)+";");
			Integer rd=st.executeUpdate("DELETE from acciones_x_usuario where NroSecuencial="+rs.getInt(1)+";");
			secuencialActual--;
			if(ru == 1){
			}
		}catch(Exception se){
			se.printStackTrace();
		}
	}
	
	public int getSecuencial(){
		int secuencialMaximo=0;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT MAX(NroSecuencial) from acciones_x_usuario");
			secuencialMaximo = rs.getInt(1);	
		}
		catch(Exception se){
			se.printStackTrace();
		}
		return secuencialMaximo;
	}
	public static boolean chequeoAccionDeUsuario(int usuario, int IdAccion){
		boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from acciones_x_usuario where Usuario="+ usuario +" and Accion = "+ IdAccion +" and Activo=1");
			while(rs.next()){
				OK = true;
			}
		}catch(Exception se){
			se.printStackTrace();
		}
		return OK;
	}
	
}