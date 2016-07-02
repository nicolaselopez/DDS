package modelo;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class RegistroConsulta {

	private int IdRegistroConsulta;
	private int RegConIdUsuario;
	private int RegConIdPoi;
	private String RegConTipoConsulta;
	private String RegConDetalle;
	private int RegConCantidad;
	private String RegConFechaConsulta;
	private long RegConDuracion;
	private RegistroConsulta RegCriterioReporte;

	public int getIdRegistroConsulta() {
		return IdRegistroConsulta;
	}

	public void setIdRegistroConsulta(int idRegistroConsulta) {
		IdRegistroConsulta = idRegistroConsulta;
	}

	public int getRegConIdUsuario() {
		return RegConIdUsuario;
	}

	public void setRegConIdUsuario(int regConIdUsuario) {
		RegConIdUsuario = regConIdUsuario;
	}

	public int getRegConIdPoi() {
		return RegConIdPoi;
	}

	public void setRegConIdPoi(int regConIdPoi) {
		RegConIdPoi = regConIdPoi;
	}

	public String getRegConFechaConsulta() {
		return RegConFechaConsulta;
	}

	public void setRegConFechaConsulta(String regConFechaConsulta) {
		RegConFechaConsulta = regConFechaConsulta;
	}

	public String getRegConTipoConsulta() {
		return RegConTipoConsulta;
	}

	public void setRegConTipoConsulta(String regConTipoConsulta) {
		RegConTipoConsulta = regConTipoConsulta;
	}

	public String getRegConDetalle() {
		return RegConDetalle;
	}

	public void setRegConDetalle(String regConDetalle) {
		RegConDetalle = regConDetalle;
	}

	public long getRegConDuracion() {
		return RegConDuracion;
	}

	public void setRegConDuracion(long regConDuracion) {
		RegConDuracion = regConDuracion;
	}

	public RegistroConsulta getRegCriterio() {
		return RegCriterioReporte;
	}

	public void setRegCriterio(RegistroConsulta regConDuracion) {
		RegCriterioReporte = regConDuracion;
	}
	
	public int getRegConCantidad() {
		return RegConCantidad;
	}

	public void setRegConCantidad(int regConCantidad) {
		RegConCantidad = regConCantidad;
	}

	public RegistroConsulta getRegCriterioReporte() {
		return RegCriterioReporte;
	}

	public void setRegCriterioReporte(RegistroConsulta regCriterioReporte) {
		RegCriterioReporte = regCriterioReporte;
	}



	// --------------------------------------------------------------------------------
	private int CantidadResultados;

	public void setCantidadResultados(int numero) {
		this.CantidadResultados = numero;
	}

	public int getCantidadResultados() {
		return CantidadResultados;
	}

	public void setResultadoConsulta(String frase, int cantidadResultados, long tiempo) {
		this.RegConDetalle = frase;
		this.CantidadResultados = cantidadResultados;
		this.RegConDuracion = tiempo;

	}

	// --------------------------------------------------------------------------------
	public RegistroConsulta(int regConIdUsuario, int regConIdPoi, String regConTipoConsulta, String regConDetalle, int regConCantidad,
			long regConDuracion, String fecha) {
		super();
		RegConIdUsuario = regConIdUsuario;
		RegConIdPoi = regConIdPoi;
		RegConTipoConsulta = regConTipoConsulta;
		RegConDetalle = regConDetalle;
		RegConCantidad = regConCantidad;
		RegConDuracion = regConDuracion;
		RegConFechaConsulta = fecha;
	}

	public RegistroConsulta(RegistroConsulta regCriterio) {
		
		this.setRegCriterio(regCriterio);
	}

	public static Boolean registrarConsulta(RegistroConsulta consulta) {
		Boolean OK = false;
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			Integer rs = st.executeUpdate(
					"INSERT INTO registroconsulta(RegConIdUsuario,RegConIdPoi,RegConTipoConsulta,RegConDetalle,RegConCantidad,RegConDuracion,RegConFechaConsulta) VALUES("
							+ consulta.getRegConIdUsuario() + "," + consulta.getRegConIdPoi() + ",'" + consulta.getRegConTipoConsulta()
							+ "','" + consulta.getRegConDetalle() + "'," + consulta.getRegConCantidad() + ",'"  + Long.toString(consulta.getRegConDuracion()) + "', '" + consulta.getRegConFechaConsulta()+ "');");
			if (rs == 1) {
				OK = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			OK = false;
		}
		return OK;
	}

	// --------------------------------------------------------30/06-MM-
	// rs no se esta usando (Revisar)
	// Generar Informe de busquedas agrupadas por fecha
	public static void generarInformeBusquedasPorFecha() {
		// TODO Auto-generated method stub
		RegistroConsulta[] list = new RegistroConsulta[20];
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"Select RegConFechaConsulta, count(*) from registroconsulta group by RegConFechaConsulta;");
		} catch (Exception se) {
			se.printStackTrace();
		}

	}

	public static void generarInformeBusquedasPorTerminalTotales() {
		// TODO Auto-generated method stub
		RegistroConsulta[] consultas = new RegistroConsulta[20];
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("Select RegConIdUsuario, count(*) from registroconsulta group by RegConIdUsuario;");
		} catch (Exception se) {
			se.printStackTrace();
		}
		// return consultas;
	}

	public static void generarInformeBusquedasPorTerminalParciales() {
		// TODO Auto-generated method stub
		RegistroConsulta[] consultas = new RegistroConsulta[20];
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT RegConIdUsuario, count(*) FROM dds.registroconsulta group by RegConIdUsuario,RegConFechaConsulta;");
		} catch (Exception se) {
			se.printStackTrace();
		}
		// return consultas;

	}
}