package quartz.jobs;

import java.util.logging.Logger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import controlador.ServletCalculoDisponibilidad2;

public class TestJob implements Job {

	private static final Logger log= Logger.getLogger( ServletCalculoDisponibilidad2.class.getName() );
	
    @Override
    public void execute(final JobExecutionContext ctx)
            throws JobExecutionException {

        log.info("Executing Job --- LALALALAL FUNCHIONA ---- ");

    }

}
