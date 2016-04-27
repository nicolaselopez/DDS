package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Barrio;
import modelo.Rubro;
import modelo.Servicio;

public class Poi {
	
	private int IdPoi;
	private int PoiIdTipoPoi;
	private String PoiDescripcion;
	private int PoiIdRubro;
	private Rubro PoiRubro;
	private Servicio[] PoiServicio;
	private Direccion PoiDireccion;
	private Barrio PoiBarrio;
	private String PoiLatitudGeo;
	private String PoiLongitudGeo;
	private String PoiFechaAlta;
	private String PoiFechaModificacion;
	private int PoiActivo;
	
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
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from poi where idPoi=" + idPoi + ";");
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				poi=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));

			}
			if(poi != null){
				poi.setPoiBarrio(Barrio.consultarBarrio(poi.getPoiDireccion().getPoiIdBarrio()));
				poi.setPoiServicio(Servicio.consultarServicios(idPoi));
			}
			if(poi!=null && poi.getPoiIdTipoPoi()==4){
				poi.setPoiRubro(Rubro.consultarRubro(poi.getPoiIdRubro()));
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return poi;
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
				+poi.getPoiLongitudGeo()+"',"+poi.getPoiActivo()+");");
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

}
