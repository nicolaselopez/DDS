package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Banco extends Poi {

	public Banco(Poi poi) {
		super();
		IdPoi = poi.getIdPoi();
		PoiIdTipoPoi = poi.getPoiIdTipoPoi();
		PoiDescripcion = poi.getPoiDescripcion();
		PoiIdRubro = poi.getPoiIdRubro();
		PoiRubro = poi.getPoiRubro();
		PoiBarrio = poi.getPoiBarrio();
		PoiServicio = poi.getPoiServicio();
		PoiDireccion = poi.getPoiDireccion();
		PoiLatitudGeo = poi.getPoiLatitudGeo();
		PoiLongitudGeo = poi.getPoiLongitudGeo();
		PoiFechaAlta = poi.getPoiFechaAlta();
		PoiFechaModificacion = poi.getPoiFechaModificacion();
		PoiActivo = poi.getPoiActivo();
	}
	
	public Banco(int idPoi, int poiIdTipoPoi, String poiDescripcion, int poiIdRubro, Rubro poiRubro, Barrio poiBarrio,
			Servicio[] poiServicio, Direccion poiDireccion, String poiLatitudGeo, String poiLongitudGeo,
			String poiFechaAlta, String poiFechaModificacion, int poiActivo) {
		super();
		IdPoi = idPoi;
		PoiIdTipoPoi = poiIdTipoPoi;
		PoiDescripcion = poiDescripcion;
		PoiIdRubro = poiIdRubro;
		PoiRubro = poiRubro;
		PoiBarrio = poiBarrio;
		PoiServicio = poiServicio;
		PoiDireccion = poiDireccion;
		PoiLatitudGeo = poiLatitudGeo;
		PoiLongitudGeo = poiLongitudGeo;
		PoiFechaAlta = poiFechaAlta;
		PoiFechaModificacion = poiFechaModificacion;
		PoiActivo = poiActivo;
	}

	public Boolean calcularDistanciaPoi(Poi poi,LatLng latLngPos,LatLng latLngPoi, int comuna){
		Boolean OK = false;
		double distancia = DistanceCalculator.distance(latLngPos,latLngPoi);
		if(distancia <=5){
			OK = true;
		}
		return OK;
	}
	
	public Boolean calcularDisponibilidadPoi(Poi poi, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Boolean OK;
		SimpleDateFormat horario = new SimpleDateFormat("HH:mm:ss");
	    
		Date dateHoy = new Date();
		
		String[] horaHoyParts = horario.format(dateHoy).split(":");
		
	    Calendar c = Calendar.getInstance();
	    c.setTime(dateHoy);
	    int dayOfWeekHoy = c.get(Calendar.DAY_OF_WEEK);
	    
		if(Integer.parseInt(horaHoyParts[0])<10 || Integer.parseInt(horaHoyParts[0])>=15)
		{
			OK = false;

			request.setAttribute("OK", OK);
			request.getRequestDispatcher("resultadoDisponibilidad.jsp").forward(request, response);
		}
		else
		{
			
			request.getRequestDispatcher("seleccionarServicio.jsp").forward(request, response);
		}
		return false;
	}
	
	public static Boolean consultaBancosWS(){
		Boolean OK = false;
		String rutaWebService = "http://private-96b476-ddsutn.apiary-mock.com/banks?banco=banco&servicio=servicio";
		try{
			//Se crea conexion a WebService
			URL url = new URL(rutaWebService);
			URLConnection conexionUrl = url.openConnection();
			//Se lee contenido WS
			BufferedReader buffer = new BufferedReader(new InputStreamReader(conexionUrl.getInputStream()));
			String line;
			final StringBuilder builder = new StringBuilder(2048);
			while ((line=buffer.readLine())!=null){
				builder.append(line);
			}
			//Convertir a JSON Array el contenido del WS
			JSONArray jsonResponse = new JSONArray(builder.toString());	
			Banco[] bancos = new Banco[jsonResponse.length()];
			int contadorServicios = 100000;
			for(int i=0;i<jsonResponse.length();i++){
				JSONObject jsonObject = (JSONObject) jsonResponse.get(i);
				Servicio[] PoiServicio = Servicio.crearServiciosBancoXDefecto(jsonObject);
				for(int k=0;k<PoiServicio.length;k++){
					PoiServicio[k].setIdServicio(contadorServicios);
					PoiServicio[k].setServicioIdPoi(i+100000);
					contadorServicios++;
				}
				int IdPoi = i+100000;
				int PoiIdTipoPoi = 3;
				String PoiDescripcion = jsonObject.getString("banco");
				int PoiIdRubro = 0;
				Rubro PoiRubro = null;
				Barrio PoiBarrio = null;
				Direccion PoiDireccion = new Direccion();
				PoiDireccion.setPoiUnidad(jsonObject.getString("gerente"));
				PoiDireccion.setPoiCalle(jsonObject.getString("sucursal"));
				double PoiLatitudGeo = jsonObject.getDouble("y");
				double PoiLongitudGeo = jsonObject.getDouble("x");
				String PoiFechaAlta = "";
				String PoiFechaModificacion = "";
				int PoiActivo = 1;
				bancos[i] = new Banco(IdPoi,PoiIdTipoPoi,PoiDescripcion,PoiIdRubro,PoiRubro,PoiBarrio,PoiServicio,PoiDireccion,Double.toString(PoiLatitudGeo),Double.toString(PoiLongitudGeo),PoiFechaAlta,PoiFechaModificacion,PoiActivo);
			}
			OK = Banco.persistirBancosExternos(bancos);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return OK;
	}
	
	public static Boolean persistirBancosExternos(Banco[] bancos){
		Boolean OK = false;
		try{
			Banco.limpiarTablas();
			for(int i=0;i<bancos.length;i++){
				OK = persistirBanco(bancos[i]);
			}
		}catch(Exception e){
			OK=false;
		}		
		return OK;
	}
	
	public static void limpiarTablas(){
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("DELETE FROM bancoexterno;");
			rs = st.executeUpdate("DELETE FROM servicioexterno;");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Boolean persistirBanco(Banco poi){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs=st.executeUpdate("INSERT INTO bancoexterno "+
				"(IdPoiExterno,PoiExternoIdTipoPoi,PoiExternoDescripcion,PoiExternoSucursal,PoiExternoGerente,PoiExternoLatitudGeo,PoiExternoLongitudGeo,PoiExternoActivo) "+
				"VALUES "+
				"("+poi.getIdPoi()+","+poi.getPoiIdTipoPoi()+",'"+poi.getPoiDescripcion()+"','"+poi.getPoiDireccion().getPoiCalle()+"','"+poi.getPoiDireccion().getPoiUnidad()+"','"+poi.getPoiLatitudGeo()+"','"
				+poi.getPoiLongitudGeo()+"',"+poi.getPoiActivo()+");");
			if(rs == 1){
				OK = true;
			}
			if(poi.getPoiServicio() != null){
				OK = false;
				for(int i=0; i<poi.getPoiServicio().length;i++){
					rs = st.executeUpdate("INSERT INTO servicioexterno(IdServicioExterno,ServicioExternoIdPoiExterno,ServicioExternoIdTipoPoi,ServicioExternoDescripcion,"
							+"ServicioExternoDiaDisponible,ServicioExternoHoraDesde1,ServicioExternoHoraHasta1,ServicioExternoHoraDesde2,"
							+"ServicioExternoHoraHasta2,ServicioExternoTags,"
							+"ServicioExternoActivo)VALUES("
							+poi.getPoiServicio()[i].getIdServicio()+","
							+poi.getPoiServicio()[i].getServicioIdPoi()+","+poi.getPoiServicio()[i].getServicioIdTipoPoi()+",'"+poi.getPoiServicio()[i].getServicioDescripcion()+"','"
							+poi.getPoiServicio()[i].getServicioDiaDisponible()+"','"+poi.getPoiServicio()[i].getServicioHoraDesde1()+"','"+poi.getPoiServicio()[i].getServicioHoraHasta1()+"','"
							+poi.getPoiServicio()[i].getServicioHoraDesde2()+"','"+poi.getPoiServicio()[i].getServicioHoraHasta2()+"','"+poi.getPoiServicio()[i].getServicioTags()+"',"+poi.getPoiServicio()[i].getServicioActivo()+");");
				}
				if(rs == 1){
					OK = true;
				}
			}				
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}		
		return OK;
	}
	
}
