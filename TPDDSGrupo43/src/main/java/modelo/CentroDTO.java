package modelo;

public class CentroDTO {

	protected int columna;
	protected String zonas;
	protected String nombreDirector;
	protected String direccionCompleta;
	protected String telefono;
	protected ServiciosDTO[] servicios;
	
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public String getZonas() {
		return zonas;
	}
	public void setZonas(String zonas) {
		this.zonas = zonas;
	}
	public String getNombreDirector() {
		return nombreDirector;
	}
	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}
	public String getDireccionCompleta() {
		return direccionCompleta;
	}
	public void setDireccionCompleta(String direccionCompleta) {
		this.direccionCompleta = direccionCompleta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ServiciosDTO[] getServicios() {
		return servicios;
	}
	public void setServicios(ServiciosDTO[] servicios) {
		this.servicios = servicios;
	}
	
}
