package modelo;

public class Comuna {
	
	private int IdComuna;
	private String ComunaDescripcion;
	
	public int getIdComuna() {
		return IdComuna;
	}
	public void setIdComuna(int idComuna) {
		IdComuna = idComuna;
	}
	public String getComunaDescripcion() {
		return ComunaDescripcion;
	}
	public void setComunaDescripcion(String comunaDescripcion) {
		ComunaDescripcion = comunaDescripcion;
	}
	
	public Comuna(int idComuna, String comunaDescripcion) {
		super();
		IdComuna = idComuna;
		ComunaDescripcion = comunaDescripcion;
	}
	
	public Comuna(String comunaDescripcion) {
		super();
		ComunaDescripcion = comunaDescripcion;
	}
	
	public Comuna() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
