package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.BeanPoi;

public class Poi {
	
	public static Boolean registrarPoi(BeanPoi poi){
		Boolean OK = false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			poi.setPoiActivo(1);
			Integer rs=st.executeUpdate("INSERT INTO poi "+
				"(PoiIdTipoPoi,PoiDescripcion,PoiIdRubro,PoiCalle,PoiNumero,PoiPiso,PoiDepto,PoiUnidad,"+
				"PoiCodPos,PoiIdLocalidad,PoiIdBarrio,PoiIdProvincia,PoiIdPais,PoiLatitudGeo,PoiLongitudGeo,PoiActivo) "+
				"VALUES "+
				"("+poi.getPoiIdTipoPoi()+",'"+poi.getPoiDescripcion()+"',"+poi.getPoiIdRubro()+",'"+poi.getPoiCalle()+"','"+poi.getPoiNumero()+"',"
				+poi.getPoiPiso()+","+poi.getPoiDepto()+","+poi.getPoiUnidad()+","+poi.getPoiCodPos()+","+poi.getPoiIdLocalidad()+","
				+poi.getPoiIdBarrio()+","+poi.getPoiIdProvincia()+","+poi.getPoiIdPais()+","+poi.getPoiLatitudGeo()+","
				+poi.getPoiLongitudGeo()+","+poi.getPoiFechaAlta()+","+poi.getPoiFechaModificacion()+","+poi.getPoiActivo()+");");
			if(rs == 1){
				OK = true;
			}
			if(poi.getPoiServicio() != null){
				OK = false;
				for(int i=0; i<poi.getPoiServicio().length;i++){
					rs = st.executeUpdate("INSERT INTO servicio(ServicioIdPoi,ServicioIdTipoPoi,ServicioDescripcion,"
							+"ServicioDiaDisponible,ServicioHoraDesde1,ServicioHoraHasta1,ServicioHoraDesde2,"
							+"ServicioHoraHasta2,ServicioTags,ServicioFechaAlta,ServicioFechaModificacion,"
							+"ServicioActivo)VALUES("
							+poi.getPoiServicio()[i].getServicioIdPoi()+","+poi.getPoiServicio()[i].getServicioIdTipoPoi()+","+poi.getPoiServicio()[i].getServicioDescripcion()+","
							+poi.getPoiServicio()[i].getServicioDiaDisponible()+","+poi.getPoiServicio()[i].getServicioHoraDesde1()+","+poi.getPoiServicio()[i].getServicioHoraHasta1()+","
							+poi.getPoiServicio()[i].getServicioHoraDesde2()+","+poi.getPoiServicio()[i].getServicioHoraHasta2()+","+poi.getPoiServicio()[i].getServicioTags()+","+","+poi.getPoiServicio()[i].getServicioActivo()+");");
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
