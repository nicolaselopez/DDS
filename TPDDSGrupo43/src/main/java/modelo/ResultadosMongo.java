package modelo;

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

}
