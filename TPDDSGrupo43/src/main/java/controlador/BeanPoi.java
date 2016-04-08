package controlador;

public class BeanPoi {
	
	private int IdPoi;
	private int PoiIdTipoPoi;
	private String PoiDescripcion;
	private int PoiIdRubro;
	private BeanRubro PoiRubro;
	private BeanServicio[] PoiServicio;
	private String PoiCalle;
	private String PoiNumero;
	private String PoiPiso;
	private String PoiDepto;
	private String PoiUnidad;
	private String PoiCodPos;
	private int PoiIdLocalidad;
	private int PoiIdBarrio;
	private BeanBarrio PoiBarrio;
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
	
	
	public BeanRubro getPoiRubro() {
		return PoiRubro;
	}
	public void setPoiRubro(BeanRubro poiRubro) {
		PoiRubro = poiRubro;
	}
	public BeanServicio[] getPoiServicio() {
		return PoiServicio;
	}
	public void setPoiServicio(BeanServicio[] poiServicio) {
		PoiServicio = poiServicio;
	}
	public BeanBarrio getPoiBarrio() {
		return PoiBarrio;
	}
	public void setPoiBarrio(BeanBarrio poiBarrio) {
		PoiBarrio = poiBarrio;
	}
	public BeanPoi(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, String poiCalle,
			String poiNumero, String poiPiso, String poiDepto, String poiUnidad, String poiCodPos, int poiIdLocalidad,
			int poiIdBarrio, int poiIdProvincia, int poiIdPais, String poiLatitudGeo, String poiLongitudGeo,
			String poiFechaAlta, String poiFechaModificacion, int poiActivo) {
		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiCalle = poiCalle;
		PoiNumero = poiNumero;
		PoiPiso = poiPiso;
		PoiDepto = poiDepto;
		PoiUnidad = poiUnidad;
		PoiCodPos = poiCodPos;
		PoiIdLocalidad = poiIdLocalidad;
		PoiIdBarrio = poiIdBarrio;
		PoiIdProvincia = poiIdProvincia;
		PoiIdPais = poiIdPais;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
	}
	
	public BeanPoi() {
		super();
		// TODO Auto-generated constructor stub
	}	
	

}
