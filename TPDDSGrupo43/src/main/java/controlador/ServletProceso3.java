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

/**
 * Servlet implementation class ServletProceso4
 */
@WebServlet("/ServletProceso3")
public class ServletProceso3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletProceso3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK = true;
		String usuario = request.getParameter("us");
		
		String acc0=request.getParameter("acc0");
		String acc1=request.getParameter("acc1");
		String acc2=request.getParameter("acc2");
		
		String acc3=request.getParameter("acc3");
		String acc4=request.getParameter("acc4");
		String acc5=request.getParameter("acc5");
		
		String acc6=request.getParameter("acc6");
		String acc7=request.getParameter("acc7");
		String acc8=request.getParameter("acc8");
		
		String acc9=request.getParameter("acc9");
		String acc10=request.getParameter("acc10");
		String acc11=request.getParameter("acc11");

		if(!acc0.isEmpty())
		{
			RegistroOK = false;
		}
		
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
