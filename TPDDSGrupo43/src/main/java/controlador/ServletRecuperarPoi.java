package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Poi;
import modelo.Servicio;


@WebServlet("/ServletRecuperarPoi")
public class ServletRecuperarPoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletRecuperarPoi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPoi=Integer.parseInt(request.getParameter("poi"));
		String usuario = request.getParameter("us");
		
		Boolean RegistroOK = Poi.editarEstadoPoi(idPoi,1);
		Boolean RegistroOK2 = Servicio.editarServicioPoi(idPoi, 1);
		if(RegistroOK && RegistroOK2){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("recuperarPoi.jsp").forward(request, response);
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
