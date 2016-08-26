package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ContextReporte;
import modelo.GenerarReporte;
import modelo.RegistroConsulta;
import modelo.ReportePorFecha;
import modelo.ReportePorTerminalTotal;
import modelo.ReportePorUsuario;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean RegistroOK;
		String usuario = request.getParameter("us");

		String seleccion = new String(request.getParameter("tipo"));
		RegistroOK = false;
		/*
		 * if (seleccion.equals("PorFecha")) {
		 * RegistroConsulta.generarInformeBusquedasPorFecha(); RegistroOK =
		 * true; } if (seleccion.equals("PorTerminal")) {
		 * RegistroConsulta.generarInformeBusquedasPorTerminalTotales();
		 * RegistroOK = true; } if (seleccion.equals("PorUsuario")) {
		 * RegistroConsulta.generarInformeBusquedasPorTerminalTotales();
		 * RegistroOK = true; }
		 */
		ContextReporte consulta;
		Date now = new Date();
		
		if (seleccion.equals("PorFecha")) {
			consulta = new ContextReporte(new ReportePorFecha(), 1, now.toString(), 0);
			RegistroOK = true;
		} else {
			if (seleccion.equals("PorTerminal")) {
				consulta = new ContextReporte(new ReportePorTerminalTotal(),1, now.toString(), 0);
				RegistroOK = true;
			}
			else
			{
				consulta = new ContextReporte(new ReportePorUsuario(),1, now.toString(), 0);
				RegistroOK = true;
			}
		}

		ContextReporte[] reportes = consulta.ejecutar(1);
		
		if (RegistroOK) {
			request.setAttribute("serv", reportes);
			request.setAttribute("OK", RegistroOK);
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("reportes.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
