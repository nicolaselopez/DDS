package modelo;

import modelo.LatLng;

public class DistanceCalculator
{

	private static double tamanoCuadra = 100; // distancia en metros
	
	private static double radioTierra = 6371000; //metros
	
	public static double distance(LatLng latLngPos, LatLng latLngPoi) {
		double dLat = Math.toRadians(latLngPos.getLat()-latLngPoi.getLat());
	    double dLng = Math.toRadians(latLngPos.getLng()-latLngPoi.getLng());
	    double latitud = Math.sin(dLat/2) * Math.sin(dLat/2);    
	    double longitud = Math.sin(dLng/2) * Math.sin(dLng/2);
	    double cLat = 2 * Math.atan2(Math.sqrt(latitud), Math.sqrt(1-latitud));
	    double cLng = 2 * Math.atan2(Math.sqrt(longitud), Math.sqrt(1-longitud));
	    double distanciaLatitud = (radioTierra * cLat);
	    double distanciaLongitud = (radioTierra * cLng);
	    double dist =(distanciaLatitud + distanciaLongitud)/tamanoCuadra;
	    return dist;
	}

	
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians			:*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees			:*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}