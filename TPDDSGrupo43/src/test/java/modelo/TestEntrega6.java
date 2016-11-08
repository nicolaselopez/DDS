package modelo;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.ServletCalculoDisponibilidad2;
import modelo.DistanceCalculator;
import modelo.LatLng;

public class TestEntrega6 {
	
	private Poi poiPrueba;
	private Usuario usuarioPrueba;
	private Usuario usuarioPrueba2;
	private Rubro rubroPrueba;
	private Servicio[] servicioPrueba;
	private Direccion direccionPrueba;
	private Barrio barrioPrueba;
	boolean subirPoi;
	private Poi nuevoPoi;
	boolean borrarPoi;
	boolean editado;

	private static final Logger log= Logger.getLogger( TestEntrega6.class.getName() );
	
	@Before
	public void darContexto(){
		usuarioPrueba = new Usuario( );
		usuarioPrueba.setNombre("nombre");
		usuarioPrueba.setClave("clave");
		usuarioPrueba.setCorreo("correo@asd.com");
		usuarioPrueba.setUsuario("usuario");
		usuarioPrueba.setRol(0);
		poiPrueba = new Poi();
		rubroPrueba = new Rubro();
		barrioPrueba = new Barrio();
		direccionPrueba = new Direccion();
		poiPrueba.PoiIdTipoPoi=1;
		poiPrueba.PoiDescripcion="asd";
		poiPrueba.PoiIdRubro= 1;
		poiPrueba.PoiRubro = rubroPrueba;
		poiPrueba.PoiServicio = servicioPrueba ;
		poiPrueba.PoiDireccion = direccionPrueba;
		poiPrueba.PoiBarrio = barrioPrueba;
		poiPrueba.PoiLatitudGeo = "-34.624847598913504";
		poiPrueba.PoiLongitudGeo = "-34.624847598913504";
		poiPrueba.PoiActivo = 1;
			
	}
	

// Muchas de las precondiciones podrian ir dentro de la parte @before

@Test
public void test1y2(){
	subirPoi = Poi.registrarPoi(poiPrueba);
	log.info("El valor de registrar Poi fue: " + subirPoi);
	nuevoPoi = Poi.buscarPoiDesc(poiPrueba.PoiDescripcion);
	log.info("La id del Poi es: " + nuevoPoi.IdPoi);
	nuevoPoi.PoiLatitudGeo= "123456789";
	Poi.editarPoi(nuevoPoi);
	nuevoPoi = Poi.buscarPoiDesc(poiPrueba.PoiDescripcion);
	log.info("La Latitud del Poi es: " + nuevoPoi.PoiLatitudGeo);
	
	log.info("La id del Poi es: " + nuevoPoi.IdPoi);
	borrarPoi = Poi.editarEstadoPoi(nuevoPoi.IdPoi , 0);
	log.info("El valor de registrar Poi fue: " + borrarPoi);
	nuevoPoi = Poi.buscarPoiDesc(poiPrueba.PoiDescripcion);

	if(nuevoPoi == null ){
		borrarPoi = true;
	}
	
	
	Assert.assertTrue(borrarPoi);
}

@Test
public void test3(){
	subirPoi = Poi.registrarPoi(poiPrueba);
	nuevoPoi = Poi.buscarPoiDesc(poiPrueba.PoiDescripcion);
	subirPoi = Poi.registrarPoi(nuevoPoi);
	log.info("id del nuevo poi " + nuevoPoi.IdPoi);
	
	poiPrueba = Poi.buscaPoi(nuevoPoi.IdPoi);
	
	Assert.assertTrue(nuevoPoi.IdPoi == poiPrueba.IdPoi) ;
	
}

}
