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
import modelo.UsuarioTerminal;
import modelo.Barrio;
import modelo.CGPAdapter;
import modelo.DistanceCalculator;
import modelo.HistorialBusqueda;

/**
 * Servlet implementation class ServletCalculoDisponibilidad2
 */
@WebServlet("/ServletBusquedaCriterio")
public class ServletBusquedaCriterio extends HttpServlet {
	
	private static final Logger log= Logger.getLogger( ServletBusquedaCriterio.class.getName() );
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletBusquedaCriterio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag=request.getParameter("filtros");
		log.info(tag);
		try{
			
			Boolean OK = false;
			Poi[] pois = Poi.busquedaPorCriterio(tag);
			request.setAttribute("pois", pois);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoBusquedaCriterio.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
			request.setAttribute("pois", null);
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoBusquedaCriterio.jsp").forward(request, response);
		
		}
/*		
		try{
			Boolean OK = false;
			Servicio[] servicios = UsuarioTerminal.realizarBusqueda(tag);
			
			request.setAttribute("serv", servicios);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoBusquedaTag.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("serv", null);
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoBusquedaTag.jsp").forward(request, response);
		
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
