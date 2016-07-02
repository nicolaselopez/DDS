package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsuarioTerminal extends Usuario {
	
	
	// Desactivar Terminal (era public static, afecta?)
	public  Boolean DesactivarTerminal(){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			
			Integer rs=st.executeUpdate("UPDATE usuario SET where rol = "+ this.getRol() +
				"activo = "+0+" ;");
			
			if(rs == 1){
				OK = true;
			}			
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	//--------------------------------------------------------30/06-MM-
	/*public static Servicio[] realizarBusqueda(String frase)
	{
		Servicio[] servicios = Servicio.consultarServiciosTag(frase);
		
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	    
		RegistroConsulta consulta = new RegistroConsulta(1,1,"Búsqueda por tag","Detalle",1,ft.toString());
	
		
		RegistroConsulta.registrarConsulta(consulta);
		
		return servicios;
	}
	//--------------------------------------------------------30/06-MM-*/
	
}
