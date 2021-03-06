package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.Poi;
import modelo.Servicio;

/**
 * Servlet implementation class ServletRegistrarPoi
 */
@WebServlet("/ServletEditarServicio")
public class ServletEditarServicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEditarServicio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean RegistroOK = true;
		String usuario = request.getParameter("us");		
		String idPoi = request.getParameter("poi");
		Poi poi = Poi.buscarPoi(Integer.parseInt(idPoi));
		String idServicio=request.getParameter("servicio");
		String descripcion=request.getParameter("nombrePoi");
		
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
		Servicio servicio= new Servicio(Integer.parseInt(idServicio),poi.getIdPoi(),descripcion,diaDisponible,horaDesde1,horaHasta1,horaDesde2,horaHasta2,tags,1);
		
		RegistroOK = Servicio.editarServicio(servicio);

		if(RegistroOK){
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("editarPoiSeleccion.jsp").forward(request, response);
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
