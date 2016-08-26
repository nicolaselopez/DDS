package modelo;

public class ProcesoContext {
	private static ProcesoStr procesoStrategy;
	
	public ProcesoContext(ProcesoStr strategy)
	{
		procesoStrategy = strategy;
	}
	
	public void executeStrategy()
	{
		procesoStrategy.procesar();
	}
	
	public void executeStrategy(String usuario,LoteAcciones acciones){
		procesoStrategy.procesar(usuario, acciones);
	}
	
	public void procesar(String usuario, LoteAcciones acciones)
	{
		
	}
}
