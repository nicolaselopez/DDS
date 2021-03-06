package modelo;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Nota: Para correr estos test hay que levantar el Server!

public class TestsDisponibilidadServicio {
	
	private Servicio paradaColectivo;
	private Servicio kioscoElTurco;
	private Servicio carrefour;
	
	@Before
	public void darContexto(){

		paradaColectivo = Servicio.buscarServicio(2);
		kioscoElTurco = Servicio.buscarServicio(1);
		carrefour = Servicio.buscarServicio(3);
		kioscoElTurco.setServicioIdPoi(1);
		carrefour.setServicioIdPoi(3);
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
public void KioscoMartesAlas2301AMNoDisponible(){ 
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"23", "01", "00"};
	int martes = kioscoElTurco.calcularDiaDisponible("Mar");
	//ejecucion
    boolean estaDisponible = kioscoElTurco.calcularDisponibilidad(martes,hora);
	//validacion
	Assert.assertFalse(estaDisponible); 
}


@Test
public void KioscoDomingoAlas1722NoDisponible(){ 
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"17", "22", "00"};
	int domingo = kioscoElTurco.calcularDiaDisponible("Dom");
	//ejecucion
    boolean estaDisponible = kioscoElTurco.calcularDisponibilidad(domingo,hora);
	//validacion
	Assert.assertFalse(estaDisponible);

}

@Test
public void Kiosco20160709NoDisponibleFeriado(){
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"10", "00", "00"};
	int sabado = kioscoElTurco.calcularDiaDisponible("Sab");
	
	//ejecucion
	boolean noEsFeriado = kioscoElTurco.esFechaHabil(LocalDate.of(2016, 01, 01));
    boolean estaDisponible = kioscoElTurco.calcularDisponibilidad(sabado,hora);
	//validacion
	Assert.assertFalse(estaDisponible && noEsFeriado);
}

@Test
public void Carrefour20160620NoDisponibleFeriado(){
	//precondiciones - contexto - escenario - fixture
	String[] hora = {"08", "05", "00"};
	int lunes = carrefour.calcularDiaDisponible("Lun");
	
	//ejecucion
	boolean noEsFeriado = carrefour.esFechaHabil(LocalDate.of(2016, 06, 20));
    boolean estaDisponible = carrefour.calcularDisponibilidad(lunes,hora);
	//validacion
	Assert.assertFalse(estaDisponible && noEsFeriado);
}
}


