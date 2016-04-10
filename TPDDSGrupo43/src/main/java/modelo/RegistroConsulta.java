package modelo;

public class RegistroConsulta {
	
	private int IdRegistroConsulta;
	private int RegConIdUsuario;
	private int RegConIdPoi;
	private String RegConFechaConsulta;
	
	public int getIdRegistroConsulta() {
		return IdRegistroConsulta;
	}
	public void setIdRegistroConsulta(int idRegistroConsulta) {
		IdRegistroConsulta = idRegistroConsulta;
	}
	public int getRegConIdUsuario() {
		return RegConIdUsuario;
	}
	public void setRegConIdUsuario(int regConIdUsuario) {
		RegConIdUsuario = regConIdUsuario;
	}
	public int getRegConIdPoi() {
		return RegConIdPoi;
	}
	public void setRegConIdPoi(int regConIdPoi) {
		RegConIdPoi = regConIdPoi;
	}
	public String getRegConFechaConsulta() {
		return RegConFechaConsulta;
	}
	public void setRegConFechaConsulta(String regConFechaConsulta) {
		RegConFechaConsulta = regConFechaConsulta;
	}
	
	public RegistroConsulta(int idRegistroConsulta, int regConIdUsuario, int regConIdPoi,
			String regConFechaConsulta) {
		super();
		IdRegistroConsulta = idRegistroConsulta;
		RegConIdUsuario = regConIdUsuario;
		RegConIdPoi = regConIdPoi;
		RegConFechaConsulta = regConFechaConsulta;
	}
	
	public RegistroConsulta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
