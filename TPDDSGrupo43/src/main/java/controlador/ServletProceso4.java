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
@WebServlet("/ServletProceso4")
public class ServletProceso4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletProceso4() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK = true;
		
		String dLun=request.getParameter("dLun");
		String dMar=request.getParameter("dMar");
		String dMie=request.getParameter("dMie");

		Proceso4 proceso4 = new Proceso4();
		if(!dLun.isEmpty())
		{
			proceso4.add(new Proceso1());
		}

		try
		{
			proceso4.procesar();
		}
		catch(Exception e)
		{
			RegistroOK = false;
		}
		
		if(RegistroOK){
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
