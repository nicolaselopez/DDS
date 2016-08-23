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
}
