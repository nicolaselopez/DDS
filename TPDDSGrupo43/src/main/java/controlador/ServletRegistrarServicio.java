package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Servicio;

/**
 * Servlet implementation class ServletRegistrarServicio
 */
@WebServlet("/ServletRegistrarServicio")
public class ServletRegistrarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletRegistrarServicio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("us");
		String descripcion=request.getParameter("nombreServicio");
		String poi=request.getParameter("poi");
		String dLun=request.getParameter("dLun");
		String dMar=request.getParameter("dMar");
		String dMie=request.getParameter("dMie");
		String dJue=request.getParameter("dJue");
		String dVie=request.getParameter("dVie");
		String dSab=request.getParameter("dSab");
		String dDom=request.getParameter("dDom");
		String diaDisponible = Servicio.generarDias(dLun,dMar,dMie,dJue,dVie,dSab,dDom);
		String horaDesde1=request.getParameter("horaDesde1");
		String horaHasta1=request.getParameter("horaHasta1");
		String horaDesde2=request.getParameter("horaDesde2");
		String horaHasta2=request.getParameter("horaHasta2");
		String tags=request.getParameter("tags");
		Servicio servicio= new Servicio(Integer.parseInt(poi),descripcion,diaDisponible,horaDesde1,horaHasta1,horaDesde2,horaHasta2,tags,1);
		
		Boolean RegistroOK = Servicio.registrarServicio(servicio);
		if(RegistroOK){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("registrarPoi.jsp").forward(request, response);
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
