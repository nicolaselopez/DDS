package modelo;

public class LatLng {

	private Double lat;
	private Double lng;
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public LatLng(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	public LatLng() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static LatLng newLatLng(Double lat,Double lng){
		LatLng latlng = new LatLng(lat,lng);
		return latlng;
	}
	public static LatLng newLatLng(){
		LatLng latlng = new LatLng();
		return latlng;
	}
	
}
