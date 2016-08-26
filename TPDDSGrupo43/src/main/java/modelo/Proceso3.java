package modelo;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.List;

public class Proceso3 extends ProcesoStr {

	@Override
	public void procesar() {
		
		Accion_x_Usuario AxU = new Accion_x_Usuario(); // Instanciar vacio?
		UsuarioAdministrador admin = new UsuarioAdministrador();
		AxU.iniciarProcesoDe(admin);
	}

}	



/*
Este proceso tiene como objetivo agregar una lista acciones que puede realizar
 cada Usuario en el Sistema. Este proceso está vinculado a la Entrega 3.  
 Dada una lista de Acciones por Usuario el proceso debe asignar/actualizar las acciones
 que puede realizar cada Usuario. Se debe considerar la posibilidad de deshacer esta 
 acción (undo) y que vuelva todo al estado original.
*/