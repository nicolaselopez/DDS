package modelo;

import java.util.ArrayList;

public abstract class ProcesoStr {
	private static ArrayList<String> procesos;
	
	public void procesar() {
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

	protected void grabarProceso(String mensaje) {
		// TODO Auto-generated method stub
		
	}
	
}
