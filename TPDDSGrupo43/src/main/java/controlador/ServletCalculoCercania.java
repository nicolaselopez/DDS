package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Poi;
import modelo.Usuario;
import modelo.DistanceCalculator;

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
		Double latPosicion=Double.parseDouble(request.getParameter("latitud1"));
		Double lngPosicion=Double.parseDouble(request.getParameter("longitud1"));
		Double latPoi=null;
		Double lngPoi=null;
		int idPoi=Integer.parseInt(request.getParameter("poi"));
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		try{
			Poi poi = null;
			if(idPoi != 0){
				poi = Poi.buscarPoi(idPoi);
				latPoi = Double.parseDouble(poi.getPoiLatitudGeo());
				lngPoi = Double.parseDouble(poi.getPoiLongitudGeo());
			}else if(Integer.parseInt(request.getParameter("poi"))!=0){
				int idPoiMap = Integer.parseInt(request.getParameter("poi"));
				poi = Poi.buscarPoi(idPoiMap);
				latPoi=Double.parseDouble(request.getParameter("latitud2"));
				lngPoi=Double.parseDouble(request.getParameter("longitud2"));
			}
			double distancia = (distanceCalculator.distance(latPosicion, lngPosicion, latPoi, lngPoi, "K"))*10;
			Boolean OK = false;
			int tipoPoi = poi.getPoiIdTipoPoi();
			if(tipoPoi==1){ //Colectivo
				if(distancia <= 1){
					OK = true;
				}
			}else if(tipoPoi==3){ //Bancos
				if(distancia <=5){
					OK = true;
				}
			}else if(tipoPoi==4){ //Local Comercial
				if(distancia <= poi.getPoiRubro().getRubroRadioCercania()){
					OK = true;
				}
			}
			request.setAttribute("busuario", usuarioAux);
			request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
		}catch(Exception e){
			Usuario usuarioAux = new Usuario();
			usuarioAux.setUsuario(usuario);
			request.setAttribute("busuario", usuarioAux);
			request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
