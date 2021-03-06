package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Poi;
import modelo.Usuario;
import modelo.Barrio;
import modelo.LatLng;

/**
 * Servlet implementation class ServletCalculoCercania
 */
@WebServlet("/ServletCalculoCercania")
public class ServletCalculoCercania extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletCalculoCercania() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LatLng latLngPos = LatLng.newLatLng(Double.parseDouble(request.getParameter("latitud1")), Double.parseDouble(request.getParameter("longitud1")));
		LatLng latLngPoi = null;
		int idPoi=Integer.parseInt(request.getParameter("poi"));
		int idPoiMap=0;
		int comunaPos=0;
		try{
			Poi poi = null;
			if(idPoi != 0){
				poi = Poi.buscarPoi(idPoi);
				latLngPoi = LatLng.newLatLng(Double.parseDouble(poi.getPoiLatitudGeo()),Double.parseDouble(poi.getPoiLongitudGeo()));
			}else if(Integer.parseInt(request.getParameter("idPoiMap"))!=0){
				idPoiMap = Integer.parseInt(request.getParameter("idPoiMap"));
				poi = Poi.buscarPoi(idPoiMap);
				latLngPoi = LatLng.newLatLng(Double.parseDouble(request.getParameter("latitud2")),Double.parseDouble(request.getParameter("longitud2")));
			}
			String comunaPosString=request.getParameter("comunaPos");
			comunaPos=Integer.parseInt(comunaPosString.substring(7));
			Boolean OK = poi.calcularDistanciaPoi(poi,latLngPos,latLngPoi , comunaPos);
			request.setAttribute("poi", poi);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoCercania.jsp").forward(request, response);
		}catch(Exception e){
			request.setAttribute("poi", Poi.buscarPoi(idPoiMap));
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoCercania.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
