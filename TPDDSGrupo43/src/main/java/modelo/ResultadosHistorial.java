package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultadosHistorial {

	protected int IdResultado;
	protected int IdPoi;
	protected int IdHistorial;
	
	public int getIdResultado() {
		return IdResultado;
	}

	public void setIdResultado(int idResultado) {
		IdResultado = idResultado;
	}

	public int getIdPoi() {
		return IdPoi;
	}

	public void setIdPoi(int idPoi) {
		IdPoi = idPoi;
	}

	public int getIdHistorial() {
		return IdHistorial;
	}

	public void setIdHistorial(int idHistorial) {
		IdHistorial = idHistorial;
	}
	

	public ResultadosHistorial(int idResultado, int idPoi, int idHistorial) {
		super();
		IdPoi = idPoi;
		IdResultado = idResultado;
		IdHistorial = idHistorial;
	}
	
	public ResultadosHistorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public static ResultadosHistorial[] consultarResultadosHistorial(){
		ResultadosHistorial[] resultadosHistorial = new ResultadosHistorial[5000];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from poi");
			int i=0;
			while(rs.next()){
				
				resultadosHistorial[i]=new ResultadosHistorial(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return resultadosHistorial;
	}
	
	public static int totalPois(int idHistorial){
		
		int total = 0;
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from resultadobusqueda where idHistorial =" + idHistorial + ";");
			while(rs.next()){
				
				total = rs.getInt(1);

			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return total;
	}
}
	