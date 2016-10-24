package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Poi;

import com.google.gson.Gson;

public class ResultadosHistorial {

	public int IdResultado;
	public int IdPoi;
	public int IdHistorial;
	public String PoiDescripcion;

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
		PoiDescripcion = Poi.buscarPoiDescripcion(idPoi);
	}

	public String getPoiDescripcion() {
		return PoiDescripcion;
	}

	public void setPoiDescripcion(String poiDescripcion) {
		PoiDescripcion = poiDescripcion;
	}

	public ResultadosHistorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ResultadosHistorial[] consultarResultadosHistorial() {
		ResultadosHistorial[] resultadosHistorial = new ResultadosHistorial[5000];
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from poi");
			int i = 0;
			while (rs.next()) {

				resultadosHistorial[i] = new ResultadosHistorial(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				i++;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return resultadosHistorial;
	}

	public static int totalPois(int idHistorial) {

		int total = 0;

		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select count(*) from resultadobusqueda where idHistorial =" + idHistorial + ";");
			while (rs.next()) {

				total = rs.getInt(1);

			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return total;
	}

	public static ResultadosHistorial[] poisHistorial(int idHistorial2) {
		ResultadosHistorial[] pois = new ResultadosHistorial[5000];

		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from resultadobusqueda where idHistorial="+idHistorial2+";");

			int i = 0;
			while (rs.next()) {
				pois[i] = new ResultadosHistorial(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				i++;
			}
			for (int k = i; k < 5000; k++) {
				pois[k] = new ResultadosHistorial();
				pois[k].setIdHistorial(-1);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return pois;
	}
	
	public static String convertArray(ResultadosHistorial[] resultados) {
		Gson gson = new Gson();
		
		return gson.toJson(resultados);
	}
}
