package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioTerminal extends Usuario {
	
	// Desactivar Terminal (era public static)
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
	
}
