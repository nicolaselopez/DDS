package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.DistanceCalculator;
import modelo.LatLng;

public class TestsCalculoDistancia {
	
	private Poi bancoNacion;
	private String latPosicionS;
	private String lonPosicionS;
	
	@Before
	public void darContexto(){
		
		bancoNacion = new Poi();
		bancoNacion.setPoiLatitudGeo("-34.624847598913504");
		bancoNacion.setPoiLongitudGeo("-58.50617649033666");

	}
	

// Muchas de las precondiciones podrian ir dentro de la parte @before

@Test
public void distanciaABancoNacion0(){
	//precondiciones - contexto - escenario - fixture
	latPosicionS = "-34.624847598913504";
	lonPosicionS = "-58.50617649033666";
	DistanceCalculator distanceCalculator = new DistanceCalculator();
	//ejecucion
	LatLng latLngPos = LatLng.newLatLng(Double.parseDouble(latPosicionS),Double.parseDouble(lonPosicionS));
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(bancoNacion.getPoiLatitudGeo()),Double.parseDouble(bancoNacion.getPoiLongitudGeo()));
	double distancia = distanceCalculator.distance(latLngPos,latLngPoi);
	//validacion
	Assert.assertEquals(0,distancia,0.01); // El tercer campo es el margen de error permitido
		
}

@Test
public void distanciaABancoNacion20Aprox(){
	//precondiciones - contexto - escenario - fixture
	latPosicionS = "-34.636847598913504";
	lonPosicionS = "-58.52261340033666";
	DistanceCalculator distanceCalculator = new DistanceCalculator();
	//ejecucion
	LatLng latLngPos = LatLng.newLatLng(Double.parseDouble(latPosicionS),Double.parseDouble(lonPosicionS));
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(bancoNacion.getPoiLatitudGeo()),Double.parseDouble(bancoNacion.getPoiLongitudGeo()));
	double distancia = distanceCalculator.distance(latLngPos,latLngPoi);
	//validacion
	Assert.assertEquals(20,distancia,0.15); 
		
}





}
