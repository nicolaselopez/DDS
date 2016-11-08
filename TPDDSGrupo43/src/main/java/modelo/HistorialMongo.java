package modelo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class HistorialMongo {

	private String _id;
	private Date fechaBusqueda;
	private String criterio;
	private List<ResultadosMongo> resultado;
	
	public Date getFechaBusqueda() {
		return fechaBusqueda;
	}
	public void setFechaBusqueda(Date fechaBusqueda) {
		this.fechaBusqueda = fechaBusqueda;
	}
	public String getCriterio() {
		return criterio;
	}
	public void setCriterio(String criterio) {
		this.criterio = criterio;
	}
	public String get_id() {
		return _id;
	}
	
	public List<ResultadosMongo> getResultado() {
		return resultado;
	}
	public void setResultado(List<ResultadosMongo> resultado) {
		this.resultado = resultado;
	}
	public HistorialMongo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistorialMongo(String _id, Date fechaBusqueda, String criterio) {
		super();
		this._id = _id;
		this.fechaBusqueda = fechaBusqueda;
		this.criterio = criterio;
	}
	public HistorialMongo(String _id, Date fechaBusqueda, String criterio,List<ResultadosMongo> resultados) {
		super();
		this._id = _id;
		this.fechaBusqueda = fechaBusqueda;
		this.criterio = criterio;
		this.resultado = resultados;
	}
	public HistorialMongo(Date fechaBusqueda, String criterio) {
		super();
		this.fechaBusqueda = fechaBusqueda;
		this.criterio = criterio;
	}
	public HistorialMongo(String criterio) {
		super();
		Calendar calendar = Calendar.getInstance();
		Date fecha = calendar.getTime();
		this.fechaBusqueda = fecha;
		this.criterio = criterio;
	}
	public static void registrarHistorial(String criterio,List<ResultadosMongo> resultados)
	{
		List<String> list = new ArrayList<String>();
		MongoClient mongo = MongoConnection.crearConexion();
		DBCollection histCol = MongoConnection.getHistorial(mongo);
		HistorialMongo registro = new HistorialMongo(criterio);
		registro.setResultado(resultados);
		list.add(registro.toJSON());
		MongoConnection.cargarJSONString(list, histCol);
		MongoConnection.cerrarConexion(mongo);
		return;
	}
		
	public static List<HistorialMongo> filtrarHistorial(String fechaDesde, String fechaHasta, DBCollection col){
		List<HistorialMongo> hist = new ArrayList<HistorialMongo>();
		ObjectMapper mapper = new ObjectMapper();
		try{
			BasicDBObject query = new BasicDBObject("FechaBusqueda", //
                    new BasicDBObject("$gte", fechaDesde).append("$lt", fechaHasta));
			DBCursor cursor = col.find(query);
			while(cursor.hasNext()){
				hist.add(mapper.readValue(cursor.next().toString(), HistorialMongo.class));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return hist;
	}
	
	private String toJSON(){
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		mapper.setDateFormat(df);
		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	public HistorialMongo toObj(String json){
		HistorialMongo obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			obj = mapper.readValue(json, HistorialMongo.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	
}
