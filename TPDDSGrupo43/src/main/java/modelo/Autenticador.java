package modelo;

public class Autenticador {
	
	public static boolean controlarPermisos(int idUsuario, int idAccion){
		boolean valid = false;
			valid = Accion_x_Usuario.chequeoAccionDeUsuario(idUsuario, idAccion);
		return valid; 
	}

}
