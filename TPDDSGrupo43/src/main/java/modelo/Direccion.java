package modelo;

import java.sql.ResultSet;

public class Direccion {
	
	private String PoiCalle;
	private String PoiNumero;
	private String PoiPiso;
	private String PoiDepto;
	private String PoiUnidad;
	private String PoiCodPos;
	private int PoiIdLocalidad;
	private int PoiIdBarrio;
	private int PoiIdProvincia;
	private int PoiIdPais;
	
	public String getPoiCalle() {
		return PoiCalle;
	}

	public void setPoiCalle(String poiCalle) {
		PoiCalle = poiCalle;
	}

	public String getPoiNumero() {
		return PoiNumero;
	}

	public void setPoiNumero(String poiNumero) {
		PoiNumero = poiNumero;
	}

	public String getPoiPiso() {
		return PoiPiso;
	}

	public void setPoiPiso(String poiPiso) {
		PoiPiso = poiPiso;
	}

	public String getPoiDepto() {
		return PoiDepto;
	}

	public void setPoiDepto(String poiDepto) {
		PoiDepto = poiDepto;
	}

	public String getPoiUnidad() {
		return PoiUnidad;
	}

	public void setPoiUnidad(String poiUnidad) {
		PoiUnidad = poiUnidad;
	}

	public String getPoiCodPos() {
		return PoiCodPos;
	}

	public void setPoiCodPos(String poiCodPos) {
		PoiCodPos = poiCodPos;
	}

	public int getPoiIdLocalidad() {
		return PoiIdLocalidad;
	}

	public void setPoiIdLocalidad(int poiIdLocalidad) {
		PoiIdLocalidad = poiIdLocalidad;
	}

	public int getPoiIdBarrio() {
		return PoiIdBarrio;
	}

	public void setPoiIdBarrio(int poiIdBarrio) {
		PoiIdBarrio = poiIdBarrio;
	}

	public int getPoiIdProvincia() {
		return PoiIdProvincia;
	}

	public void setPoiIdProvincia(int poiIdProvincia) {
		PoiIdProvincia = poiIdProvincia;
	}

	public int getPoiIdPais() {
		return PoiIdPais;
	}

	public void setPoiIdPais(int poiIdPais) {
		PoiIdPais = poiIdPais;
	}
	
	public Direccion(String poiCalle, String poiNumero, String poiPiso, String poiDepto, String poiUnidad,
			String poiCodPos, int poiIdLocalidad, int poiIdBarrio, int poiIdProvincia, int poiIdPais) {
		super();
		PoiCalle = poiCalle;
		PoiNumero = poiNumero;
		PoiPiso = poiPiso;
		PoiDepto = poiDepto;
		PoiUnidad = poiUnidad;
		PoiCodPos = poiCodPos;
		PoiIdLocalidad = poiIdLocalidad;
		PoiIdBarrio = poiIdBarrio;
		PoiIdProvincia = poiIdProvincia;
		PoiIdPais = poiIdPais;
	}
	
	

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Direccion parametrizarDireccion(ResultSet rs){
		try{
			Direccion direccion = new Direccion(rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getInt(13),rs.getInt(14));
			return direccion;
		}catch(Exception e){
			Direccion direccion = new Direccion();
			return direccion;
		}
		
	}
	
}