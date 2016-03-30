package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jasypt.util.password.BasicPasswordEncryptor;

import controlador.BeanUsuario;

public class Usuario {
	
	public static BeanUsuario consultarUsuario(String usuario){
		BeanUsuario busuario=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from usuarios where usuario='"+usuario+"'");
			while(rs.next()){
				busuario=new BeanUsuario(rs.getString(5), null, rs.getString(4), usuario, rs.getString(3));
			}
		}catch(SQLException se){
			se.printStackTrace();
			busuario.setUsuario(se.getLocalizedMessage());
		}
		return busuario;
	}
	
	public static Boolean registrarUsuario(BeanUsuario usuario){
		Boolean OK = false;
		BasicPasswordEncryptor encriptador = new BasicPasswordEncryptor();
		usuario.setClave(encriptador.encryptPassword(usuario.getClave()));
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO usuarios (usuario, password, email, nombre, fechanac) VALUES "
					+ "('"+usuario.getUsuario()+"','"+usuario.getClave()+"','"+usuario.getCorreo()+"','"+usuario.getNombre()+"',"+usuario.getEdad()+");");
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
