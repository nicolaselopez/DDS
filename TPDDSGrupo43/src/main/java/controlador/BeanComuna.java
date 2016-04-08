package controlador;

public class BeanComuna {
	
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
	
	public BeanComuna(int idComuna, String comunaDescripcion) {
		super();
		IdComuna = idComuna;
		ComunaDescripcion = comunaDescripcion;
	}
	
	public BeanComuna(String comunaDescripcion) {
		super();
		ComunaDescripcion = comunaDescripcion;
	}
	
	public BeanComuna() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
