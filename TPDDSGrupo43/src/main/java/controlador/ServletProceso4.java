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
import modelo.Proceso2;
import modelo.Proceso3;
import modelo.Proceso4;
import modelo.ProcesoStr;
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
		String usuario = request.getParameter("us");
		String dLun=request.getParameter("dLun");
		String dMar=request.getParameter("dMar");
		String dMie=request.getParameter("dMie");
		
		boolean proceso3Bool=false;

		Proceso4 proceso4 = new Proceso4();

		if(dLun!="" && dLun!=null)
			{
				//proceso4.add(new Proceso1());
				ProcesoStr.insertarAgenda(1, "", Integer.parseInt(usuario));
			}
		if(dMar!="" && dMar!=null)
			{
				ProcesoStr.insertarAgenda(2, "", Integer.parseInt(usuario));
				//proceso4.add(new Proceso2());
			}
		if(dMie!="" && dMie!=null)
			{
				proceso3Bool = true;
			}

		if(proceso3Bool)
		{
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("proceso3.jsp").forward(request, response);
		}
		
		if(RegistroOK && !proceso3Bool){
			request.getRequestDispatcher("resultadoProceso.jsp").forward(request, response);
		}else if(!RegistroOK){
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
