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
			Servicio[] servicio = poi.getPoiServicio();
			
			if(tipoPoi==1){ //Colectivo
				OK = true;
			}
			else 
			{
				SimpleDateFormat horario = new SimpleDateFormat("HH:mm:ss");
			    
				Date dateHoy = new Date();
				
				String[] horaHoyParts = horario.format(dateHoy).split(":");
				String servicioDesde = servicio[0].getServicioHoraDesde1();
				String servicioHasta = servicio[0].getServicioHoraHasta1();
				String servicioDesde1 = servicio[0].getServicioHoraDesde2();
				String servicioHasta1 = servicio[0].getServicioHoraHasta2();
			    String[] diasServicioParts = servicio[0].getServicioDiaDisponible().split(";");

			    Calendar c = Calendar.getInstance();
			    c.setTime(dateHoy);
			    int dayOfWeekHoy = c.get(Calendar.DAY_OF_WEEK);
			    
				if(tipoPoi==3) //Bancos
				{
					if(bancoDisponible(dayOfWeekHoy, (Integer.parseInt(horaHoyParts[0]))))
					{
						OK = true;
					}
				}
				else if( (tipoPoi==4) || (tipoPoi==3) ) //Local Comercial
				{
					if(localComercialDisponible(diasServicioParts, servicioDesde, servicioHasta, dayOfWeekHoy, horaHoyParts) || localComercialDisponible(diasServicioParts, servicioDesde1, servicioHasta1, dayOfWeekHoy, horaHoyParts))
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

	private boolean bancoDisponible(int dayOfWeekHoy, int horaHoy) {
		boolean disponible = false;
		
		if( dayOfWeekHoy<7 && dayOfWeekHoy>1)
		{
			if(horaEstaEntre(horaHoy,10,15))
			{
				disponible = true;
			}
		}
		return disponible;
	}

	private boolean horaEstaEntre( int horaHoy, int horaDesde, int horaHasta) {

		if(horaHasta == 0)
		{
			horaHasta = 24;
		}
		
		return (horaHoy>horaDesde) && (horaHoy<horaHasta) ;
	}

	private boolean localComercialDisponible(String[] diasServicioParts, String servicioDesde, String servicioHasta, int dayOfWeekHoy, String[] horaHoyParts) throws ParseException {
	    int diaDisponible, i=0;
	    
	    boolean disponible = false;
	    
	    while(i<diasServicioParts.length)
	    {	
	    	diaDisponible = calcularDiaDisponible(diasServicioParts[i]);
	    	
	    	if(diaDisponible == dayOfWeekHoy)
	    	{
	    		if( horaEstaEntre(Integer.parseInt(horaHoyParts[0]),Integer.parseInt(servicioDesde),Integer.parseInt(servicioHasta)) )
	    		{
	    			disponible = true;
	    			
	    			break;
	    		}
	    	}
	    	
	    	i++;
	    }
	    
		return disponible;
	}

	private int calcularDiaDisponible(String diaServicio) {
		int nroDia = 0;
		
		if(diaServicio.equals("Dom"))
		{
			nroDia = 1;
		}
		else
		{
			if(diaServicio.equals("Lun"))
			{
				nroDia = 2;
			}
			else
			{
				if(diaServicio.equals("Mar"))
				{
					nroDia = 3;
				}
				else
				{
					if(diaServicio.equals("Mie"))
					{
						nroDia = 4;
					}
					else
					{
						if(diaServicio.equals("Jue"))
						{
							nroDia = 5;
						}
						else
						{
							if(diaServicio.equals("Vie"))
							{
								nroDia = 6;
							}
							else
							{
								if(diaServicio.equals("Sab"))
								{
									nroDia = 7;
								}
							}
						}
					}
				}
			}
		}
		
		return nroDia;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
