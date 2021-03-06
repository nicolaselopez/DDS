package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Poi;
import modelo.Servicio;


@WebServlet("/ServletBorrarPoi")
public class ServletBorrarPoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletBorrarPoi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idPoi=Integer.parseInt(request.getParameter("poi"));
		Boolean RegistroOK = Poi.editarEstadoPoi(idPoi,0);
		Boolean RegistroOK2 = Servicio.editarServicioPoi(idPoi, 0);
		String usuario = request.getParameter("us");
		if(RegistroOK && RegistroOK2){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("borrarPoi.jsp").forward(request, response);
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
