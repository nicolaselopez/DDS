package controlador;

public class BeanRubro {
	
	private int IdRubro;
	private String RubroDescripcion;
	private int RubroRadioCercania;
	public int getIdRubro() {
		return IdRubro;
	}
	public void setIdRubro(int idRubro) {
		IdRubro = idRubro;
	}
	public String getRubroDescripcion() {
		return RubroDescripcion;
	}
	public void setRubroDescripcion(String rubroDescripcion) {
		RubroDescripcion = rubroDescripcion;
	}
	public int getRubroRadioCercania() {
		return RubroRadioCercania;
	}
	public void setRubroRadioCercania(int rubroRadioCercania) {
		RubroRadioCercania = rubroRadioCercania;
	}
	
	public BeanRubro(int idRubro, String rubroDescripcion, int rubroRadioCercania) {
		super();
		IdRubro = idRubro;
		RubroDescripcion = rubroDescripcion;
		RubroRadioCercania = rubroRadioCercania;
	}
	
	public BeanRubro() {
		super();
		// TODO Auto-generated constructor stub
	}

}
