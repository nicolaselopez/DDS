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
import java.util.StringTokenizer;

public class Proceso2 extends ProcesoStr {

	@Override
	public void procesar() {
		try{
			BajaPoiAdapter[] bajasPoi = Proceso2Adapter.consultaBajaPoiWS(1);
			for(int i=0; i<bajasPoi.length; i++){
				if(validarEstado(bajasPoi[i])){
					Poi.editarEstadoPoi(bajasPoi[i].getId(), 0);
				}else{
					grabarProceso(bajasPoi[i].getMensaje());
					break;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private boolean validarEstado(BajaPoiAdapter bajaPoiAdapter) {
		// TODO Auto-generated method stub
		boolean ok = (bajaPoiAdapter.getStatus() !=1) ? false : true;
		return ok;
	}
	
}
