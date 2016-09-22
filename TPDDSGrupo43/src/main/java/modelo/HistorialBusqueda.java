package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

public class HistorialBusqueda {
	protected int IdHistorial;
	protected Date fechaBusqueda;
	protected String PoiDescripcion;

	public static Boolean registrarHistorial(String criterio)
	{
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO historialbusqueda "+
				"(fechaBusqueda, criterio) "+
				"VALUES (now(), '"+ criterio + "');");
			if(rs == 1){
				OK = true;
			}				
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}

	public static Boolean registrarResultados(Poi poi)
	{
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO resultadobusqueda "+
				"(IdPoi, idHistorial) "+
				"VALUES ("+poi.getIdPoi()+", (SELECT MAX(idhistorialBusqueda) FROM historialbusqueda) );");
			if(rs == 1){
				OK = true;
			}				
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
}
