package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class LoteAcciones {

	private boolean accion1 = false;
	private boolean accion2 = false;
	private boolean accion3 = false;
	private boolean accion4 = false;
	private boolean accion5 = false;
	private boolean accion6 = false;
	private boolean accion7 = false;
	private boolean accion8 = false;
	private boolean accion9 = false;
	private boolean accion10 = false;
	private boolean accion11 = false;
	private boolean accion12 = false;
	public boolean isAccion1() {
		return accion1;
	}
	public void setAccion1(boolean accion1) {
		this.accion1 = accion1;
	}
	public boolean isAccion2() {
		return accion2;
	}
	public void setAccion2(boolean accion2) {
		this.accion2 = accion2;
	}
	public boolean isAccion3() {
		return accion3;
	}
	public void setAccion3(boolean accion3) {
		this.accion3 = accion3;
	}
	public boolean isAccion4() {
		return accion4;
	}
	public void setAccion4(boolean accion4) {
		this.accion4 = accion4;
	}
	public boolean isAccion5() {
		return accion5;
	}
	public void setAccion5(boolean accion5) {
		this.accion5 = accion5;
	}
	public boolean isAccion6() {
		return accion6;
	}
	public void setAccion6(boolean accion6) {
		this.accion6 = accion6;
	}
	public boolean isAccion7() {
		return accion7;
	}
	public void setAccion7(boolean accion7) {
		this.accion7 = accion7;
	}
	public boolean isAccion8() {
		return accion8;
	}
	public void setAccion8(boolean accion8) {
		this.accion8 = accion8;
	}
	public boolean isAccion9() {
		return accion9;
	}
	public void setAccion9(boolean accion9) {
		this.accion9 = accion9;
	}
	public boolean isAccion10() {
		return accion10;
	}
	public void setAccion10(boolean accion10) {
		this.accion10 = accion10;
	}
	public boolean isAccion11() {
		return accion11;
	}
	public void setAccion11(boolean accion11) {
		this.accion11 = accion11;
	}
	public boolean isAccion12() {
		return accion12;
	}
	public void setAccion12(boolean accion12) {
		this.accion12 = accion12;
	}
	public LoteAcciones() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean registrarAcciones(int usuario, int secuencial) {
		// TODO Auto-generated method stub
		boolean OK = true;
		OK = (this.accion1) ? registrarAccion(usuario,secuencial,1) : true;
		OK = (this.accion2) ? registrarAccion(usuario,secuencial,2) : true;
		OK = (this.accion3) ? registrarAccion(usuario,secuencial,3) : true;
		OK = (this.accion4) ? registrarAccion(usuario,secuencial,4) : true;
		OK = (this.accion5) ? registrarAccion(usuario,secuencial,5) : true;
		OK = (this.accion6) ? registrarAccion(usuario,secuencial,6) : true;
		OK = (this.accion7) ? registrarAccion(usuario,secuencial,7) : true;
		OK = (this.accion8) ? registrarAccion(usuario,secuencial,8) : true;
		OK = (this.accion9) ? registrarAccion(usuario,secuencial,9) : true;
		OK = (this.accion10) ? registrarAccion(usuario,secuencial,10) : true;
		OK = (this.accion11) ? registrarAccion(usuario,secuencial,11) : true;
		OK = (this.accion12) ? registrarAccion(usuario,secuencial,12) : true;
		return OK;
	}
	
	private boolean registrarAccion(int usuario, int secuencial, int accion){
		boolean OK = true;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO acciones_x_usuario (Usuario,Accion,"
					+ "FechaDeCreacion,Activo,Secuencial) VALUES ("+usuario+","
					+accion+",'"+LocalDate.now().toString()+"',"+1+","+secuencial+");");		
		}catch(SQLException se){
			se.printStackTrace();
		}
		return OK;
	}
	
}


