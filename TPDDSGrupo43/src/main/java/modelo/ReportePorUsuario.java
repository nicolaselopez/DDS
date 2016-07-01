package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportePorUsuario implements GenerarReporte{

	@Override
	public ContextReporte[] generarInformeBusqueda(int idUsuario) 
	{
		ContextReporte[] list = new ContextReporte[20];
		try {
			Conexion c = new Conexion();
			Connection con = c.getConexion();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"Select IdRegistroConsulta, RegConFechaConsulta, count(*) from registroconsulta where RegConIdUsuario = "+idUsuario+" group by RegConFechaConsulta;");
			
			int i = 0;
			while(rs.next()){
				list[i]=new ContextReporte(new ReportePorFecha() ,rs.getInt(1), rs.getDate(2).toString(), rs.getInt(3));
				
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
