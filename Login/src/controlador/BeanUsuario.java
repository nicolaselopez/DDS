package controlador;

public class BeanUsuario {
	
	private String nombre;
	private String edad;
	private String correo;
	private String usuario;
	private String clave;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public BeanUsuario(String nombre, String edad,
			String correo, String usuario, String clave) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}
	public BeanUsuario() {
		// TODO Auto-generated constructor stub
		super();
		this.nombre ="";
		this.edad ="";
		this.correo ="";
		this.usuario ="";
		this.clave ="";
	}

}
