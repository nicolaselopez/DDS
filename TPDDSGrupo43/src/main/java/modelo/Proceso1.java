package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Proceso1 extends ProcesoStr {
	String fileOut = "E:\\Progs\\Java\\Randomizar\\src\\output.txt";
	String fileIn = "E:\\Progs\\Java\\Randomizar\\src\\input.txt";


	@Override
	public void procesar() {
		Reader input = null;
		String DELIM = ";";
		
		Writer output = null;
		
		try {
			output = new FileWriter(fileOut);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			input = new FileReader(fileIn);
			BufferedReader brProd = new BufferedReader(input);

			int id = 1;
			
			while (brProd.ready()) {
				StringTokenizer tokens = new StringTokenizer(brProd.readLine(), DELIM, true); // Toma a la ";" como un token mas

				String nombreFantasia = tokens.nextToken(); // Aca esta el Nombre de Fantasia
				tokens.nextToken();
				String tags = tokens.nextToken(); // Aca estan los tags

				tags = tags.replaceAll(" ", ";");
			
				if(consultarServicios(nombreFantasia,tags,id))
				{
					output.write("Anduvo!!!");
				}
				else
				{
					output.write("No Anduvo :(");
				}
				id++;
	        	
			}

			brProd.close();
		} catch (IOException ioe) {
			System.out.println("No se pudo abrir el archivo");
		} finally {
			if (input != null) {
				try {
					input.close();
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static boolean consultarServicios(String nombre, String tags, int id){

		boolean OK = false;
		ResultSet rs;
		Integer ru;
		
		try{
		Conexion c=new Conexion();
		Connection con=c.getConexion();
		Statement st=con.createStatement();
		
		rs=st.executeQuery("Select * from poi where PoiDescripcion=" + nombre + ";");
		
		ru = st.executeUpdate("update servicio SET ServicioTags='"+tags+"' where ServicioIdPoi="+id+";");

		OK=true;

		}catch(Exception se){
			se.printStackTrace();
		}
		
		return OK;
	}
}
