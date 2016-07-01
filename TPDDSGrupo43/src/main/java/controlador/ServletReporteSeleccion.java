package controlador;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.RegistroConsulta;



@WebServlet("/ServletReporteSeleccion")
public class ServletReporteSeleccion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletReporteSeleccion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK;
			String seleccion= new String(request.getParameter("tipo"));
			RegistroOK=false;
			if(seleccion.equals("PorFecha")){
				RegistroConsulta.generarInformeBusquedasPorFecha();
				RegistroOK = true;
			}
			if(seleccion.equals("PorTerminal")){
				RegistroConsulta.generarInformeBusquedasPorTerminalTotales();
				RegistroOK = true;
			}
			if (seleccion.equals("PorUsuario")){
				RegistroConsulta.generarInformeBusquedasPorTerminalTotales();
				RegistroOK = true;
			}
			
		if(RegistroOK){
			request.getRequestDispatcher("reportes.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
