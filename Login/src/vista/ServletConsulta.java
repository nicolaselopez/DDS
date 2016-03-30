package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.BeanUsuario;

import modelo.Usuario;

/**
 * Servlet implementation class ServletConsulta
 */
@WebServlet("/ServletConsulta")
public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletConsulta() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		BeanUsuario busuario=Usuario.consultarUsuario(usuario);
		if(busuario!=null && pass.equals(busuario.getClave())){
			request.setAttribute("busuario", busuario);
			request.getRequestDispatcher("home.jsp").forward(request, response);
			out.println("Te logueaste en el sistema hermano ;)");
		}else{
			BeanUsuario usuarioAux = new BeanUsuario();
			usuarioAux.setUsuario(usuario);
			request.setAttribute("busuario", usuarioAux);
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
