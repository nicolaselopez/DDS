package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Proceso1 extends ProcesoStr {

	@Override
	public void procesar() {

		String fileIn = "E:\\Progs\\Java\\Randomizar\\src\\input.txt";

		String DELIM = ";";

		Reader input = null;

		try {
			input = new FileReader(fileIn);
			BufferedReader brProd = new BufferedReader(input);

			while (brProd.ready()) {
				StringTokenizer tokens = new StringTokenizer(brProd.readLine(), DELIM, true); // Toma a la ";" como un token mas

				String nombreFantasia = tokens.nextToken(); // Aca esta el Nombre de Fantasia
				tokens.nextToken();
				String tags = tokens.nextToken(); // Aca estan los tags

				tags = tags.replaceAll(" ", ";");

				guardarRelacion(nombreFantasia, tags);
			}

			brProd.close();
		} catch (IOException ioe) {
			System.out.println("No se pudo abrir el archivo");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public void guardarRelacion(String a, String b) throws IOException
	{
		Writer output = null;
		String fileOut = "E:\\Progs\\Java\\Randomizar\\src\\output.txt";
		
		try
		{
			output = new FileWriter(fileOut);
			
        	output.write(a+" "+b);
        	output.write("\n");
		}
		catch(Exception ioe)
		{
			System.out.println("No se encontro el archivo");
		}
		finally
		{
			if (output != null)
			{
				output.close();
			}

		}
	}
}
