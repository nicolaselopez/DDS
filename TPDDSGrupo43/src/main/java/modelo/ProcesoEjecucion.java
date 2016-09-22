package modelo;

public class ProcesoEjecucion {
	
	private int proceso;
	private String parametros;
	private int usuario;
	private int idagenda;
	
	
	
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	public int getIdagenda() {
		return idagenda;
	}
	public void setIdagenda(int idagenda) {
		this.idagenda = idagenda;
	}
	public int getProceso() {
		return proceso;
	}
	public void setProceso(int proceso) {
		this.proceso = proceso;
	}
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	
	public ProcesoEjecucion(int proceso, String parametros, int usuario, int idagenda) {
		super();
		this.proceso = proceso;
		this.parametros = parametros;
		this.usuario = usuario;
		this.idagenda = idagenda;
	}	

}
