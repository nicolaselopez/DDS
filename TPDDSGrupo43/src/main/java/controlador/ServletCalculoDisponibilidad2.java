package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Poi;
import modelo.Servicio;
import modelo.Usuario;
import modelo.Barrio;
import modelo.CGPAdapter;
import modelo.DistanceCalculator;

/**
 * Servlet implementation class ServletCalculoDisponibilidad2
 */
@WebServlet("/ServletCalculoDisponibilidad2")
public class ServletCalculoDisponibilidad2 extends HttpServlet {
	
	private static final Logger log= Logger.getLogger( ServletCalculoDisponibilidad2.class.getName() );
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletCalculoDisponibilidad2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPoiMap=0;
		int idServicio=Integer.parseInt(request.getParameter("serv"));

		try{
			Servicio servicio = null;
			Boolean OK = false;
			
			if(idServicio != 0){
				servicio = Servicio.buscarServicio(idServicio);
				if(servicio != null){
					log.info(servicio.getServicioDescripcion());
				}
				
			}
			
			SimpleDateFormat horario = new SimpleDateFormat("HH:mm:ss");
		    
			Date dateHoy = new Date();
			
			String[] horaHoyParts = horario.format(dateHoy).split(":");
			
		    Calendar c = Calendar.getInstance();
		    c.setTime(dateHoy);
		    int dayOfWeekHoy = c.get(Calendar.DAY_OF_WEEK);
			
		    OK = servicio.calcularDisponibilidad(dayOfWeekHoy, horaHoyParts);
		    
			request.setAttribute("serv", servicio);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoDisponibilidad2.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			request.setAttribute("serv", Servicio.buscarServicio(idServicio));
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoDisponibilidad2.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
