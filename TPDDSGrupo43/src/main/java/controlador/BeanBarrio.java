package controlador;

public class BeanBarrio {
	
	private int IdBarrio;
	private String BarrioDescripcion;
	private int BarrioIdLocalidad;
	private int BarrioIdComuna;
	private BeanComuna BarrioComuna;
	public int getIdBarrio() {
		return IdBarrio;
	}
	public void setIdBarrio(int idBarrio) {
		IdBarrio = idBarrio;
	}
	public String getBarrioDescripcion() {
		return BarrioDescripcion;
	}
	public void setBarrioDescripcion(String barrioDescripcion) {
		BarrioDescripcion = barrioDescripcion;
	}
	public int getBarrioIdLocalidad() {
		return BarrioIdLocalidad;
	}
	public void setBarrioIdLocalidad(int barrioIdLocalidad) {
		BarrioIdLocalidad = barrioIdLocalidad;
	}
	public int getBarrioIdComuna() {
		return BarrioIdComuna;
	}
	public void setBarrioIdComuna(int barrioIdComuna) {
		BarrioIdComuna = barrioIdComuna;
	}
	public BeanComuna getBarrioComuna() {
		return BarrioComuna;
	}
	public void setBarrioComuna(BeanComuna barrioComuna) {
		BarrioComuna = barrioComuna;
	}
	public BeanBarrio(int idBarrio, String barrioDescripcion, int barrioIdLocalidad, int barrioIdComuna) {
		super();
		IdBarrio = idBarrio;
		BarrioDescripcion = barrioDescripcion;
		BarrioIdLocalidad = barrioIdLocalidad;
		BarrioIdComuna = barrioIdComuna;
	}
	
	public BeanBarrio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
