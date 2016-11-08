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
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import controlador.ServletCalculoDisponibilidad2;
import modelo.CGPAdapter;
import modelo.Conexion;
import modelo.Direccion;
import modelo.HistorialBusqueda;
import modelo.MongoConnection;
import modelo.Poi;
import modelo.Servicio;
 
@Path("/historialConsultas")
public class HistorialConsultas {
	
	private static final Logger log= Logger.getLogger( HistorialConsultas.class.getName() );
 
	  @GET
	  @Produces("application/json")
	  public Response historialConsultasDenied() throws JSONException {
 
			String result = "Escriba los filtros a utilizar en el webservice separados por el caracter '&'\n\nEjemplo: FechaDesde&FechaHasta. Formato AAAAMMDD";
			return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response historialConsultas(@PathParam("f") String f) throws JSONException {
 
		String[] parametros = f.split("&");
		String desde = "";
		String hasta = "";
		String result = "";
		if(parametros.length==2){
			desde = parametros[0];
			hasta = parametros[1];
		}
		HistorialBusqueda[] pois = new HistorialBusqueda[5000];
		ObjectMapper mapper = new ObjectMapper();
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from historialbusqueda where date(fechaBusqueda) BETWEEN '"+desde+"' AND '"+hasta+"' ;");
			if(hasta.length()==0)
			{
				rs=st.executeQuery("select * from historialbusqueda where date(fechaBusqueda) BETWEEN '"+desde+"' AND curdate() ;");
			}
			int i=0;
			while(rs.next()){
				pois[i]=new HistorialBusqueda(rs.getInt(1), rs.getDate(2), rs.getString(3));
				i++;
			}
			for(int k=i;k<5000;k++){
				pois[k]=new HistorialBusqueda();
				pois[k].setIdHistorial(-1);
			}
			for(int p = 0; p<i;p++){
				try {
					result = result + mapper.writeValueAsString(pois[p]) +"\n";
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch(SQLException se){
				se.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	  }
}