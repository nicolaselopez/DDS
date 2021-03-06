package modelo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.DistanceCalculator;

public class Colectivo extends Poi {

	public Colectivo(Poi poi) {
		super();
		IdPoi = poi.getIdPoi();
		PoiIdTipoPoi = poi.getPoiIdTipoPoi();
		PoiDescripcion = poi.getPoiDescripcion();
		PoiIdRubro = poi.getPoiIdRubro();
		PoiRubro = poi.getPoiRubro();
		PoiBarrio = poi.getPoiBarrio();
		PoiServicio = poi.getPoiServicio();
		PoiDireccion = poi.getPoiDireccion();
		PoiLatitudGeo = poi.getPoiLatitudGeo();
		PoiLongitudGeo = poi.getPoiLongitudGeo();
		PoiFechaAlta = poi.getPoiFechaAlta();
		PoiFechaModificacion = poi.getPoiFechaModificacion();
		PoiActivo = poi.getPoiActivo();
	}

	public static String getJSP()
	{
		return "verPoiColectivo.jsp";
	}
	
	public Boolean calcularDistanciaPoi(Poi poi,LatLng latLngPos,LatLng latLngPoi, int comuna){
		Boolean OK = false;
		double distancia = DistanceCalculator.distance(latLngPos,latLngPoi);
		if(distancia <= 1){
			OK = true;
		}
		return OK;
	}

	public Boolean calcularDisponibilidadPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("resultadoDisponibilidad.jsp").forward(request, response);
		return true;
	}
}
