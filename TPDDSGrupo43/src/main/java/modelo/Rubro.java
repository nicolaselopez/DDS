package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.BeanRubro;


public class Rubro {

	public static BeanRubro[] consultarRubro(){
		BeanRubro[] rubros = new BeanRubro[100];
		for(int k=0; k<100; k++){
			rubros[k].setIdRubro(-1);
		}
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from rubro");
			int i=0;
			while(rs.next()){
				rubros[i]=new BeanRubro(rs.getInt(1), rs.getString(2), rs.getInt(3));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return rubros;
	}
	
}