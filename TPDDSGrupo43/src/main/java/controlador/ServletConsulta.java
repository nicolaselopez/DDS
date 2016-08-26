package controlador;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasypt.util.password.BasicPasswordEncryptor;

import modelo.Usuario;

/**
 * Servlet implementation class ServletConsulta
 */
@WebServlet("/ServletConsulta")
public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log= Logger.getLogger( ServletCalculoDisponibilidad2.class.getName() );
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
		Usuario busuario=Usuario.consultarUsuario(usuario);
		BasicPasswordEncryptor encriptador = new BasicPasswordEncryptor();
		try{
			if(busuario!=null && encriptador.checkPassword(pass, busuario.getClave())){
				request.setAttribute("busuario", busuario);
				
				request.setAttribute("us", Integer.toString(busuario.getIdUsuario()));
				log.info("El valor que viaja en US es: " + Integer.toString(busuario.getIdUsuario()));
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}else{
				Usuario usuarioAux = new Usuario();
				usuarioAux.setUsuario(usuario);
				request.setAttribute("busuario", usuarioAux);
				request.getRequestDispatcher("loginFailed.jsp").forward(request, response);
			}
		}catch(Exception e){
			Usuario usuarioAux = new Usuario();
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
