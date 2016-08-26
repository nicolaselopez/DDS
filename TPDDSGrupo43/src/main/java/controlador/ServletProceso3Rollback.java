package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.LoteAcciones;
import modelo.Poi;
import modelo.Proceso1;
import modelo.Proceso3;
import modelo.Proceso4;
import modelo.ProcesoContext;
import modelo.Servicio;

/**
 * Servlet implementation class ServletProceso4
 */
@WebServlet("/ServletProceso3Rollback")
public class ServletProceso3Rollback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletProceso3Rollback() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK = true;
		String usuario = request.getParameter("us");
		String usuarioAccion = request.getParameter("usuarien");
		Proceso3 proceso = new Proceso3();
		RegistroOK = proceso.rollback(usuarioAccion);
		if(RegistroOK){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("resultadoProceso.jsp").forward(request, response);
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
