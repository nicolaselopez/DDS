package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Nota: Para correr estos test hay que levantar el Server!

public class TestsDisponibilidadServicio {
	
	private Servicio paradaColectivo;
	private Servicio kioscoElTurco;
	
	@Before
	public void darContexto(){

		paradaColectivo = Servicio.buscarServicio(2);
		kioscoElTurco = Servicio.buscarServicio(1);
	}	
	
@Test
public void ParadaSabadoAlas3AMDisponible(){ //Deberian estar siempre disponibles
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"03", "00", "00"};
	int sabado = paradaColectivo.calcularDiaDisponible("Sab");
	//ejecucion
    boolean estaDisponible = paradaColectivo.calcularDisponibilidad(sabado,hora);
	//validacion
	Assert.assertTrue(estaDisponible); 
}

@Test
public void KioscoMartesAlas2301AMNoDisponible(){ //Deberian estar siempre disponibles
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"23", "01", "00"};
	int martes = kioscoElTurco.calcularDiaDisponible("Mar");
	//ejecucion
    boolean estaDisponible = kioscoElTurco.calcularDisponibilidad(martes,hora);
	//validacion
	Assert.assertFalse(estaDisponible); 
}


}
