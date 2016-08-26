package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Constantes {
	
	private String WSBanco = "WEBSERVICEBANCO";
	private String WSCentro = "WEBSERVICECENTRO";
	private String WSP2 = "WEBSERVICEP2";
	private String WSP2Bad = "WEBSERVICEP2Bad";
	private String fileOut = "P1FILEOUT";
	private String fileIn = "P1FILEIN";
	
	
	public String getWSBanco() {
		return WSBanco;
	}	
	
	public String getWSCentro() {
		return WSCentro;
	}

	public String getWSP2() {
		return WSP2;
	}

	public String getWSP2Bad() {
		return WSP2Bad;
	}

	public String getFileOut() {
		return fileOut;
	}

	public String getFileIn() {
		return fileIn;
	}

	public static String obtenerValor(String parametro){
		String valor=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select valor from parametros where parametro='"+parametro+"';");
			while(rs.next()){
				valor=rs.getString(1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return valor;
	}
	
}
