package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.Poi;

/**
 * Servlet implementation class ServletRegistrarPoi
 */
@WebServlet("/ServletRegistrarPoi")
public class ServletRegistrarPoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletRegistrarPoi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("us");
		String descripcion=request.getParameter("nombrePoi");
		String latitud=request.getParameter("latitud");
		String longitud=request.getParameter("longitud");
		String calle=request.getParameter("calle");
		String numero=request.getParameter("numero");
		String piso=request.getParameter("piso");
		String dpto=request.getParameter("dpto");
		String codpos=request.getParameter("codpos");
		String tipoPoi=request.getParameter("tipoPoi");
		String barrio=request.getParameter("barrio");
		String rubro=request.getParameter("rubro");
		Direccion poiDireccion = new Direccion (calle,numero,piso,dpto,"0",codpos,1,Integer.parseInt(barrio),1,1);
		Poi poi= new Poi(Integer.parseInt(tipoPoi),descripcion,Integer.parseInt(rubro),poiDireccion,latitud,longitud,1);
		
		Boolean RegistroOK = Poi.registrarPoi(poi);
		if(RegistroOK){
			request.setAttribute("poi", poi);
			request.setAttribute("us", usuario);
			request.getRequestDispatcher("agregarServicio.jsp").forward(request, response);
		}else{
			request.setAttribute("poi", poi);
			request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
