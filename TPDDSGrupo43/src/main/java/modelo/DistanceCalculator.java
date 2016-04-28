package modelo;

import modelo.LatLng;

public class DistanceCalculator
{

	private static double tamanoCuadra = 100; // distancia en metros
	
	public static double distance(LatLng latLangPos, LatLng latLangPoi) {
		double theta = latLangPos.getLng() - latLangPoi.getLng();
		double dist = Math.sin(deg2rad(latLangPos.getLat())) * Math.sin(deg2rad(latLangPoi.getLat())) + Math.cos(deg2rad(latLangPos.getLat())) * Math.cos(deg2rad(latLangPoi.getLat())) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;
		dist = (dist * 1000)/tamanoCuadra;
		return (dist);
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