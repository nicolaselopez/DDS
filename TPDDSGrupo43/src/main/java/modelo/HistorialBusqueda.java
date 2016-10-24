package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;

import modelo.ResultadosHistorial;

public class HistorialBusqueda {
	protected int IdHistorial;
	protected Date FechaBusqueda;
	protected String Criterio;
	
	public Date getFechaBusqueda() {
		return FechaBusqueda;
	}

	public void setIdResultado(Date fechaBusqueda) {
		FechaBusqueda = fechaBusqueda;
	}

	public String getCriterio() {
		return Criterio;
	}

	public void setCriterio(String criterio) {
		Criterio = criterio;
	}

	public int getIdHistorial() {
		return IdHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		IdHistorial = idHistorial;
	}


	public HistorialBusqueda(int idHistorial, Date fecha, String criterio) {
		super();
		IdHistorial = idHistorial;
		FechaBusqueda = fecha;
		Criterio = criterio;
	}
	
	public HistorialBusqueda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
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
	
	public static HistorialBusqueda[] consultarHistorial(String desde, String hasta){
		HistorialBusqueda[] pois = new HistorialBusqueda[5000];
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet 
			rs=st.executeQuery("select * from historialbusqueda where date(fechaBusqueda) BETWEEN '"+desde+"' AND '"+hasta+"' ;");
			if(hasta.length()==0)
			{
				rs=st.executeQuery("select * from historialbusqueda where date(fechaBusqueda) BETWEEN '"+desde+"' AND curdate() ;");
			}
			int i=0;
			while(rs.next()){
				pois[i]=new HistorialBusqueda(rs.getInt(1), rs.getDate(2), rs.getString(3));
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new HistorialBusqueda();
				pois[k].setIdHistorial(-1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return pois;
	}
	
	public static HistorialBusqueda buscarHistorial(int idPoi){
		HistorialBusqueda poi=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from historialbusqueda where idhistorialBusqueda=" + idPoi + ";");
			while(rs.next()){
				
				poi=new HistorialBusqueda(rs.getInt(1), rs.getDate(2), rs.getString(3));

			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return poi;
	}
	
	public int totalPois(int idHistorial){
		
		return ResultadosHistorial.totalPois(idHistorial);
	}
	
	public ResultadosHistorial[] poisBuscados(int idHistorial){
		
		return ResultadosHistorial.poisHistorial(idHistorial);
	}
}
