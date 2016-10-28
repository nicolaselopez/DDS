package controlador;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Direccion;
import modelo.LoteAcciones;
import modelo.Poi;
import modelo.Proceso1;
import modelo.Proceso3;
import modelo.Proceso4;
import modelo.ProcesoContext;
import modelo.ProcesoStr;
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
		LoteAcciones acciones = new LoteAcciones();
		String usuarioAccion = request.getParameter("proceso");
		acciones.setAccion1((request.getParameter("acc1")!= null) ? true : false);
		acciones.setAccion2((request.getParameter("acc2")!= null) ? true : false);
		acciones.setAccion3((request.getParameter("acc3")!= null) ? true : false);
		acciones.setAccion4((request.getParameter("acc4")!= null) ? true : false);
		acciones.setAccion5((request.getParameter("acc5")!= null) ? true : false);
		acciones.setAccion6((request.getParameter("acc6")!= null) ? true : false);
		acciones.setAccion7((request.getParameter("acc7")!= null) ? true : false);
		acciones.setAccion8((request.getParameter("acc8")!= null) ? true : false);
		acciones.setAccion9((request.getParameter("acc9")!= null) ? true : false);
		acciones.setAccion10((request.getParameter("acc10")!= null) ? true : false);
		acciones.setAccion11((request.getParameter("acc11")!= null) ? true : false);
		acciones.setAccion12((request.getParameter("acc12")!= null) ? true : false);
		acciones.setAccion13((request.getParameter("acc13")!= null) ? true : false);
		acciones.setAccion14((request.getParameter("acc14")!= null) ? true : false);
		
		//ProcesoContext context = null;
		String parametros = acciones.convertToString();
		parametros = parametros + usuarioAccion + ";";
		ProcesoStr.insertarAgenda(3, parametros, Integer.parseInt(usuario));
		//context = new ProcesoContext(new Proceso3());
		//context.executeStrategy(usuarioAccion,acciones);
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
