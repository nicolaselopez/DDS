package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Comuna;

public class Barrio {
	
	private int IdBarrio;
	private String BarrioDescripcion;
	private int BarrioIdLocalidad;
	private int BarrioIdComuna;
	private Comuna BarrioComuna;
	public int getIdBarrio() {
		return IdBarrio;
	}
	public void setIdBarrio(int idBarrio) {
		IdBarrio = idBarrio;
	}
	public String getBarrioDescripcion() {
		return BarrioDescripcion;
	}
	public void setBarrioDescripcion(String barrioDescripcion) {
		BarrioDescripcion = barrioDescripcion;
	}
	public int getBarrioIdLocalidad() {
		return BarrioIdLocalidad;
	}
	public void setBarrioIdLocalidad(int barrioIdLocalidad) {
		BarrioIdLocalidad = barrioIdLocalidad;
	}
	public int getBarrioIdComuna() {
		return BarrioIdComuna;
	}
	public void setBarrioIdComuna(int barrioIdComuna) {
		BarrioIdComuna = barrioIdComuna;
	}
	public Comuna getBarrioComuna() {
		return BarrioComuna;
	}
	public void setBarrioComuna(Comuna barrioComuna) {
		BarrioComuna = barrioComuna;
	}
	
	public Barrio(int idBarrio, String barrioDescripcion, int barrioIdLocalidad, int barrioIdComuna) {
		super();
		IdBarrio = idBarrio;
		BarrioDescripcion = barrioDescripcion;
		BarrioIdLocalidad = barrioIdLocalidad;
		BarrioIdComuna = barrioIdComuna;
	}
	
	public Barrio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Barrio[] consultarBarrios(){
		Barrio[] barrios = new Barrio[47];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from barrio");
			int i=0;
			while(rs.next()){
				barrios[i]=new Barrio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return barrios;
	}

}