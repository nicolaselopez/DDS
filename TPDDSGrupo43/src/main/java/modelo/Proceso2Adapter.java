package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Proceso2Adapter {
	
	private static final Logger log= Logger.getLogger( Proceso2Adapter.class.getName() );
	
	public static BajaPoiAdapter[] consultaBajaPoiWS(int modo){
		//modo = 1 --> usa WS correcto; sino usa WS incorrecto
		try{
			JSONArray jsonResponse;
			if(modo==1){
				jsonResponse= Proceso2Adapter.consultarWS("http://demo3537367.mockable.io/trash/pois");	
			}else{
				jsonResponse = Proceso2Adapter.consultarWS("http://demo3537367.mockable.io/trash/pois_bad");
			}
			BajaPoiAdapter[] bajaPoi = new BajaPoiAdapter[jsonResponse.length()];
			for(int i=0;i<jsonResponse.length();i++){
				JSONObject jsonObject = (JSONObject) jsonResponse.get(i);
				if(jsonObject.isNull("status_code")){
					bajaPoi[i] = BajaPoiAdapter.crearBajaPoi(jsonObject);
				}else{
					bajaPoi[i] = BajaPoiAdapter.registrarError(jsonObject);
				}
			}
			return bajaPoi;
		}catch(Exception e){
			e.printStackTrace();
		}
		BajaPoiAdapter[] bajaPoi = new BajaPoiAdapter[0];
		return bajaPoi;
	}
	
	private static JSONArray consultarWS(String ws){
		try{
			//Se crea conexion a WebService
			URL url = new URL(ws);
			URLConnection conexionUrl = url.openConnection();
			//Se lee contenido WS
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conexionUrl.getInputStream()));
			String line;
			final StringBuilder builder = new StringBuilder(2048);
			while ((line=buffer.readLine())!=null){
				builder.append(line);
			}
			//Convertir a JSON Array el contenido del WS
			JSONArray jsonResponse = new JSONArray(builder.toString());	
		return jsonResponse;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
