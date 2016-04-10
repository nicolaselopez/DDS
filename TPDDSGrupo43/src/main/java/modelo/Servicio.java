package modelo;

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
	
	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
