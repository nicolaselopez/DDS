package modelo;

import java.util.List;

public class UsuarioAdministrador extends Usuario {
	
	public List<Accion> accionesParaAgregar;
	public List<Usuario> usuariosCandidatos;
	
	public void setAccionesParaAgregar(List<Accion> acciones){
		
		this.accionesParaAgregar = acciones;
	}
	
	public List<Accion> getAccionesAAgregar(){
		
		return accionesParaAgregar;
	}

	
	public void setUsuariosCandidatos(List<Usuario> usuarios){
		
		this.usuariosCandidatos = usuarios;
	}
	
	public List<Usuario> getUsuariosCandidatos(){
		
		return usuariosCandidatos;
	}
	
	// Desactivar Terminal
	public void darDeBajaUsuarioTerminal(UsuarioTerminal usuario){
		usuario.DesactivarTerminal();
	}
	
	public void ejecutarProceso(ProcesoStr proceso){
		proceso.procesar();
	}
	
	public void deshacerCambiosAcciones(Accion_x_Usuario tabla){
		
		tabla.hacerRollBack();
	}
	
}
