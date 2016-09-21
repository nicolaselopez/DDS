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
	
	public CGP(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Rubro poiRubro, Barrio poiBarrio,
			Servicio[] poiServicio, Direccion poiDireccion, String poiLatitudGeo, String poiLongitudGeo, String poiFechaAlta,
			String poiFechaModificacion, int poiActivo) {

		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiRubro = poiRubro;
		PoiBarrio = poiBarrio;
		PoiServicio = poiServicio;
		PoiDireccion = poiDireccion;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
		
	}
	
	public static String getJSP()
	{
		return "verPoiCGP.jsp";
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
