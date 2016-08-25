package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.StringTokenizer;

public class Proceso2 extends ProcesoStr {

	@Override
	public void procesar() {
		Date inicio = new Date();
		try{
			String estado = "OK";
			String msg = "Procesado Correctamente";
			BajaPoiAdapter[] bajasPoi = Proceso2Adapter.consultaBajaPoiWS(1);
			for(int i=0; i<bajasPoi.length; i++){
				if(validarEstado(bajasPoi[i])){
					Poi.editarEstadoPoi(bajasPoi[i].getId(), 0);
				}else{
					msg = bajasPoi[i].getMensaje();
					estado = "Error";
				}
			}
			Date fin = new Date();
			grabarProceso(2,estado,msg,inicio,fin);		
		}catch(Exception e){
			e.printStackTrace();
			Date fin = new Date();
			grabarProceso(2,"Error",e.toString(),inicio,fin);
		}
	}

	private boolean validarEstado(BajaPoiAdapter bajaPoiAdapter) {
		// TODO Auto-generated method stub
		boolean ok = (bajaPoiAdapter.getStatus() !=1) ? false : true;
		return ok;
	}
	
}
