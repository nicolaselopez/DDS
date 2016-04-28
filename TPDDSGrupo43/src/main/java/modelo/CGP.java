package modelo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CGP extends Poi {

	public CGP(Poi poi) {
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
	
	public Boolean calcularDistanciaPoi(Poi poi,LatLng latLngPos,LatLng latLngPoi, int comuna){
		Boolean OK = false;
		if(poi.getPoiBarrio().getBarrioIdComuna()==comuna){
			OK=true;
		}
		return OK;
	}

	public Boolean calcularDisponibilidadPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		request.getRequestDispatcher("seleccionarServicio.jsp").forward(request, response);
		
		return true;
	}
}
