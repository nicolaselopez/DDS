package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Accion {
	
	protected int IdAccion;
	protected String AccionDescripcion;
	
	public int getIdAccion(){
		
		return IdAccion;
	}
	
	public void setIdAccion(int id){
		IdAccion= id;
	}
	
	public String getAccionDescripcion(){
		
		return AccionDescripcion;
	}
	
	public void setAccionDescripcion(String descripcion){
		
		AccionDescripcion = descripcion;
	}
	
	public Accion(int idAccion, String accionDescripcion){
		super();
		IdAccion =idAccion;
		AccionDescripcion = accionDescripcion;
	}
	
	public static int numeroSecuencial;
	
	public void asignarlaA(Usuario unUsuario){
		
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT MAX(NroSecuencial) from acciones_x_usuario where Usuario = idUsuario");
			Integer ru=st.executeUpdate("INSERT INTO acciones_x_usuario (IdUsuario,IdAccion,"
				+ "FechaDeCreacion,Activo,NroSecuencial) VALUES ("+unUsuario.getIdUsuario()+","
				+this.getIdAccion()+","+LocalDate.now()+","+1+","+Accion.getSecuencialActual()+");");
			Integer ru2=st.executeUpdate("UPDATE acciones_x_usuario SET Activo="+0+" where"
					+ " NroSecuencial="+(Accion.getSecuencialActual()-1)+") and Usuario = idUsuario;");
			
		}catch(Exception se){
			se.printStackTrace();
	}
		//INSERT INTO table (id, name, age) VALUES(1, "A", 19) ON DUPLICATE KEY UPDATE    
		//name="A", age=19 --- Agregar valor y si ya esta actualizar
	}

	public static void setSecuencialActual(int secuencialActual) {
		numeroSecuencial = secuencialActual;
		
	}
	public static int getSecuencialActual(){
		return numeroSecuencial;
	}

	public static Accion[] getAcciones() {
		Accion[] busuario= new Accion[20];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from acciones;");

			int i=0;
			while(rs.next()){
				busuario[i]=new Accion(rs.getInt(1),rs.getString(2));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return busuario;
	}
}