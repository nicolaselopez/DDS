package modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Accion_x_Usuario {
	
	protected int IdUsuario;
	protected int IdAccion;
	protected String AccionDescripcion;
	protected LocalDateTime FechaDeCreacion;
	protected Boolean Activo;
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
	
	
	public String getAccionDescripcion() {
		return AccionDescripcion;
	}
	public void setAccionDescripcion(String accionDescripcion) {
		AccionDescripcion = accionDescripcion;
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
	
	public Accion_x_Usuario getTablaOriginal(){
		return tablaOriginal;
	}
	
	public void setTablaOriginal(Accion_x_Usuario tablaOriginal){
		tabla = tablaOriginal;
	}
	
	public Accion_x_Usuario(int idUsuario, int idAccion, String accionDescripcion, LocalDateTime fechaDeCreacion, Boolean activo){
		super();
		IdUsuario = idUsuario;
		IdAccion = idAccion;
		AccionDescripcion = accionDescripcion;
		FechaDeCreacion = fechaDeCreacion;
		Activo = activo;
	}
	
	public Accion_x_Usuario(){
		super();
	}
	
	public void iniciarProcesoDe(UsuarioAdministrador admin){
		
		this.agregarAccionesAUsuarios(admin);
	}// Por ahora no se me ocurre otra cosa que pasarle el admin que gejecuto el proces para
	 // tener acceso a los metodos getAcciones y getUsuarios
	
	public void agregarAccionesAUsuarios(UsuarioAdministrador admin){

		admin.getUsuariosCandidatos().forEach(usuario->agregarAccionesA(usuario,admin));	
	} // A cada usuario se le agrega la lista de acciones
	
	public void agregarAccionesA(Usuario usuario, UsuarioAdministrador admin){
		admin.getAccionesAAgregar().forEach(accion->accion.asignarlaA(usuario));
	}// Cada accion perteneciente a lista se agrega una por una al usuario parametro
	
	public void restaurarAOriginal(){
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();

			Integer ru=st.executeUpdate("UPDATE acciones_x_usuario SET"
					+ " IdUsuario= "+this.getTablaOriginal().IdUsuario+
					",IdAccion="+this.getTablaOriginal().IdAccion+
					", AccionDescripcion = "+this.getTablaOriginal().AccionDescripcion+
					 ", FechaDeCreacion= "+this.getTablaOriginal().FechaDeCreacion+
					 ", Activo= "+this.getTablaOriginal().Activo+");");
		
			if(ru == 1){
			}
		}catch(Exception se){
			se.printStackTrace();
	}
	}
	
}
