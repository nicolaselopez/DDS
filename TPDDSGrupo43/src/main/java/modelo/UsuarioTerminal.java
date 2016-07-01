package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
	public void realizarBusqueda(String frase){
		Servicio servicio = new Servicio();
		servicio.consultarServiciosTag(frase);
		RegistroConsulta consulta = new RegistroConsulta(this.getIdUsuario(),servicio.getServicioIdPoi(),"Búsqueda por tag","Detalle",servicio.getTiempoBusqueda());
		consulta.registrarConsulta(consulta); // Esta de más?
		int cantidadResultados = servicio.consultarServiciosTag(frase).length;
		consulta.setResultadoConsulta(frase, cantidadResultados, servicio.getTiempoBusqueda());
	}
	//--------------------------------------------------------30/06-MM-
	
}
