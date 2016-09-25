package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
import modelo.DistanceCalculator;
import modelo.HistorialBusqueda;

/**
 * Servlet implementation class ServletCalculoDisponibilidad2
 */
@WebServlet("/ServletHistorialBusquedas")
public class ServletHistorialBusquedas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletHistorialBusquedas() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			Boolean OK = false;
			
			String desde=request.getParameter("desde");
			
			String hasta=request.getParameter("hasta");
			
			if(desde.isEmpty())
			{
				desde="2016-09-22";
			}if(hasta.isEmpty())
			{
				hasta="2016-09-25";
			}
			
			HistorialBusqueda[] historias = HistorialBusqueda.consultarHistorial(desde, hasta);
			
			request.setAttribute("historias", historias);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoBusquedaHistorial.jsp").forward(request, response);
			
		}
		catch(Exception e)
		{
			request.setAttribute("historias", null);
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoBusquedaHistorial.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
