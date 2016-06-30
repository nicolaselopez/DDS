package modelo;

public class UsuarioAdministrador extends Usuario {
	
	// Desactivar Terminal
	public void darDeBajaUsuarioTerminal(UsuarioTerminal usuario){
		usuario.DesactivarTerminal();
	}
	
	// Recibir Notificaciones
}
