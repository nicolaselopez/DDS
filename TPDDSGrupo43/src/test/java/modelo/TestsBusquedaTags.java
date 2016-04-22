package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Nota: Para correr estos test hay que levantar el Server!

public class TestsBusquedaTags {
	
	private Servicio parada114;
	private Servicio kioscoElTurco;
	
	@Before
	public void darContexto(){

		parada114 = Servicio.buscarServicio(2);
		kioscoElTurco = Servicio.buscarServicio(1);
	}	
	
@Test
public void TagColectivo(){
	//precondiciones - contexto - escenario - fixture
	
	//ejecucion
	Servicio[] servicios = Servicio.consultarServiciosTag("colectivo");
	//validacion
    Assert.assertTrue(servicios.toString().contains("1"));
//	Assert.assertFalse(serviciosQueCumplenConTag.toString().contains("parada114")); 
}

//@Test
//public void TagKiosco(){
//	//precondiciones - contexto - escenario - fixture
//	
//	//ejecucion
//    boolean estaDisponible = kioscoElTurco.calcularDisponibilidad(martes,hora);
//	//validacion
//	Assert.assertFalse(estaDisponible); 
//}
//

}