package modelo;

import java.sql.Connection;
import java.util.Date;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class ProcesoStr {
	private static ArrayList<String> procesos;
	
	public void procesar() {
	}
	
	public void procesar(String usuario,LoteAcciones acciones) {
	}
	
	public static void generarProcesos(String dLun)
	{
		procesos = new ArrayList<String>();
		
		procesos.add(dLun);
	}
	
	public static ArrayList<String> getProcesos()
	{
		return procesos;
	}

	protected void grabarProceso(int proceso, String estado, String mensaje, Date inicio, Date fin) {
		// TODO Auto-generated method stub
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO logprocesos "+
				"(procesoid,inicio,fin,estado,mensaje) "+
				"VALUES "+
				"("+proceso+",'"+inicio.toString()+"','"+fin.toString()+"','"+estado+"','"+mensaje+"') ; ");
			if(rs == 1){
				OK = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void insertarAgenda(int proceso, String parametros, int usuario){
		Boolean OK = false;
		try{
			Date fecha = new Date();
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO agenda "+
				"(agendaproceso,agendaparametros,agendausuario,agendafecha,agendamarca) "+
				"VALUES "+
				"("+proceso+",'"+parametros+"',"+usuario+",'"+fecha.toString()+"',0) ; ");
			if(rs == 1){
				OK = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
