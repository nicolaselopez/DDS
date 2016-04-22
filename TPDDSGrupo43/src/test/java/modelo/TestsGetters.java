package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestsGetters {
	
	private Poi parada7;
	private Poi bancoNacion;
	private Rubro SucursalDeBanco;
	
	
	@Before
	public void darContexto(){
		
		parada7 = new Poi();
		bancoNacion = new Poi();
		bancoNacion.setPoiLatitudGeo("-34.624847598913504");
		bancoNacion.setPoiLongitudGeo("-58.50617649033666");

	}
	

// Muchas de las precondiciones podrian ir dentro de la parte @before

@Test
public void getIDParada7() {
	//precondiciones - contexto - escenario - fixture
	parada7.setIdPoi(20);
	//ejecucion
	
	//validacion
	Assert.assertEquals(20, parada7.getIdPoi());
}

@Test
public void getRubroBancoNacion(){
	//precondiciones - contexto - escenario - fixture
	bancoNacion.setPoiRubro(SucursalDeBanco);
	//ejecucion
	
	//validacion
	Assert.assertEquals(SucursalDeBanco, bancoNacion.getPoiRubro());
	
}

}
