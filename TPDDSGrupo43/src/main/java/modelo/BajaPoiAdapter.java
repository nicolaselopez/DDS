package modelo;

import java.util.Date;

import org.json.JSONObject;

public class BajaPoiAdapter {
	
	private int Id;
	private String Fecha;
	private int Status;
	private String Mensaje;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}
	public static BajaPoiAdapter crearBajaPoi(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		BajaPoiAdapter bajaPoi = new BajaPoiAdapter();
		bajaPoi.setId(jsonObject.getInt("id"));
		bajaPoi.setFecha(jsonObject.getString("deletedAt"));
		bajaPoi.setMensaje("OK");
		bajaPoi.setStatus(1);
		return bajaPoi;
	}
	public static BajaPoiAdapter registrarError(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		BajaPoiAdapter bajaPoi = new BajaPoiAdapter();
		bajaPoi.setId(-1);
		bajaPoi.setFecha(new Date().toString());
		bajaPoi.setMensaje(jsonObject.getString("error"));
		bajaPoi.setStatus(jsonObject.getInt("status_code"));
		return bajaPoi;
	}
	
	
	

}