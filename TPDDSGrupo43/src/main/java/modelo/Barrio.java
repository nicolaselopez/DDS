package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.BeanBarrio;

public class Barrio {
	
	public static BeanBarrio[] consultarBarrios(){
		BeanBarrio[] barrios = new BeanBarrio[47];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from barrio");
			int i=0;
			while(rs.next()){
				barrios[i]=new BeanBarrio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return barrios;
	}

}
