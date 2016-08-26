package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Banco;
import modelo.Poi;
import modelo.Servicio;


@WebServlet("/ServletActualizarBancosWS")
public class ServletActualizarBancosWS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletActualizarBancosWS() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean OK = false;
		String usuario = request.getParameter("us");
		OK = Banco.consultaBancosWS();
		if(OK){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("home.jsp").forward(request, response);
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
