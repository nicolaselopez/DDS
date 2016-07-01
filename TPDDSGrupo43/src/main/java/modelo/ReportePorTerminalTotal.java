package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportePorTerminalTotal implements GenerarReporte {

	@Override
	public ContextReporte[] generarInformeBusqueda(int idUsuario)
	{
		ContextReporte[] list = new ContextReporte[20];
		try
		{
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT IdRegistroConsulta, RegConIdUsuario, count(*) FROM dds.registroconsulta group by RegConIdUsuario;");
			int i = 0;
			while(rs.next()){
				list[i]=new ContextReporte(new ReportePorFecha() ,rs.getInt(1) ,String.valueOf(rs.getInt(2)) , rs.getInt(3));
				
				i++;
			}
			

			for(int k=i;k<20;k++){
				list[k]=new ContextReporte();
				list[k].setId(-1);
			};
		} catch (Exception se) {
			se.printStackTrace();
		}
		
		return list;
	}

}
