package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TipoPoi {

	private int IdTipoPoi;
	private String TipoPoiDescripcion;
	private int TipoPoiActivo;
	

	
	public int getIdTipoPoi() {
		return IdTipoPoi;
	}




	public void setIdTipoPoi(int idTipoPoi) {
		IdTipoPoi = idTipoPoi;
	}




	public String getTipoPoiDescripcion() {
		return TipoPoiDescripcion;
	}




	public void setTipoPoiDescripcion(String tipoPoiDescripcion) {
		TipoPoiDescripcion = tipoPoiDescripcion;
	}




	public int getTipoPoiActivo() {
		return TipoPoiActivo;
	}




	public void setTipoPoiActivo(int tipoPoiActivo) {
		TipoPoiActivo = tipoPoiActivo;
	}




	public TipoPoi(int idTipoPoi, String tipoPoiDescripcion, int tipoPoiActivo) {
		super();
		IdTipoPoi = idTipoPoi;
		TipoPoiDescripcion = tipoPoiDescripcion;
		TipoPoiActivo = tipoPoiActivo;
	}




	public TipoPoi() {
		super();
		// TODO Auto-generated constructor stub
	}




	public static TipoPoi[] consultarTipoPois(){
		TipoPoi[] tipoPoi = new TipoPoi[4];
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from tipopoi");
			int i=0;
			while(rs.next()){
				tipoPoi[i]=new TipoPoi(rs.getInt(1), rs.getString(2), rs.getInt(3));
				i++;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return tipoPoi;
	}
	
}