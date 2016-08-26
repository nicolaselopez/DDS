package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class Usuario {
	
	private String nombre;
	private String edad;
	private String correo;
	private String usuario;
	private String clave;
	private int idUsuario;
	private int rol;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	//-----------------------------------------------
	public void setRol (int rol){
		this.rol = rol;
	}
	public int getRol(){
		return rol;
	}
	public void setIdUsuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	public int getIdUsuario(){
		return idUsuario;
	}
	//------------------------------------------------
	public Usuario(String nombre, String edad,
			String correo, String usuario, String clave) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}
	
	public Usuario(int IdUsuario, String nombre, String edad,
			String correo, String usuario, String clave) {
		super();
		this.idUsuario = IdUsuario;
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
		super();
	}	
	
	public static Usuario consultarUsuario(String usuario){
		Usuario busuario=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from usuarios where usuario='"+usuario+"' and activo=1");
			while(rs.next()){
				busuario=new Usuario(rs.getInt(1),rs.getString(5), null, rs.getString(4), usuario, rs.getString(3));
			}
		}catch(SQLException se){
			se.printStackTrace();
			busuario.setUsuario(se.getLocalizedMessage());
		}
		return busuario;
	}
	// Get rol?
	public static Boolean registrarUsuario(Usuario usuario){
		Boolean OK = false;
		BasicPasswordEncryptor encriptador = new BasicPasswordEncryptor();
		usuario.setClave(encriptador.encryptPassword(usuario.getClave()));
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO usuarios (usuario, password, email, nombre, fechanac,activo,rol) VALUES "
					+ "('"+usuario.getUsuario()+"','"+usuario.getClave()+"','"+usuario.getCorreo()+"','"+usuario.getNombre()+"',"+usuario.getEdad()+",1,"+usuario.getRol()+");");
			if(rs == 1){
				OK = true;
			}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	public static Usuario[] getUsuarios() {
		Usuario[] busuario= new Usuario[20];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from usuarios;");

			int i=0;
			while(rs.next()){
				busuario[i]=new Usuario(rs.getInt(1),rs.getString(5), null, rs.getString(4),rs.getString(5),rs.getString(3));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return busuario;
	}

}
