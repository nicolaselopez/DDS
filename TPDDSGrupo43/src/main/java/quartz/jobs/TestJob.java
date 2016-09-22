package quartz.jobs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controlador.ServletCalculoDisponibilidad2;
import modelo.Conexion;
import modelo.LoteAcciones;
import modelo.Proceso1;
import modelo.Proceso2;
import modelo.Proceso3;
import modelo.ProcesoContext;
import modelo.Usuario;
import modelo.ProcesoEjecucion;

public class TestJob implements Job {

	private static final Logger log= Logger.getLogger( TestJob.class.getName() );
	
    @Override
    public void execute(final JobExecutionContext ctx)
            throws JobExecutionException {

        log.info("----Inicio Job Ejecucion de procesos agendados----");
        
        ProcesoContext context = null;
        ProcesoEjecucion proceso = this.buscarProceso();

        if(proceso != null){
        	log.info("----Se ejecutara proceso del Tipo: "+ proceso.getProceso()+" con los parametros: " +proceso.getParametros()+ " generado por usuario: "+proceso.getUsuario()+" ----");
        	boolean OK = this.marcarProceso(proceso.getIdagenda());
        	if(Integer.toString(proceso.getProceso()).equals("1"))
			{
				context = new ProcesoContext(new Proceso1());
				context.executeStrategy();
			}
			else if(Integer.toString(proceso.getProceso()).equals("2"))
			{
				context = new ProcesoContext(new Proceso2());
				context.executeStrategy();
			}
			else if(Integer.toString(proceso.getProceso()).equals("3")){
				String[] parametros = proceso.getParametros().split(";");
				if(parametros[0].equals("rollback")){
					Proceso3 proc = new Proceso3();
					proc.rollback(parametros[1]);
				}else{
					LoteAcciones acciones = LoteAcciones.convertToLote(proceso.getParametros());
					context = new ProcesoContext(new Proceso3());
					context.executeStrategy(parametros[12],acciones);	
				}
				
			}
	        
        }else{
        	log.info("----No hay procesos pendientes----");
        }
        log.info("----Fin Job Ejecucion de procesos agendados----");
		
    }
    
    private ProcesoEjecucion buscarProceso(){
    	ProcesoEjecucion proceso=null;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("Select agendaproceso,agendaparametros,agendausuario,idagenda from agenda where agendamarca=0 LIMIT 1;");
			while(rs.next()){
				proceso=new ProcesoEjecucion(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
		return proceso;
    }
    
    private boolean marcarProceso(int id){
    	Boolean OK =false;
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			Integer rs = st.executeUpdate("UPDATE agenda SET agendamarca = 1 where idagenda = "+id+";");
		if(rs==1){
			OK=true;
		}
		}catch(SQLException se){
			se.printStackTrace();
			OK=false;
		}
		
		return OK;
    }

}
