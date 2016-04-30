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
	private LatLng miPosicion;
	private Poi poiPrueba;
	
	@Before
	public void darContexto(){
		
		bancoNacion = new Poi();
		bancoNacion.setPoiLatitudGeo("-34.624847598913504");
		bancoNacion.setPoiLongitudGeo("-58.50617649033666");
		miPosicion = LatLng.newLatLng(Double.parseDouble("-34.6599673"), Double.parseDouble("-58.4682861"));
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
	Assert.assertEquals(31,distancia,0.7); 
		
}

@Test
public void distanciaKioscoTurco(){
	//precondiciones - contexto - escenario - fixture
	latPosicionS = "-34.623985";
	lonPosicionS = "-58.5056954";
	bancoNacion.setPoiLatitudGeo("-34.624847598913504");
	bancoNacion.setPoiLongitudGeo("-58.50617649033666");
	DistanceCalculator distanceCalculator = new DistanceCalculator();
	//ejecucion
	LatLng latLngPos = LatLng.newLatLng(Double.parseDouble(latPosicionS),Double.parseDouble(lonPosicionS));
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(bancoNacion.getPoiLatitudGeo()),Double.parseDouble(bancoNacion.getPoiLongitudGeo()));
	double distancia = distanceCalculator.distance(latLngPos,latLngPoi);
	//validacion
	Assert.assertEquals(1,distancia,0.5); 
		
}

@Test
public void pruebaCalculoDistanciaColectivo(){
	Boolean OK = false;
	int comuna = 8;
	//precondiciones - contexto - escenario - fixture
	poiPrueba = Poi.buscarPoi(10);
	//ejecucion
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(poiPrueba.getPoiLatitudGeo()),Double.parseDouble(poiPrueba.getPoiLongitudGeo()));
    OK = poiPrueba.calcularDistanciaPoi(poiPrueba, miPosicion, latLngPoi, comuna);
    //validacion
	Assert.assertTrue(OK); 	
}

@Test
public void pruebaCalculoDistanciaCGP(){
	Boolean OK = false;
	int comuna = 8;
	//precondiciones - contexto - escenario - fixture
	poiPrueba = Poi.buscarPoi(9);
	//ejecucion
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(poiPrueba.getPoiLatitudGeo()),Double.parseDouble(poiPrueba.getPoiLongitudGeo()));
    OK = poiPrueba.calcularDistanciaPoi(poiPrueba, miPosicion, latLngPoi, comuna);
    //validacion
	Assert.assertTrue(OK); 	
}

@Test
public void pruebaCalculoDistanciaLocalComercial(){
	Boolean OK = false;
	int comuna = 8;
	//precondiciones - contexto - escenario - fixture
	poiPrueba = Poi.buscarPoi(8);
	//ejecucion
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(poiPrueba.getPoiLatitudGeo()),Double.parseDouble(poiPrueba.getPoiLongitudGeo()));
    OK = poiPrueba.calcularDistanciaPoi(poiPrueba, miPosicion, latLngPoi, comuna);
    //validacion
	Assert.assertTrue(OK); 	
}

@Test
public void pruebaCalculoDistanciaBanco(){
	Boolean OK = false;
	int comuna = 8;
	//precondiciones - contexto - escenario - fixture
	poiPrueba = Poi.buscarPoi(11);
	//ejecucion
    LatLng latLngPoi = LatLng.newLatLng(Double.parseDouble(poiPrueba.getPoiLatitudGeo()),Double.parseDouble(poiPrueba.getPoiLongitudGeo()));
    OK = poiPrueba.calcularDistanciaPoi(poiPrueba, miPosicion, latLngPoi, comuna);
    //validacion
	Assert.assertTrue(OK); 	
}

}
