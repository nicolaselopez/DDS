package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.Poi;

/**
 * Servlet implementation class ServletRegistrarPoi
 */
@WebServlet("/ServletEditarPoiSeleccion")
public class ServletEditarPoiSeleccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEditarPoiSeleccion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPoi=Integer.parseInt(request.getParameter("poi"));
		if(idPoi==0){
			request.getRequestDispatcher("editarPoiSeleccion.jsp").forward(request, response);
		}
		Poi poi= Poi.buscarPoi(idPoi);
		request.setAttribute("poiElegido", poi);
		request.getRequestDispatcher("editarPoi.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
