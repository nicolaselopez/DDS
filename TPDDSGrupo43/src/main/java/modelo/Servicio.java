package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import modelo.Poi;

public class Servicio {
	
	private static final Logger log= Logger.getLogger( Servicio.class.getName() );
	
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
	
	public Servicio(int idServicio, int servicioIdPoi, String servicioDescripcion, String servicioDiaDisponible,
			String servicioHoraDesde1, String servicioHoraHasta1, String servicioHoraDesde2, String servicioHoraHasta2,
			String servicioTags, int servicioActivo) {
		super();
		IdServicio = idServicio;
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
	
	public static Servicio[] consultarServicios(int idPoi,Boolean externo, Boolean activo){
		Servicio[] servicio = new Servicio[20];
		try{
		Conexion c=new Conexion();
		Connection con=c.getConexion();
		Statement st=con.createStatement();
		ResultSet rs;
		if(externo){
			rs=st.executeQuery("Select * from servicioexterno where ServicioExternoIdPoi=" + idPoi + ";");
		}else{
			if(activo){
				rs=st.executeQuery("Select * from servicio where ServicioIdPoi=" + idPoi + " and ServicioActivo = 1;");
			}else{
				rs=st.executeQuery("Select * from servicio where ServicioIdPoi=" + idPoi + " and ServicioActivo = 0;");
			}
		}
		int i = 0;
		while(rs.next()){
			servicio[i]=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			i++;
		}if(servicio[i] == null){
			Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
			for(int j=0;j<cgpExterno.length;j++){
				if(cgpExterno[j].getIdPoi() == idPoi){
					servicio = cgpExterno[j].getPoiServicio();
					i++;	
				}	
			}
			
		}
		for(int k=i;k<20;k++){
			servicio[k]=new Servicio();
			servicio[k].setIdServicio(-1);
		};
		Servicio[] servicioaux = new Servicio[i];
		for(int p=0; p<i; p++){
			servicioaux[p] = servicio[p];
		}
		servicio = servicioaux;
		}catch(Exception se){
			se.printStackTrace();
		}
		return servicio;
	}
	

	public static Servicio buscarServicio(int idServicio){
		Servicio servicio=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from servicio where IdServicio=" + idServicio + ";");
			while(rs.next()){
				servicio=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			}
			if(servicio == null){
				rs=st.executeQuery("Select * from servicioexterno where IdServicioExterno=" + idServicio + ";");
				while(rs.next()){
					servicio=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
				}
			}
			
			if(servicio == null){
				Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
				for(int j=0;j<cgpExterno.length;j++){
					for(int t=0;t<cgpExterno[j].getPoiServicio().length;t++){
						log.info(cgpExterno[j].getPoiServicio()[t].getIdServicio() + " contra " + idServicio);
						if(cgpExterno[j].getPoiServicio()[t].getIdServicio() == idServicio){
							servicio = cgpExterno[j].getPoiServicio()[t];	
						}	
					}
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return servicio;
	}
//-------------------------	
	public static Boolean editarServicio(int servicio, int poi , int estado){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("UPDATE servicio SET ServicioActivo = " +estado+ " where idServicio =" + servicio + " AND ServicioIdPoi = " + poi + ";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	

	public static Boolean editarServicio(Servicio servicio){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			
			Integer rs = st.executeUpdate("UPDATE servicio SET " +
											"ServicioDescripcion = '" + servicio.getServicioDescripcion() + "', " +
											"ServicioDiaDisponible = '"+ servicio.getServicioDiaDisponible() + "', " +
											"ServicioHoraDesde1 = '" + servicio.getServicioHoraDesde1() +"', " +
											"ServicioHoraDesde2 = '"+ servicio.getServicioHoraDesde2() +"', " +
											"ServicioHoraHasta1 = '" + servicio.getServicioHoraHasta1() +"', " +
											"ServicioHoraHasta2 = '" + servicio.getServicioHoraHasta2() +"', " +
											"ServicioTags = '"+ servicio.getServicioTags() +"' " +
											"WHERE ServicioIdPoi = " + servicio.getServicioIdPoi() +" and IdServicio = " + servicio.getIdServicio() + ";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	
	public static Boolean editarServicioPoi(int poi, int estado){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("UPDATE servicio SET ServicioActivo = "+ estado +" where  ServicioIdPoi = " + poi + ";");
		if(rs>=1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	
//-------------------------	
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
	
//---------------------------
	
	public boolean esFechaHabil(LocalDate fecha) {
		ExcepcionesPoi excepciones = new ExcepcionesPoi();
		
		return excepciones.validarExcepcion(this.getServicioIdPoi(), fecha);
		
	}
//---------------------------
	public static String generarDias(String dLun, String dMar, String dMie, String dJue, String dVie, String dSab,
			String dDom) {
		String dias = dLun+";"+dMar+";"+dMie+";"+dJue+";"+dVie+";"+dSab+";"+dDom+";";
		return dias;
	}
	
	public boolean calcularDisponibilidad(int dayOfWeekHoy, String[] horaHoyParts) {
		String[] diasServicioParts = this.getServicioDiaDisponible().split(";");
		int i=0, diaDisponible;
		boolean disponible = false;
		LocalDate fechaHoy = LocalDate.now();
		while(i<diasServicioParts.length)
	    {	
	    	diaDisponible = calcularDiaDisponible(diasServicioParts[i]);
	    	
	    	if((diaDisponible == dayOfWeekHoy) && this.esFechaHabil(fechaHoy))
	    	{
	    		int horaHoy = Integer.parseInt(horaHoyParts[0]);
	    		int minHoy = Integer.parseInt(horaHoyParts[1]);
	    		int servicioDesde1 = StringUtils.isNotBlank(this.getServicioHoraDesde1()) ? Integer.parseInt(this.getServicioHoraDesde1()) : -1;
	    		int servicioHasta1 = StringUtils.isNotBlank(this.getServicioHoraHasta1()) ? Integer.parseInt(this.getServicioHoraHasta1()) : -1;
	    		int servicioDesde2 = StringUtils.isNotBlank(this.getServicioHoraDesde2()) ? Integer.parseInt(this.getServicioHoraDesde2()) : -1;
	    		int servicioHasta2 = StringUtils.isNotBlank(this.getServicioHoraHasta2()) ? Integer.parseInt(this.getServicioHoraHasta2()) : -1;
	    		
	    		if( horaEstaEntre(horaHoy, minHoy, servicioDesde1, servicioHasta1) || horaEstaEntre(horaHoy, minHoy, servicioDesde2, servicioHasta2) ) 
	    		{
	    			disponible = true;
	    		}
	    		
				break;
	    	}
	    	
	    	i++;
	    }
		
		return disponible;
		
	}

	private boolean horaEstaEntre( int horaHoy,  int minHoy, int horaDesde, int horaHasta) {
		boolean disponible = false;
		
		if(horaHasta == 0)
		{
			horaHasta = 24;
		}
		
		if( horaHoy>=horaDesde )
		{
			if( horaHoy==horaHasta && minHoy==0 )
			{
				disponible = true;
			}
			else
			{
				if(horaHoy<horaHasta)
				{
					disponible = true;
				}
			}
		}
		
		return disponible;
	}
	
	public int calcularDiaDisponible(String diaServicio) {
		int nroDia = 0;
		
		if(diaServicio.equals("Dom"))
		{
			nroDia = 1;
		}
		else
		{
			if(diaServicio.equals("Lun"))
			{
				nroDia = 2;
			}
			else
			{
				if(diaServicio.equals("Mar"))
				{
					nroDia = 3;
				}
				else
				{
					if(diaServicio.equals("Mie"))
					{
						nroDia = 4;
					}
					else
					{
						if(diaServicio.equals("Jue"))
						{
							nroDia = 5;
						}
						else
						{
							if(diaServicio.equals("Vie"))
							{
								nroDia = 6;
							}
							else
							{
								if(diaServicio.equals("Sab"))
								{
									nroDia = 7;
								}
							}
						}
					}
				}
			}
		}
		
		return nroDia;
	}
	
	public static String diaPorNumero(int diaServicio) {
		String nroDia = "";
		
		if(diaServicio == 1)
		{
			nroDia = "Dom";
		}
		else
		{
			if(diaServicio == 2)
			{
				nroDia = "Lun";
			}
			else
			{
				if(diaServicio == 3)
				{
					nroDia = "Mar";
				}
				else
				{
					if(diaServicio == 4)
					{
						nroDia = "Mie";
					}
					else
					{
						if(diaServicio == 5)
						{
							nroDia = "Jue";
						}
						else
						{
							if(diaServicio == 6)
							{
								nroDia = "Vie";
							}
							else
							{
								if(diaServicio == 7)
								{
									nroDia = "Sab";
								}
							}
						}
					}
				}
			}
		}
		
		return nroDia;
	}
	//--------------------------------------------------------30/06-MM-
	private static long tiempoInicio;
	private static long tiempoBusqueda;
	private static long tiempoMaximo;
	
	public static void setTiempoInicio(long tiempo){
		tiempoInicio = tiempo;
	}
	public long getTiempoInicio(){
		return tiempoInicio;
	}
	public static void setTiempoBusqueda(long tiempo){
		tiempoBusqueda = tiempo;
	}
	public long getTiempoBusqueda(){
		return tiempoBusqueda;
	}
	public void setTiempoMaximo(long tiempo){
		tiempoMaximo = tiempo;
	}
	public long getTiempoMaximo(){
		return tiempoMaximo;
	}
	//--------------------------------------------------------30/06-MM-
	
	public static Servicio[] consultarServiciosTag(String tag) {
		// TODO Auto-generated method stub
		Servicio[] servicio = new Servicio[20];
		Servicio.setTiempoInicio(System.currentTimeMillis());
		try{
		Conexion c=new Conexion();
		Connection con=c.getConexion();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from servicio where ServicioTags like '%" + tag + "%';");
		int i = 0;

		while(rs.next()){
			servicio[i]=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			i++;
		}
		rs=st.executeQuery("Select * from servicioexterno where ServicioExternoTags like '%" + tag + "%';");
		while(rs.next()){
			servicio[i]=new Servicio(rs.getInt(1), rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
			i++;
		}
		Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
		for(int j=0;j<cgpExterno.length;j++){
			for(int t=0;t<cgpExterno[j].getPoiServicio().length;t++){
				if(cgpExterno[j].getPoiServicio()[t].getServicioDescripcion().contains(tag)){
					log.info("entreee");
					servicio[i] = cgpExterno[j].getPoiServicio()[t];
					i++;	
				}	
			}
		}
		for(int k=i;k<20;k++){
			servicio[k]=new Servicio();
			servicio[k].setIdServicio(-1);
		};
		}catch(Exception se){
			se.printStackTrace();
		}
		//--------------------------------------------------------30/06-MM-
		long tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio;
		Servicio.setTiempoBusqueda(tiempoTranscurrido);  
		tiempoMaximo = 1000000;
		if (tiempoBusqueda > tiempoMaximo){
			// Mandar Mail a Admin
			String destinatarios = Mail.destinatarioAdministrador();
			Mail.enviar("Estimados Administradores:\n\nSe ha generado una consulta que ha superado el tiempo maximo de: " + tiempoMaximo + "\n\nPor favor dar el soporte correspondiente.", destinatarios);
		//--------------------------------------------------------30/06-MM-
		}
		int cantidad = 0;
		for(int i = 0; i<servicio.length; i++){
			if(servicio[i].getIdServicio() != -1){
				cantidad++;
			}
		};
		RegistroConsulta registro = new RegistroConsulta(1, 0, "1", tag,cantidad,tiempoBusqueda, LocalDate.now().toString());
		RegistroConsulta.registrarConsulta(registro);
		return servicio;
			
	}
	
	public static Servicio[] crearServiciosBancoXDefecto(JSONObject serviciosObject){
		Servicio[] servicio = null;
		try{
			JSONArray temp = serviciosObject.getJSONArray("servicios");
			int length = temp.length();
			servicio = new Servicio[length];
			if (length > 0) {
				for(int k=0; k<length;k++){
					servicio[k] = new Servicio(0, temp.getString(k), "Lun;Mar;Mie;Jue;Vie;null;null;","9", "15", "", "",temp.getString(k), 1);
				}
			}
		return servicio;	
		}catch(Exception e){
			return servicio;
		}
	}
	
	public static Servicio[] crearServiciosCGP(JSONObject serviciosObject){
		Servicio[] servicio = null;
		try{
			JSONArray temp = serviciosObject.getJSONArray("servicios");
			int length = temp.length();
			servicio = new Servicio[length];
			if (length > 0) {
				for(int k=0; k<length;k++){
					JSONObject servicioObjeto = (JSONObject) temp.get(k);
					servicio[k] = new Servicio(0, servicioObjeto.getString("nombre"), buscarDias(servicioObjeto),buscarHoraDesde(servicioObjeto), buscarHoraHasta(servicioObjeto), "", "",servicioObjeto.getString("nombre"), 1);
				}
			}
		return servicio;	
		}catch(Exception e){
			e.printStackTrace();
			return servicio;
		}
	}
	
	private static String buscarDias(JSONObject servicio){
		String dias = "";
		JSONArray arrayHorario = servicio.getJSONArray("horarios");
		JSONObject horario = (JSONObject) arrayHorario.get(0);
		dias = diaPorNumero(horario.getInt("diaSemana")+1);
		return dias;
	}
	
	private static String buscarHoraDesde(JSONObject servicio){
		String hora = "";
		JSONArray arrayHorario = servicio.getJSONArray("horarios");
		JSONObject horario = (JSONObject) arrayHorario.get(0);
		hora = Integer.toString(horario.getInt("horaDesde"));
		return hora;
	}
	
	private static String buscarHoraHasta(JSONObject servicio){
		String hora = "";
		JSONArray arrayHorario = servicio.getJSONArray("horarios");
		JSONObject horario = (JSONObject) arrayHorario.get(0);
		hora = Integer.toString(horario.getInt("horaHasta"));
		return hora;
	}
}
