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
@WebServlet("/ServletEditarPoi")
public class ServletEditarPoi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletEditarPoi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPoi=request.getParameter("poi");
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
		
		Boolean RegistroOK = Poi.editarPoi(idPoi, poi);
		if(RegistroOK){
			request.getRequestDispatcher("agregarServicio.jsp").forward(request, response);
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
