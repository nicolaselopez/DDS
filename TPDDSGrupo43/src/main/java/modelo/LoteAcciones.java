package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Logger;

import controlador.ServletCalculoDisponibilidad2;

public class LoteAcciones {
	
	private static final Logger log= Logger.getLogger( ServletCalculoDisponibilidad2.class.getName() );
	
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
	private boolean accion13 = false;
	private boolean accion14 = false;
	
	public boolean isAccion14() {
		return accion14;
	}
	public void setAccion14(boolean accion14) {
		this.accion14 = accion14;
	}
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
	public boolean isAccion13() {
		return accion13;
	}
	public void setAccion13(boolean accion13) {
		this.accion13 = accion13;
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
		OK = (this.accion13) ? registrarAccion(usuario,secuencial,13) : true;
		OK = (this.accion14) ? registrarAccion(usuario,secuencial,14) : true;
		return OK;
	}
	
	private boolean registrarAccion(int usuario, int secuencial, int accion){
		boolean OK = true;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			log.info("INSERT INTO acciones_x_usuario (Usuario,Accion,"
					+ "FechaDeCreacion,Activo,Secuencial) VALUES ("+usuario+","
					+accion+",'"+LocalDate.now().toString()+"',"+1+","+secuencial+");");
			Integer rs=st.executeUpdate("INSERT INTO acciones_x_usuario (Usuario,Accion,"
					+ "FechaDeCreacion,Activo,Secuencial) VALUES ("+usuario+","
					+accion+",'"+LocalDate.now().toString()+"',"+1+","+secuencial+");");		
		}catch(SQLException se){
			se.printStackTrace();
		}
		return OK;
	}
	
	public String convertToString(){
		String resultado = "";
			if(this.accion1){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion2){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion3){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion4){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion5){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion6){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion7){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion8){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion9){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion10){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion11){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion12){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion13){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
			if(this.accion14){
				resultado = resultado + "1;";
			}else{
				resultado = resultado + "0;";
			}
		return resultado;
	}
	
	public static LoteAcciones convertToLote(String parametros){
		LoteAcciones resultado = new LoteAcciones();
		String[] acciones = parametros.split(";");
			if(acciones[0].equals("1")){
				resultado.setAccion1(true);
			}else{
				resultado.setAccion1(false);
			}
			if(acciones[1].equals("1")){
				resultado.setAccion2(true);
			}else{
				resultado.setAccion2(false);
			}
			if(acciones[2].equals("1")){
				resultado.setAccion3(true);
			}else{
				resultado.setAccion3(false);
			}
			if(acciones[3].equals("1")){
				resultado.setAccion4(true);
			}else{
				resultado.setAccion4(false);
			}
			if(acciones[4].equals("1")){
				resultado.setAccion5(true);
			}else{
				resultado.setAccion5(false);
			}
			if(acciones[5].equals("1")){
				resultado.setAccion6(true);
			}else{
				resultado.setAccion6(false);
			}
			if(acciones[6].equals("1")){
				resultado.setAccion7(true);
			}else{
				resultado.setAccion7(false);
			}
			if(acciones[7].equals("1")){
				resultado.setAccion8(true);
			}else{
				resultado.setAccion8(false);
			}
			if(acciones[8].equals("1")){
				resultado.setAccion9(true);
			}else{
				resultado.setAccion9(false);
			}
			if(acciones[9].equals("1")){
				resultado.setAccion10(true);
			}else{
				resultado.setAccion10(false);
			}
			if(acciones[10].equals("1")){
				resultado.setAccion11(true);
			}else{
				resultado.setAccion11(false);
			}
			if(acciones[11].equals("1")){
				resultado.setAccion12(true);
			}else{
				resultado.setAccion12(false);
			}
			if(acciones[12].equals("1")){
				resultado.setAccion13(true);
			}else{
				resultado.setAccion13(false);
			}
			if(acciones[13].equals("1")){
				resultado.setAccion14(true);
			}else{
				resultado.setAccion14(false);
			}
		return resultado;
	}
	
}


