package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Proceso1 extends ProcesoStr {

	@Override
	public void procesar() {
		
		String nombreFantasia = "Kiosco El Turco";
		String tags = "kiosco1;turco1;atencion1;caramelos1;cerveza";
		
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			
			ResultSet rs;
			rs=st.executeQuery("select IdPoi from poi where PoiDescripcion='"+nombreFantasia+"';");

			Integer ru=st.executeUpdate("update servicio SET ServicioTags='" +tags+"' where ServicioIdPoi="+rs+";");
			
			if(ru == 1){
			}
		}catch(Exception se){
			se.printStackTrace();
		}
		

	}

}
