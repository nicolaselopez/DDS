package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcesoStr {
	private static List<String> procesos;
	
	public void procesar() {
	}
	
	public static void generarProcesos(String dLun)
	{
		procesos = new ArrayList<String>();
		
		procesos.add(dLun);
	}
	
	public static List<String> getProcesos()
	{
		return procesos;
	}

}
