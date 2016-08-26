package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.Poi;
import modelo.Proceso1;
import modelo.Proceso4;
import modelo.Servicio;
import modelo.Usuario;
import vista.listObject;

/**
 * Servlet implementation class ServletProceso4
 */
@WebServlet("/ServletSeleccionarAcciones")
public class ServletSeleccionarAcciones extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletSeleccionarAcciones() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK = true;
		String usuario = request.getParameter("us");
		String user=request.getParameter("proceso");
	
		Proceso4 proceso4 = new Proceso4();
		
		try
		{
			proceso4.procesar();
		}
		catch(Exception e)
		{
			RegistroOK = false;
		}
		
		if(RegistroOK){
			request.setAttribute("us", usuario);
			request.setAttribute("proceso", user);
			request.getRequestDispatcher("seleccionAcciones.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
