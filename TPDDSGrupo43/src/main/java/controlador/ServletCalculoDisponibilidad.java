package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Poi;
import modelo.Usuario;
import modelo.Barrio;
import modelo.DistanceCalculator;

/**
 * Servlet implementation class ServletCalculoDisponibilidad
 */
@WebServlet("/ServletCalculoDisponibilidad")
public class ServletCalculoDisponibilidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletCalculoDisponibilidad() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPoiMap=0;
		int idPoi=Integer.parseInt(request.getParameter("poi"));

		try{
			Poi poi = null;
			Boolean OK = false;
			if(idPoi != 0){
				poi = Poi.buscarPoi(idPoi);
			}
			
			int tipoPoi = poi.getPoiIdTipoPoi();
			
			if(tipoPoi==1){ //Colectivo
				OK = true;
			}
			else 
			{
				SimpleDateFormat horario = new SimpleDateFormat("HH:mm:ss");
			    
				Date dateHoy = new Date();
				
				String[] horarioParts = horario.format(dateHoy).split(":");
			    
			    Calendar c = Calendar.getInstance();
			    c.setTime(dateHoy);
			    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			    
				if(tipoPoi==2) //CGP
				{
					OK=true;
				}
				else if(tipoPoi==3) //Bancos
				{
					if(dayOfWeek<7 && dayOfWeek>1)
					{
						if( (Integer.parseInt(horarioParts[0])>10) && (Integer.parseInt(horarioParts[0])<15) )
							OK = true;
					}
				}
				else if(tipoPoi==4) //Local Comercial
				{
					OK = true;
				}
			}
			request.setAttribute("poi", poi);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoDisponibilidad.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("poi", Poi.buscarPoi(idPoiMap));
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoDisponibilidad.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
