package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Poi;

public class Servicio {
	
	private int IdServicio;
	private int ServicioIdPoi;
	private int ServicioIdTipoPoi;
	private String ServicioDescripcion;
	private String ServicioDiaDisponible;
	private String ServicioHoraDesde1;
	private String ServicioHoraHasta1;
	private String ServicioHoraDesde2;
	private String ServicioHoraHasta2;
	private String ServicioTags;
	private String ServicioFechaAlta;
	private String ServicioFechaModificacion;
	private int ServicioActivo;
	
	public int getIdServicio() {
		return IdServicio;
	}
	public void setIdServicio(int idServicio) {
		IdServicio = idServicio;
	}
	public int getServicioIdPoi() {
		return ServicioIdPoi;
	}
	public void setServicioIdPoi(int servicioIdPoi) {
		ServicioIdPoi = servicioIdPoi;
	}
	public int getServicioIdTipoPoi() {
		return ServicioIdTipoPoi;
	}
	public void setServicioIdTipoPoi(int servicioIdTipoPoi) {
		ServicioIdTipoPoi = servicioIdTipoPoi;
	}
	public String getServicioDescripcion() {
		return ServicioDescripcion;
	}
	public void setServicioDescripcion(String servicioDescripcion) {
		ServicioDescripcion = servicioDescripcion;
	}
	public String getServicioDiaDisponible() {
		return ServicioDiaDisponible;
	}
	public void setServicioDiaDisponible(String servicioDiaDisponible) {
		ServicioDiaDisponible = servicioDiaDisponible;
	}
	public String getServicioHoraDesde1() {
		return ServicioHoraDesde1;
	}
	public void setServicioHoraDesde1(String servicioHoraDesde1) {
		ServicioHoraDesde1 = servicioHoraDesde1;
	}
	public String getServicioHoraHasta1() {
		return ServicioHoraHasta1;
	}
	public void setServicioHoraHasta1(String servicioHoraHasta1) {
		ServicioHoraHasta1 = servicioHoraHasta1;
	}
	public String getServicioHoraDesde2() {
		return ServicioHoraDesde2;
	}
	public void setServicioHoraDesde2(String servicioHoraDesde2) {
		ServicioHoraDesde2 = servicioHoraDesde2;
	}
	public String getServicioHoraHasta2() {
		return ServicioHoraHasta2;
	}
	public void setServicioHoraHasta2(String servicioHoraHasta2) {
		ServicioHoraHasta2 = servicioHoraHasta2;
	}
	public String getServicioTags() {
		return ServicioTags;
	}
	public void setServicioTags(String servicioTags) {
		ServicioTags = servicioTags;
	}
	public String getServicioFechaAlta() {
		return ServicioFechaAlta;
	}
	public void setServicioFechaAlta(String servicioFechaAlta) {
		ServicioFechaAlta = servicioFechaAlta;
	}
	public String getServicioFechaModificacion() {
		return ServicioFechaModificacion;
	}
	public void setServicioFechaModificacion(String servicioFechaModificacion) {
		ServicioFechaModificacion = servicioFechaModificacion;
	}
	public int getServicioActivo() {
		return ServicioActivo;
	}
	public void setServicioActivo(int servicioActivo) {
		ServicioActivo = servicioActivo;
	}
	public Servicio(int idServicio, int servicioIdPoi, int servicioIdTipoPoi, String servicioDescripcion,
			String servicioDiaDisponible, String servicioHoraDesde1, String servicioHoraHasta1,
			String servicioHoraDesde2, String servicioHoraHasta2, String servicioTags, String servicioFechaAlta,
			String servicioFechaModificacion, int servicioActivo) {
		super();
		IdServicio = idServicio;
		ServicioIdPoi = servicioIdPoi;
		ServicioIdTipoPoi = servicioIdTipoPoi;
		ServicioDescripcion = servicioDescripcion;
		ServicioDiaDisponible = servicioDiaDisponible;
		ServicioHoraDesde1 = servicioHoraDesde1;
		ServicioHoraHasta1 = servicioHoraHasta1;
		ServicioHoraDesde2 = servicioHoraDesde2;
		ServicioHoraHasta2 = servicioHoraHasta2;
		ServicioTags = servicioTags;
		ServicioFechaAlta = servicioFechaAlta;
		ServicioFechaModificacion = servicioFechaModificacion;
		ServicioActivo = servicioActivo;
	}
	
	
	
	public Servicio(int servicioIdPoi, String servicioDescripcion, String servicioDiaDisponible,
			String servicioHoraDesde1, String servicioHoraHasta1, String servicioHoraDesde2, String servicioHoraHasta2,
			String servicioTags, int servicioActivo) {
		super();
		ServicioIdPoi = servicioIdPoi;
		ServicioDescripcion = servicioDescripcion;
		ServicioDiaDisponible = servicioDiaDisponible;
		ServicioHoraDesde1 = servicioHoraDesde1;
		ServicioHoraHasta1 = servicioHoraHasta1;
		ServicioHoraDesde2 = servicioHoraDesde2;
		ServicioHoraHasta2 = servicioHoraHasta2;
		ServicioTags = servicioTags;
		ServicioActivo = servicioActivo;
	}
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Servicio[] consultarServicios(int idPoi){
		Servicio[] servicio = new Servicio[20];
		try{
		Conexion c=new Conexion();
		Connection con=c.getConexion();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from servicio where ServicioIdPoi=" + idPoi + ";");
		int i = 0;
		while(rs.next()){
			servicio[i]=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			i++;
		}
		for(int k=i;k<20;k++){
			servicio[k]=new Servicio();
			servicio[k].setIdServicio(-1);
		};
		}catch(Exception se){
			se.printStackTrace();
		}
		return servicio;
	}
	
	public static Boolean registrarServicio(Servicio servicio){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			servicio.setServicioIdTipoPoi(Poi.buscarPoi(servicio.getServicioIdPoi()).getPoiIdTipoPoi());
			Integer rs = st.executeUpdate("INSERT INTO servicio(ServicioIdPoi,ServicioIdTipoPoi,ServicioDescripcion,"
						+"ServicioDiaDisponible,ServicioHoraDesde1,ServicioHoraHasta1,ServicioHoraDesde2,"
						+"ServicioHoraHasta2,ServicioTags,ServicioActivo) VALUES("
						+servicio.getServicioIdPoi()+","+servicio.getServicioIdTipoPoi()+",'"+servicio.getServicioDescripcion()+"','"
						+servicio.getServicioDiaDisponible()+"','"+servicio.getServicioHoraDesde1()+"','"+servicio.getServicioHoraHasta1()+"','"
						+servicio.getServicioHoraDesde2()+"','"+servicio.getServicioHoraHasta2()+"','"+servicio.getServicioTags()+"',"+servicio.getServicioActivo()+");");
			if(rs == 1){
				OK = true;
			}				
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	public static String generarDias(String dLun, String dMar, String dMie, String dJue, String dVie, String dSab,
			String dDom) {
		String dias = dLun+";"+dMar+";"+dMie+";"+dJue+";"+dVie+";"+dSab+";"+dDom+";";
		return dias;
	}
	
}
