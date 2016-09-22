package controlador;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
@WebServlet("/ServletBusquedaTags")
public class ServletBusquedaTags extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletBusquedaTags() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tag=request.getParameter("tag");

		try{
			Boolean OK = false;
			Servicio[] servicios = Servicio.consultarServiciosTag(tag);
			
			HistorialBusqueda.registrarHistorial(tag);
			
			for(int i=0;i<servicios.length;i++) {
               	if(servicios[i].getIdServicio()== -1){
               		break;	
               	}
               	Poi poi = Poi.buscarPoi(servicios[i].getServicioIdPoi());
               	
               	HistorialBusqueda.registrarResultados(poi);
			}
			
			request.setAttribute("serv", servicios);
			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoBusquedaTag.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("serv", null);
			request.setAttribute("OK", false);
			request.getRequestDispatcher("resultadoBusquedaTag.jsp").forward(request, response);
		
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
