package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistroConsulta {
	
	private int IdRegistroConsulta;
	private int RegConIdUsuario;
	private int RegConIdPoi;
	private String RegConTipoConsulta;
	private String RegConDetalle;
	private String RegConFechaConsulta;
	
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
	public int getRegConTipoConsulta() {
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
	
	public RegistroConsulta(int idRegistroConsulta, int regConIdUsuario, int regConIdPoi, String regConTipoConsulta,
			String regConDetalle, String regConFechaConsulta) {
		super();
		IdRegistroConsulta = idRegistroConsulta;
		RegConIdUsuario = regConIdUsuario;
		RegConIdPoi = regConIdPoi;
		RegConTipoConsulta = regConTipoConsulta;
		RegConDetalle = regConDetalle;
		RegConFechaConsulta = regConFechaConsulta;
	}
	public RegistroConsulta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean registrarConsulta(RegistroConsulta consulta){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("INSERT INTO registroconsulta(RegConIdUsuario,RegConIdPoi,RegConTipoConsulta,RegConDetalle) VALUES("
					+consulta.RegConIdUsuario+","+consulta.RegConIdPoi+",'"+consulta.RegConTipoConsulta+"','"+consulta.RegConDetalle+"');");
		if(rs == 1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	
	
}
