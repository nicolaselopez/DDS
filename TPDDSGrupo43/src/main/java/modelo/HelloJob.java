package modelo;

import java.util.Date;
import java.util.logging.Logger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controlador.ServletCalculoDisponibilidad2;

public class HelloJob {

	private static final Logger log= Logger.getLogger( ServletCalculoDisponibilidad2.class.getName() );
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
	    // Say Hello to the World and display the date/time
	    log.info("Hello World! - " + new Date());
	}
	
}
