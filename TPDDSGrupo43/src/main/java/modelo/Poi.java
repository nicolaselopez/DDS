package modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Barrio;
import modelo.Rubro;
import modelo.Servicio;

public class Poi {
	
	protected int IdPoi;
	protected int PoiIdTipoPoi;
	protected String PoiDescripcion;
	protected int PoiIdRubro;
	protected Rubro PoiRubro;
	protected Servicio[] PoiServicio;
	protected Direccion PoiDireccion;
	protected Barrio PoiBarrio;
	protected String PoiLatitudGeo;
	protected String PoiLongitudGeo;
	protected String PoiFechaAlta;
	protected String PoiFechaModificacion;
	protected int PoiActivo;
	
	public int getIdPoi() {
		return IdPoi;
	}

	public void setIdPoi(int idPoi) {
		IdPoi = idPoi;
	}

	public int getPoiIdTipoPoi() {
		return PoiIdTipoPoi;
	}

	public void setPoiIdTipoPoi(int poiIdTipoPoi) {
		PoiIdTipoPoi = poiIdTipoPoi;
	}

	public String getPoiDescripcion() {
		return PoiDescripcion;
	}

	public void setPoiDescripcion(String poiDescripcion) {
		PoiDescripcion = poiDescripcion;
	}

	public int getPoiIdRubro() {
		return PoiIdRubro;
	}

	public void setPoiIdRubro(int poiIdRubro) {
		PoiIdRubro = poiIdRubro;
	}

	public Rubro getPoiRubro() {
		return PoiRubro;
	}

	public void setPoiRubro(Rubro poiRubro) {
		PoiRubro = poiRubro;
	}

	public Direccion getPoiDireccion() {
		return PoiDireccion;
	}

	public void setPoiDireccion(Direccion poiDireccion) {
		PoiDireccion = poiDireccion;
	}

	public Servicio[] getPoiServicio() {
		return PoiServicio;
	}

	public void setPoiServicio(Servicio[] poiServicio) {
		PoiServicio = poiServicio;
	}

	public Barrio getPoiBarrio() {
		return PoiBarrio;
	}

	public void setPoiBarrio(Barrio poiBarrio) {
		PoiBarrio = poiBarrio;
	}

	public String getPoiLatitudGeo() {
		return PoiLatitudGeo;
	}

	public void setPoiLatitudGeo(String poiLatitudGeo) {
		PoiLatitudGeo = poiLatitudGeo;
	}

	public String getPoiLongitudGeo() {
		return PoiLongitudGeo;
	}

	public void setPoiLongitudGeo(String poiLongitudGeo) {
		PoiLongitudGeo = poiLongitudGeo;
	}

	public String getPoiFechaAlta() {
		return PoiFechaAlta;
	}

	public void setPoiFechaAlta(String poiFechaAlta) {
		PoiFechaAlta = poiFechaAlta;
	}

	public String getPoiFechaModificacion() {
		return PoiFechaModificacion;
	}

	public void setPoiFechaModificacion(String poiFechaModificacion) {
		PoiFechaModificacion = poiFechaModificacion;
	}

	public int getPoiActivo() {
		return PoiActivo;
	}

	public void setPoiActivo(int poiActivo) {
		PoiActivo = poiActivo;
	}

	public Poi(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Rubro poiRubro,
			Servicio[] poiServicio,Direccion poiDireccion, Barrio poiBarrio,
			String poiLatitudGeo, String poiLongitudGeo, String poiFechaAlta,
			String poiFechaModificacion, int poiActivo) {
		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiRubro = poiRubro;
		PoiServicio = poiServicio;
		PoiDireccion = poiDireccion;
		PoiBarrio = poiBarrio;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
	}
	
	

	public Poi(int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Direccion poiDireccion, String poiLatitudGeo, String poiLongitudGeo, int poiActivo) {
		super();
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiDireccion = poiDireccion;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiActivo = poiActivo;
	}
	
