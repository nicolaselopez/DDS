package com.services;
 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import controlador.ServletCalculoDisponibilidad2;
import modelo.CGPAdapter;
import modelo.Conexion;
import modelo.Direccion;
import modelo.HistorialMongo;
import modelo.Poi;
import modelo.ResultadosMongo;
import modelo.Servicio;
 
@Path("/busquedaCriterios")
public class BusquedaCriterios {
	
	private static final Logger log= Logger.getLogger( BusquedaCriterios.class.getName() );
 
	  @GET
	  @Produces("application/json")
	  public Response busquedaCriteriosDenied() throws JSONException {
 
			String result = "Escriba los filtros a utilizar en el webservice separados por el caracter '&'.";
			return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response busquedaCriterios(@PathParam("f") String f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		String[] parametros = f.split("&");
		String filtro1 = "(";
		String filtro2 = "(";
		String filtro3 = "(";
		String result = "";
		String criterio = "";
		List<ResultadosMongo> resultados = new ArrayList<ResultadosMongo>();
		for(int j = 0; j<parametros.length;j++){
			criterio = criterio + parametros[j] + "; "; 
		}
		for(int i=0; i<parametros.length;i++){
			filtro1 = filtro1 + "ServicioTags like '%" + parametros[i] + "%' ";
			filtro2 = filtro2 + "PoiDescripcion like '%" + parametros[i] + "%' ";
			filtro3 = filtro3 + "ServicioDescripcion like '%" + parametros[i] + "%' ";
			if(i!=(parametros.length-1)){
				filtro1 = filtro1 + "or ";
				filtro2 = filtro2 + "or ";
				filtro3 = filtro3 + "or ";
			}else{
				filtro1 = filtro1 + ") or ";
				filtro2 = filtro2 + ") or ";
				filtro3 = filtro3 + ");";
			}
		}
		Poi[] pois = new Poi[5000];
		ObjectMapper mapper = new ObjectMapper();
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			String consulta = "Select poi.* from poi inner join servicio on IdPoi = ServicioIdPoi";
			consulta = consulta + " where " + filtro1 + filtro2 + filtro3;
			log.info("La consulta a ejecutar fue: " + consulta);
			ResultSet rs=st.executeQuery(consulta);
			int i=0;
			while(rs.next()){
				Direccion poiDireccion = Direccion.parametrizarDireccion(rs);
				pois[i]=new Poi(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), poiDireccion,rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getInt(19));
				pois[i].setPoiServicio(Servicio.consultarServicios(pois[i].getIdPoi(),false,true));
				resultados.add(new ResultadosMongo(pois[i].getIdPoi(),pois[i].getPoiDescripcion()));
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new Poi();
				pois[k].setIdPoi(-1);
			}
			
			for(int p = 0; p<i;p++){
				try {
					result = result + mapper.writeValueAsString(pois[p]) +"\n";
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			HistorialMongo.registrarHistorial(criterio, resultados);
		}catch(SQLException se){
			se.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	  }
}