package modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class CGPAdapter {
	
	private static final Logger log= Logger.getLogger( CGPAdapter.class.getName() );
	
	public static CGP[] consultaCentroWS(){
		String rutaWebService = "http://trimatek.org/Consultas/centro";
		try{
			//Se crea conexion a WebService
			URL url = new URL(rutaWebService);
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
			CGP[] cgp = new CGP[jsonResponse.length()];
			int contadorServicios = 200000;
			for(int i=0;i<jsonResponse.length();i++){
				JSONObject jsonObject = (JSONObject) jsonResponse.get(i);
				Servicio[] PoiServicio = Servicio.crearServiciosCGP(jsonObject);
				if(PoiServicio != null){
					for(int k=0;k<PoiServicio.length;k++){
						PoiServicio[k].setIdServicio(contadorServicios);
						PoiServicio[k].setServicioIdPoi(i+200000);
						contadorServicios++;
					}
				}
				int IdPoi = i+200000;
				int PoiIdTipoPoi = 2;
				String PoiDescripcion = "CGP Comuna " + Integer.toString(jsonObject.getInt("comuna"));
				int PoiIdRubro = 0;
				Rubro PoiRubro = null;
				Barrio PoiBarrio = buscarBarrio(jsonObject.getInt("comuna"));
				Direccion PoiDireccion = new Direccion();
				PoiDireccion.setPoiUnidad(jsonObject.getString("director"));
				PoiDireccion.setPoiCalle(jsonObject.getString("domicilio"));
				double PoiLatitudGeo = 0;
				double PoiLongitudGeo = 0;
				String PoiFechaAlta = "";
				String PoiFechaModificacion = "";
				int PoiActivo = 1;
				cgp[i] = new CGP(IdPoi,PoiIdTipoPoi,PoiDescripcion,PoiIdRubro,PoiRubro,PoiBarrio,PoiServicio,PoiDireccion,Double.toString(PoiLatitudGeo),Double.toString(PoiLongitudGeo),PoiFechaAlta,PoiFechaModificacion,PoiActivo);
			}
			return cgp;
		}catch(Exception e){
			e.printStackTrace();
		}
		CGP[] cgp = new CGP[0];
		return cgp;
	}
	
	private static Barrio buscarBarrio(int comuna){
		Barrio barrio = null;
		Barrio.consultarBarrio(Barrio.buscarIdBarrioXComuna(comuna));
		return barrio;
	}

}
