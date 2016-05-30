package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.DistanceCalculator;
import modelo.LatLng;

public class TestWebServiceBanco {
	
	
	@Before
	public void darContexto(){

	}
	

	// Muchas de las precondiciones podrian ir dentro de la parte @before

	@Test
	public void testWS(){
		//precondiciones - contexto - escenario - fixture
		Boolean OK = false;
		//ejecucion
		OK = Banco.consultaBancosWS();
		//validacion
		Assert.assertTrue(OK); // El tercer campo es el margen de error permitido
			
	}

}
