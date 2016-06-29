package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ExcepcionesPoi {
	
	protected int IdExcepciones;
	protected int ExcepcionesIdPoi;
	protected String ExcepcionFecha;
	protected String ExcepcionDescripcion;
	protected int ExcepcionActivo;
	
	public int getIdExcepciones() {
		return IdExcepciones;
	}

	public void setIdExcepciones(int idExcepciones) {
		IdExcepciones = idExcepciones;
	}

	public int getExcepcionesIdPoi() {
		return ExcepcionesIdPoi;
	}

	public void setExcepcionesIdPoi(int excepcionesIdPoi) {
		ExcepcionesIdPoi = excepcionesIdPoi;
	}

	public String getExcepcionFecha() {
		return ExcepcionFecha;
	}

	public void setExcepcionFecha(String excepcionFecha) {
		ExcepcionFecha = excepcionFecha;
	}

	public String getExcepcionDescripcion() {
		return ExcepcionDescripcion;
	}

	public void setExcepcionDescripcion(String excepcionDescripcion) {
		ExcepcionDescripcion = excepcionDescripcion;
	}

	public int getExcepcionActivo() {
		return ExcepcionActivo;
	}

	public void setExcepcionActivo(int excepcionActivo) {
		ExcepcionActivo = excepcionActivo;
	}


	
	public boolean validarExcepcion (int idPoi,LocalDate fecha ){
		String fechaS = fecha.toString();
		boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("Select * from excepciones where excepcionFecha = '" + fechaS + "' and excepcionesIdPoi = " + idPoi + ";");
			OK= !rs.next(); // Poner !
			
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;

	}

}