package controlador;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.Poi;
import modelo.Servicio;

/**
 * Servlet implementation class ServletRegistrarPoi
 */
@WebServlet("/ServletEditarServicioSeleccion")
public class ServletEditarServicioSeleccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEditarServicioSeleccion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK;
		if(Integer.parseInt(request.getParameter("poi").substring(0, 1)) == 0){
			RegistroOK = false;
		}else{
			StringTokenizer poiservicio= new StringTokenizer(request.getParameter("poi"),"_");
			int idPoi = Integer.parseInt(poiservicio.nextToken());
			int idServicio = Integer.parseInt(poiservicio.nextToken());
			
			Servicio servicio = Servicio.buscarServicio(idServicio);
			request.setAttribute("poi", idPoi);
			request.setAttribute("servicio", servicio);
			
			RegistroOK = true;
		}
		if(RegistroOK){
			request.getRequestDispatcher("editarServicio.jsp").forward(request, response);
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
