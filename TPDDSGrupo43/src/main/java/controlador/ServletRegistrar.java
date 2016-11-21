package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

/**
 * Servlet implementation class ServletRegistrar
 */
@WebServlet("/ServletRegistrar")
public class ServletRegistrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletRegistrar() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario=request.getParameter("usuario");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		String email=request.getParameter("mail");
		String fecnac=request.getParameter("fecnac");
		Usuario busuario= new Usuario(name, fecnac,email, usuario, pass);
		Boolean RegistroOK = Usuario.registrarUsuario(busuario);
		busuario = Usuario.consultarUsuario(usuario);
		if(RegistroOK){
			request.setAttribute("busuario", busuario);
			request.setAttribute("us", Integer.toString(busuario.getIdUsuario()));
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}else{
			Usuario usuarioAux = new Usuario();
			usuarioAux.setUsuario(usuario);
			request.setAttribute("busuario", usuarioAux);
			request.getRequestDispatcher("registrarFailed.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