	public Poi(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Direccion poiDireccion, String poiLatitudGeo, String poiLongitudGeo, int poiActivo) {
		super();
		IdPoi = idPoi; 
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiDireccion = poiDireccion;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiActivo = poiActivo;
	}
	
	public Poi(Poi poi) {
		super();
		IdPoi = poi.getIdPoi();
		PoiIdTipoPoi = poi.getPoiIdTipoPoi();
		PoiDescripcion = poi.getPoiDescripcion();
		PoiIdRubro = poi.getPoiIdRubro();
		PoiDireccion = poi.getPoiDireccion();
		PoiLatitudGeo = poi.getPoiLatitudGeo();
		PoiLongitudGeo = poi.getPoiLongitudGeo();
		PoiFechaAlta = poi.getPoiFechaAlta();
		PoiFechaModificacion = poi.getPoiFechaModificacion();
		PoiActivo = poi.getPoiActivo();
	}

	public Poi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Poi(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Direccion poiDireccion, 
			String poiLatitudGeo, String poiLongitudGeo, String poiFechaAlta,
			String poiFechaModificacion, int poiActivo) {
		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiDireccion = poiDireccion;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
	}
	
	public static Poi[] consultarPois(){
		Poi[] pois = new Poi[5000];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from poi");
			int i=0;
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				pois[i]=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));
				i++;
			}
			rs=st.executeQuery("Select * from bancoexterno");
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccionBancoExterno(rs);
				pois[i]=new Poi(rs.getInt(1),rs.getInt(2),rs.getString(3),3,poiDireccion,rs.getString(6),rs.getString(7),rs.getInt(10));
				i++;
			}
			Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
			for(int j=0;j<cgpExterno.length;j++){
				pois[i] = cgpExterno[j];
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new Poi();
				pois[k].setIdPoi(-1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return pois;
	}
	
	public static Poi[] consultarPoisServicio(Boolean poiActivo, Boolean servicioActivo){
		Poi[] pois = new Poi[5000];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs;
			if(poiActivo){
				rs=st.executeQuery("Select * from poi where PoiActivo = 1");
			}else{
				rs=st.executeQuery("Select * from poi");
			}
			int i=0;
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				pois[i]=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));
				pois[i].setPoiServicio(Servicio.consultarServicios(pois[i].getIdPoi(),false,servicioActivo));
				i++;
			}
			Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
			for(int j=0;j<cgpExterno.length;j++){
				pois[i] = cgpExterno[j];
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new Poi();
				pois[k].setIdPoi(-1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return pois;
	}
	
	public static Poi[] consultarPoisporEstado(int estado){
		Poi[] pois = new Poi[5000];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from poi where PoiActivo =" + estado + ";");
			int i=0;
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				pois[i]=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));
				i++;
			}
			rs=st.executeQuery("Select * from bancoexterno");
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccionBancoExterno(rs);
				pois[i]=new Poi(rs.getInt(1),rs.getInt(2),rs.getString(3),3,poiDireccion,rs.getString(6),rs.getString(7),rs.getInt(10));
				i++;
			}
			Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
			for(int j=0;j<cgpExterno.length;j++){
				pois[i] = cgpExterno[j];
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new Poi();
				pois[k].setIdPoi(-1);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return pois;
	}
	
	public static Poi buscarPoi(int idPoi){
		Poi poi=null;
		Boolean externo = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from poi where idPoi=" + idPoi + ";");
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				poi=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));

			}
			if(poi == null){
				rs=st.executeQuery("Select * from bancoexterno where IdPoiExterno="+ idPoi + ";");
				while(rs.next()){
					Direccion poiDireccion = Direccion.parametrizarDireccionBancoExterno(rs);
					poi=new Poi(rs.getInt(1),rs.getInt(2),rs.getString(3),3,poiDireccion,rs.getString(6),rs.getString(7),rs.getInt(10));
					externo = true;
				}
			}if(poi != null){
				poi.setPoiBarrio(Barrio.consultarBarrio(poi.getPoiDireccion().getPoiIdBarrio()));
				poi.setPoiServicio(Servicio.consultarServicios(idPoi,externo,true));
			}
			if(poi!=null && poi.getPoiIdTipoPoi()==4){
				poi.setPoiRubro(Rubro.consultarRubro(poi.getPoiIdRubro()));
			}if(poi == null){
				Poi[] cgpExterno = CGPAdapter.consultaCentroWS();
				for(int j=0;j<cgpExterno.length;j++){
					if(cgpExterno[j].getIdPoi() == idPoi){
						poi = cgpExterno[j];
					}
				}
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return poi;
	}

	public static Boolean editarPoi(Poi poi){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			
			Integer rs=st.executeUpdate("UPDATE poi SET "+
				"PoiIdTipoPoi = "+poi.getPoiIdTipoPoi()+" , PoiDescripcion = '"+poi.getPoiDescripcion()+
				"' , PoiIdRubro = "+poi.getPoiIdRubro()+" , PoiCalle = '"+poi.getPoiDireccion().getPoiCalle()+
				"' , PoiNumero = '"+poi.getPoiDireccion().getPoiNumero()+"' , PoiPiso = '" + poi.getPoiDireccion().getPoiPiso()+
				"' , PoiDepto = '"+poi.getPoiDireccion().getPoiDepto()+"' , PoiUnidad = '"+poi.getPoiDireccion().getPoiUnidad()+
				"' , PoiCodPos = '"+poi.getPoiDireccion().getPoiCodPos()+"' , PoiIdLocalidad = "+poi.getPoiDireccion().getPoiIdLocalidad()+
				"  , PoiIdBarrio = "	+poi.getPoiDireccion().getPoiIdBarrio()+" , PoiIdProvincia = "+poi.getPoiDireccion().getPoiIdProvincia()+
				"  , PoiIdPais = "+poi.getPoiDireccion().getPoiIdPais()+" , PoiLatitudGeo = '"+poi.getPoiLatitudGeo()+
				"' , PoiLongitudGeo = '"+poi.getPoiLongitudGeo()+"' , PoiActivo = "+poi.getPoiActivo()+
				" where IdPoi = " + poi.getIdPoi() + " ;");
			
			if(rs == 1){
				OK = true;
			}			
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	
	public static Boolean registrarPoi(Poi poi){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO poi "+
				"(PoiIdTipoPoi,PoiDescripcion,PoiIdRubro,PoiCalle,PoiNumero,PoiPiso,PoiDepto,PoiUnidad,"+
				"PoiCodPos,PoiIdLocalidad,PoiIdBarrio,PoiIdProvincia,PoiIdPais,PoiLatitudGeo,PoiLongitudGeo,PoiActivo) "+
				"VALUES "+
				"("+poi.getPoiIdTipoPoi()+",'"+poi.getPoiDescripcion()+"',"+poi.getPoiIdRubro()+",'"+poi.getPoiDireccion().getPoiCalle()+"','"+poi.getPoiDireccion().getPoiNumero()+"','"
				+poi.getPoiDireccion().getPoiPiso()+"','"+poi.getPoiDireccion().getPoiDepto()+"','"+poi.getPoiDireccion().getPoiUnidad()+"','"+poi.getPoiDireccion().getPoiCodPos()+"',"+poi.getPoiDireccion().getPoiIdLocalidad()+","
				+poi.getPoiDireccion().getPoiIdBarrio()+","+poi.getPoiDireccion().getPoiIdProvincia()+","+poi.getPoiDireccion().getPoiIdPais()+",'"+poi.getPoiLatitudGeo()+"','"
				+poi.getPoiLongitudGeo()+"',"+poi.getPoiActivo()+") ; ");
			if(rs == 1){
				OK = true;
			}
			if(poi.getPoiServicio() != null){
				OK = false;
				for(int i=0; i<poi.getPoiServicio().length;i++){
					rs = st.executeUpdate("INSERT INTO servicio(ServicioIdPoi,ServicioIdTipoPoi,ServicioDescripcion,"
							+"ServicioDiaDisponible,ServicioHoraDesde1,ServicioHoraHasta1,ServicioHoraDesde2,"
							+"ServicioHoraHasta2,ServicioTags,ServicioFechaAlta,ServicioFechaModificacion,"
							+"ServicioActivo)VALUES("
							+poi.getPoiServicio()[i].getServicioIdPoi()+","+poi.getPoiServicio()[i].getServicioIdTipoPoi()+","+poi.getPoiServicio()[i].getServicioDescripcion()+","
							+poi.getPoiServicio()[i].getServicioDiaDisponible()+","+poi.getPoiServicio()[i].getServicioHoraDesde1()+","+poi.getPoiServicio()[i].getServicioHoraHasta1()+","
							+poi.getPoiServicio()[i].getServicioHoraDesde2()+","+poi.getPoiServicio()[i].getServicioHoraHasta2()+","+poi.getPoiServicio()[i].getServicioTags()+","+","+poi.getPoiServicio()[i].getServicioActivo()+");");
				}
				if(rs == 1){
					OK = true;
				}
			}				
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	
	public Boolean calcularDistanciaPoi(Poi poi, LatLng latLngPos,LatLng latLngPoi, int comuna){
		Boolean OK = false;
		OK = calcularDistanciaTipoPoi(poi,latLngPos,latLngPoi,comuna);
		return OK;
	}
	
	private Boolean calcularDistanciaTipoPoi(Poi poi,LatLng latLngPos,LatLng latLngPoi, int comuna){
		Boolean OK = false;
		
		switch(poi.getPoiIdTipoPoi()){
		case 1:poi = new Colectivo(poi); OK = ((Colectivo)poi).calcularDistanciaPoi(poi, latLngPos, latLngPoi, comuna);break;
		case 2:poi = new CGP(poi); OK = ((CGP)poi).calcularDistanciaPoi(poi, latLngPos, latLngPoi, comuna);break;
		case 3:poi = new Banco(poi); OK = ((Banco)poi).calcularDistanciaPoi(poi, latLngPos, latLngPoi, comuna);break;
		case 4:poi = new LocalComercial(poi); OK= ((LocalComercial)poi).calcularDistanciaPoi(poi, latLngPos, latLngPoi, comuna);break;
		default: OK=false;break;
		}
		return OK;
	}

	public Boolean calcularDisponibilidadPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Boolean OK = false;
		OK = calcularDisponibilidadTipoPoi(poi, request, response);
		return OK;
	}
	
	private Boolean calcularDisponibilidadTipoPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Boolean OK = false;
		
		switch(poi.getPoiIdTipoPoi()){
		case 1:poi = new Colectivo(poi); OK = ((Colectivo)poi).calcularDisponibilidadPoi(poi, request, response);break;
		case 2:poi = new CGP(poi); OK = ((CGP)poi).calcularDisponibilidadPoi(poi, request, response);break;
		case 3:poi = new Banco(poi); OK = ((Banco)poi).calcularDisponibilidadPoi(poi, request, response);break;
		case 4:poi = new LocalComercial(poi); OK= ((LocalComercial)poi).calcularDisponibilidadPoi(poi, request, response);break;
		default: OK=false;break;
		}
		return OK;
	}
//--------------------------	
	public static Boolean editarEstadoPoi(int idPoi , int estado){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("UPDATE poi SET PoiActivo =" + estado + " where IdPoi = " + idPoi + ";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}

	public static String getJSP(Poi poi) {
		
		switch(poi.getPoiIdTipoPoi()){
		case 1: return Colectivo.getJSP();
		case 2: return CGP.getJSP();
		case 3: return Banco.getJSP();
		case 4: return LocalComercial.getJSP();
		default: return"verPoi.jsp";
		}
	}
		
}
