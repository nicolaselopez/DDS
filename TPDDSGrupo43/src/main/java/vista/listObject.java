package vista;

import modelo.Barrio;
import modelo.Poi;
import modelo.Rubro;
import modelo.Servicio;
import modelo.TipoPoi;

public class listObject{
	
	public Barrio[] getlistBarrio(){
		Barrio[] barrios;
				barrios = Barrio.consultarBarrios();
		return barrios;
	}
	
	public Rubro[] getlistRubro(){
		Rubro[] rubros;
				rubros = Rubro.consultarRubros();
		return rubros;
	}

	public TipoPoi[] getlistTipoPoi(){
		TipoPoi[] tipoPoi;
		tipoPoi = TipoPoi.consultarTipoPois();
		return tipoPoi;
	}

	public Poi[] getlistPoi(){
		Poi[] pois;
		pois = Poi.consultarPois();
		return pois;
	}
	
	public Poi[] getlistPoiConServicio(Boolean poiActivo,Boolean servicioActivo){
		Poi[] pois;
		pois = Poi.consultarPoisServicio(poiActivo,servicioActivo);
		return pois;
	}
	
	public Poi[] getlistPoiActivo(int estado){
		Poi[] pois;
		pois = Poi.consultarPoisporEstado(estado);
		return pois;
	}
	
	public Servicio[] getlistServicios(Poi poi){
		Servicio[] serviciosPoi;
		serviciosPoi = poi.getPoiServicio();
		return serviciosPoi;
	}
	public Servicio[] getlistServicios(int idPoi ,Boolean externo,Boolean servicioActivo){
		Servicio[] serviciosPoi;
		serviciosPoi = Servicio.consultarServicios(idPoi, externo, servicioActivo);
		return serviciosPoi;
	}
	
	public String[] getlistProcesos()
	{
		String[] procesos = {"Proceso1", "Proceso2", "Proceso3", "Proceso4"};
		return procesos;
	}
}
