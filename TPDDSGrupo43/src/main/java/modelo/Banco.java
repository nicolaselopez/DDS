package modelo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Banco extends Poi {

	public Banco(Poi poi) {
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
		double distancia = DistanceCalculator.distance(latLngPos,latLngPoi);
		if(distancia <=5){
			OK = true;
		}
		return OK;
	}
	
	public Boolean calcularDisponibilidadPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Boolean OK;
		SimpleDateFormat horario = new SimpleDateFormat("HH:mm:ss");
	    
		Date dateHoy = new Date();
		
		String[] horaHoyParts = horario.format(dateHoy).split(":");
		
	    Calendar c = Calendar.getInstance();
	    c.setTime(dateHoy);
	    int dayOfWeekHoy = c.get(Calendar.DAY_OF_WEEK);
	    
		if(Integer.parseInt(horaHoyParts[0])<10 || Integer.parseInt(horaHoyParts[0])>=15)
		{
			OK = false;

			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoDisponibilidad.jsp").forward(request, response);
		}
		else
		{
			
			request.getRequestDispatcher("seleccionarServicio.jsp").forward(request, response);
		}
		return false;
	}
}
