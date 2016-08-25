package modelo;

import java.sql.Connection;
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
	
	public void asignarlaA(Usuario unUsuario){
		
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();

			Integer ru=st.executeUpdate("INSERT INTO acciones_x_usuario (IdUsuario,IdAccion,"
				+ "AccionDescripcion,FechaDeCreacion,Activo) VALUES ("+unUsuario.getIdUsuario()+","
				+this.getIdAccion()+","+this.getAccionDescripcion()+","
				+LocalDate.now()+","+1+");");
		
			if(ru == 1){
			}
		}catch(Exception se){
			se.printStackTrace();
	}
		//INSERT INTO table (id, name, age) VALUES(1, "A", 19) ON DUPLICATE KEY UPDATE    
		//name="A", age=19 --- Agregar valor y si ya esta actualizar
	}
}
