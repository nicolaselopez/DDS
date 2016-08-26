package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.List;

public class Proceso3 extends ProcesoStr {

	@Override
	public void procesar(String usu, LoteAcciones acciones) {
		boolean OK = false;
		Usuario usuario = Usuario.consultarUsuario(usu);
		int secuencial = buscarAccionDeUsuario(usuario.getIdUsuario());
		if(secuencial != 0){
			OK = modificarSecuencial(usuario.getIdUsuario(),secuencial,0); 
		}
		OK = darAltaAcciones(usuario.getIdUsuario(),acciones,secuencial+1);
		Accion_x_Usuario AxU = new Accion_x_Usuario(); // Instanciar vacio
		UsuarioAdministrador admin = new UsuarioAdministrador();
		AxU.iniciarProcesoDe(admin);
	}
	
	private static int buscarAccionDeUsuario(int usuario){
		int secuencial = 0;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select MAX(Secuencial) from acciones_x_usuario where Usuario="+ usuario +" and Activo=1");
			while(rs.next()){
				secuencial = rs.getInt(1);
			}
		}catch(Exception se){
			se.printStackTrace();
		}
		return secuencial;
	}
	
	private static boolean darAltaAcciones(int usuario, LoteAcciones acciones, int secuencial){
		boolean OK = false;
		OK = acciones.registrarAcciones(usuario,secuencial);
		return OK;
	}
	
	private static boolean modificarSecuencial(int usuario, int secuencial, int activo){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("UPDATE acciones_x_usuario SET Activo = "+activo+" where Usuario = " + usuario + " and Secuencial = "+ secuencial +";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}
	
	public boolean rollback(String usu){
		boolean OK = false;
		Usuario usuario = Usuario.consultarUsuario(usu);
		int secuencial = buscarAccionDeUsuario(usuario.getIdUsuario());
		if(secuencial != 0){
			OK = borrarSecuencial(usuario.getIdUsuario(),secuencial);
			if(secuencial > 1){
				OK = modificarSecuencial(usuario.getIdUsuario(),secuencial-1,1); 
			}
		}
		return OK;
	}
	
	private static boolean borrarSecuencial(int usuario, int secuencial){
		Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("DELETE FROM acciones_x_usuario where Usuario = " + usuario + " and Secuencial = "+ secuencial +";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		return OK;
	}

}	



/*
Este proceso tiene como objetivo agregar una lista acciones que puede realizar
 cada Usuario en el Sistema. Este proceso est vinculado a la Entrega 3.  
 Dada una lista de Acciones por Usuario el proceso debe asignar/actualizar las acciones
 que puede realizar cada Usuario. Se debe considerar la posibilidad de deshacer esta 
 acci (undo) y que vuelva todo al estado original.
*/