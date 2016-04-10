package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Rubro {

	private int IdRubro;
	private String RubroDescripcion;
	private int RubroRadioCercania;
	public int getIdRubro() {
		return IdRubro;
	}
	public void setIdRubro(int idRubro) {
		IdRubro = idRubro;
	}
	public String getRubroDescripcion() {
		return RubroDescripcion;
	}
	public void setRubroDescripcion(String rubroDescripcion) {
		RubroDescripcion = rubroDescripcion;
	}
	public int getRubroRadioCercania() {
		return RubroRadioCercania;
	}
	public void setRubroRadioCercania(int rubroRadioCercania) {
		RubroRadioCercania = rubroRadioCercania;
	}
	
	public Rubro(int idRubro, String rubroDescripcion, int rubroRadioCercania) {
		super();
		IdRubro = idRubro;
		RubroDescripcion = rubroDescripcion;
		RubroRadioCercania = rubroRadioCercania;
	}
	
	public Rubro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Rubro[] consultarRubro(){
		Rubro[] rubros = new Rubro[100];
		for(int k=0; k<100; k++){
			rubros[k].setIdRubro(-1);
		}
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from rubro");
			int i=0;
			while(rs.next()){
				rubros[i]=new Rubro(rs.getInt(1), rs.getString(2), rs.getInt(3));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return rubros;
	}
	
}