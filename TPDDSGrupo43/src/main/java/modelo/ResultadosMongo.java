package modelo;

import java.util.List;

import com.google.gson.Gson;

import modelo.Poi;

public class ResultadosMongo {

	public int idPoi;
	public String poiDescripcion;

	public int getIdPoi() {
		return idPoi;
	}

	public void setIdPoi(int IdPoi) {
		idPoi = IdPoi;
	}

	public ResultadosMongo(int IdPoi) {
		super();
		idPoi = IdPoi;
		poiDescripcion = Poi.buscarPoiDescripcion(IdPoi);
	}
	public ResultadosMongo(int IdPoi, String descripcion) {
		super();
		idPoi = IdPoi;
		poiDescripcion = descripcion;
	}
	public String getPoiDescripcion() {
		return poiDescripcion;
	}

	public void setPoiDescripcion(String PoiDescripcion) {
		poiDescripcion = PoiDescripcion;
	}

	public ResultadosMongo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static String convertArray(List<ResultadosMongo> resultados) {
		Gson gson = new Gson();
		ResultadosMongo[] array = new ResultadosMongo[resultados.size()];
		array = resultados.toArray(array);
		return gson.toJson(array);
	}

}
