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
	private String PoiCalle;
	private String PoiNumero;
	private String PoiPiso;
	private String PoiDepto;
	private String PoiUnidad;
	private String PoiCodPos;
	private int PoiIdLocalidad;
	private int PoiIdBarrio;
	private Barrio PoiBarrio;
	private int PoiIdProvincia;
	private int PoiIdPais;
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

	public Servicio[] getPoiServicio() {
		return PoiServicio;
	}

	public void setPoiServicio(Servicio[] poiServicio) {
		PoiServicio = poiServicio;
	}

	public String getPoiCalle() {
		return PoiCalle;
	}

	public void setPoiCalle(String poiCalle) {
		PoiCalle = poiCalle;
	}

	public String getPoiNumero() {
		return PoiNumero;
	}

	public void setPoiNumero(String poiNumero) {
		PoiNumero = poiNumero;
	}

	public String getPoiPiso() {
		return PoiPiso;
	}

	public void setPoiPiso(String poiPiso) {
		PoiPiso = poiPiso;
	}

	public String getPoiDepto() {
		return PoiDepto;
	}

	public void setPoiDepto(String poiDepto) {
		PoiDepto = poiDepto;
	}

	public String getPoiUnidad() {
		return PoiUnidad;
	}

	public void setPoiUnidad(String poiUnidad) {
		PoiUnidad = poiUnidad;
	}

	public String getPoiCodPos() {
		return PoiCodPos;
	}

	public void setPoiCodPos(String poiCodPos) {
		PoiCodPos = poiCodPos;
	}

	public int getPoiIdLocalidad() {
		return PoiIdLocalidad;
	}

	public void setPoiIdLocalidad(int poiIdLocalidad) {
		PoiIdLocalidad = poiIdLocalidad;
	}

	public int getPoiIdBarrio() {
		return PoiIdBarrio;
	}

	public void setPoiIdBarrio(int poiIdBarrio) {
		PoiIdBarrio = poiIdBarrio;
	}

	public Barrio getPoiBarrio() {
		return PoiBarrio;
	}

	public void setPoiBarrio(Barrio poiBarrio) {
		PoiBarrio = poiBarrio;
	}

	public int getPoiIdProvincia() {
		return PoiIdProvincia;
	}

	public void setPoiIdProvincia(int poiIdProvincia) {
		PoiIdProvincia = poiIdProvincia;
	}

	public int getPoiIdPais() {
		return PoiIdPais;
	}

	public void setPoiIdPais(int poiIdPais) {
		PoiIdPais = poiIdPais;
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
			Servicio[] poiServicio, String poiCalle, String poiNumero, String poiPiso, String poiDepto,
			String poiUnidad, String poiCodPos, int poiIdLocalidad, int poiIdBarrio, Barrio poiBarrio,
			int poiIdProvincia, int poiIdPais, String poiLatitudGeo, String poiLongitudGeo, String poiFechaAlta,
			String poiFechaModificacion, int poiActivo) {
		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiRubro = poiRubro;
		PoiServicio = poiServicio;
		PoiCalle = poiCalle;
		PoiNumero = poiNumero;
		PoiPiso = poiPiso;
		PoiDepto = poiDepto;
		PoiUnidad = poiUnidad;
		PoiCodPos = poiCodPos;
		PoiIdLocalidad = poiIdLocalidad;
		PoiIdBarrio = poiIdBarrio;
		PoiBarrio = poiBarrio;
		PoiIdProvincia = poiIdProvincia;
		PoiIdPais = poiIdPais;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
	}
	

	public Poi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Boolean registrarPoi(Poi poi){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			poi.setPoiActivo(1);
			Integer rs=st.executeUpdate("INSERT INTO poi "+
				"(PoiIdTipoPoi,PoiDescripcion,PoiIdRubro,PoiCalle,PoiNumero,PoiPiso,PoiDepto,PoiUnidad,"+
				"PoiCodPos,PoiIdLocalidad,PoiIdBarrio,PoiIdProvincia,PoiIdPais,PoiLatitudGeo,PoiLongitudGeo,PoiActivo) "+
				"VALUES "+
				"("+poi.getPoiIdTipoPoi()+",'"+poi.getPoiDescripcion()+"',"+poi.getPoiIdRubro()+",'"+poi.getPoiCalle()+"','"+poi.getPoiNumero()+"',"
				+poi.getPoiPiso()+","+poi.getPoiDepto()+","+poi.getPoiUnidad()+","+poi.getPoiCodPos()+","+poi.getPoiIdLocalidad()+","
				+poi.getPoiIdBarrio()+","+poi.getPoiIdProvincia()+","+poi.getPoiIdPais()+","+poi.getPoiLatitudGeo()+","
				+poi.getPoiLongitudGeo()+","+poi.getPoiFechaAlta()+","+poi.getPoiFechaModificacion()+","+poi.getPoiActivo()+");");
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
