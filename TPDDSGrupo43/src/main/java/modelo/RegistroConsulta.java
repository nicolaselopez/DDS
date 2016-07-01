package modelo;

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
	private String RegConFechaConsulta;
	private float RegConDuracion;
	
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
	public float getRegConDuracion() {
		return RegConDuracion;
	}
	public void setRegConDuracion(float regConDuracion) {
		RegConDuracion = regConDuracion;
	}
	//--------------------------------------------------------------------------------
	private int CantidadResultados;
	
	public void setCantidadResultados(int numero){
		this.CantidadResultados = numero;
	}
	public int getCantidadResultados(){
		return CantidadResultados;
	}
	
	
	public void setResultadoConsulta(String frase, int cantidadResultados, long tiempo ){
		this.RegConDetalle = frase;
		this.CantidadResultados = cantidadResultados;
		this.RegConDuracion = tiempo;
		
	}
	
	//--------------------------------------------------------------------------------
	public RegistroConsulta(int regConIdUsuario, int regConIdPoi, String regConTipoConsulta, String regConDetalle,
			float regConDuracion) {
		super();
		RegConIdUsuario = regConIdUsuario;
		RegConIdPoi = regConIdPoi;
		RegConTipoConsulta = regConTipoConsulta;
		RegConDetalle = regConDetalle;
		RegConDuracion = regConDuracion;
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
			Integer rs = st.executeUpdate("INSERT INTO registroconsulta(RegConIdUsuario,RegConIdPoi,RegConTipoConsulta,RegConDetalle,RegConDuracion) VALUES("
					+consulta.RegConIdUsuario+","+consulta.RegConIdPoi+",'"+consulta.RegConTipoConsulta+"','"+consulta.RegConDetalle+"',"+consulta.RegConDuracion+");");
		if(rs == 1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	
	


//--------------------------------------------------------30/06-MM-
// rs no se esta usando (Revisar)
// Generar Informe de busquedas agrupadas por fecha
	public RegistroConsulta[] generarInformeBusquedasPorFecha(){
			// TODO Auto-generated method stub
			RegistroConsulta[] consultas = new RegistroConsulta[20];
			try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select RegConFechaConsulta, count(*) from registroconsulta group by RegConFechaConsulta;");
			}catch(Exception se){
				se.printStackTrace();
			}
			return consultas;
			
	}
	
	public RegistroConsulta[] generarInformeBusquedasPorTerminalTotales(){
		// TODO Auto-generated method stub
		RegistroConsulta[] consultas = new RegistroConsulta[20];
		try{
		Conexion c=new Conexion();
		Connection con=c.getConexion();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select RegConIdUsuario, count(*) from registroconsulta group by RegConIdUsuario;");
		}catch(Exception se){
			se.printStackTrace();
		}
		return consultas;
	}
		
	public RegistroConsulta[] generarInformeBusquedasPorTerminalParciales(){
			// TODO Auto-generated method stub
			RegistroConsulta[] consultas = new RegistroConsulta[20];
			try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT RegConIdUsuario, count(*) FROM dds.registroconsulta group by RegConIdUsuario,RegConFechaConsulta;");
			}catch(Exception se){
				se.printStackTrace();
			}
			return consultas;
		
}
}