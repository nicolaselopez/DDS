package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Nota: Para correr estos test hay que levantar el Server!

public class TestsBusquedaTags {
	
	String tagTrue = "colectivo";
	String tagFalse = "xassds";
	
	@Before
	public void darContexto(){


	}	
	
	@Test
	public void TagTrue(){
		//precondiciones - contexto - escenario - fixture
		//
		//ejecucion
		Servicio[] servicios = Servicio.consultarServiciosTag(tagTrue);
		//validacion
	    Assert.assertTrue(servicios != null);
	}

	@Test
	public void TagFalse(){
		//precondiciones - contexto - escenario - fixture
		//
		//ejecucion
		Servicio[] servicios = Servicio.consultarServiciosTag(tagTrue);
		//validacion
		Assert.assertFalse(servicios == null); 
	}
	

}