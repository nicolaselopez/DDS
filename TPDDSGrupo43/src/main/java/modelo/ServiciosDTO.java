package modelo;

public class ServiciosDTO {

	protected String descripcion;
	protected rangoServicioDTO[] rangoServicio;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public rangoServicioDTO[] getRangoServicio() {
		return rangoServicio;
	}
	public void setRangoServicio(rangoServicioDTO[] rangoServicio) {
		this.rangoServicio = rangoServicio;
	}
	
	
	
}
