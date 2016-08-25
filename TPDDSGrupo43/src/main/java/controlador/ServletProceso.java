package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Servicio;
import modelo.Proceso1;
import modelo.Proceso2;
import modelo.ProcesoContext;
import modelo.ProcesoStr;

/**
 * Servlet implementation class ServletRegistrarServicio
 */
@WebServlet("/ServletProceso")
public class ServletProceso extends HttpServlet  {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String select=request.getParameter("proceso");
		
		Boolean RegistroOK = true;

		ProcesoContext context = null;
		
		if(select.equals("Proceso4"))
		{
			RegistroOK = false;
		}
		else
		{
			if(select.equals("Proceso1"))
			{
				context = new ProcesoContext(new Proceso1());
			}
			else if(select.equals("Proceso2"))
			{
				context = new ProcesoContext(new Proceso2());
			}
			context.executeStrategy();
		}
			
		
		if(RegistroOK){
			request.getRequestDispatcher("resultadoProceso.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("proceso4.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
