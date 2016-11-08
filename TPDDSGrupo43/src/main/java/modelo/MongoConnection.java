package modelo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import modelo.HistorialBusqueda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

public class MongoConnection{

	public static MongoClient crearConexion(){
		MongoClient mongo = null;
		try{
			mongo = new MongoClient("localhost", 27017);	
		}catch(UnknownHostException e){
			e.printStackTrace();
		}	
		return mongo;
	}
	
	public static void cerrarConexion(MongoClient mongo){
		mongo.close();
	}
	
	public static DBCollection getHistorial(MongoClient mongo){
		DBCollection col = null;
		try{
			DB db = mongo.getDB("tpdds");
			col = db.getCollection("historial");
		}catch(Exception e){
			e.printStackTrace();
		}
		return col;
	}
	
	public static void cargarJSONString(List<String> str,DBCollection col){
		try{
			DBObject dbObject = null;
			for(int i = 0; i<str.size(); i++){
				dbObject = (DBObject) JSON.parse(str.get(i));
				col.insert(dbObject);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}


