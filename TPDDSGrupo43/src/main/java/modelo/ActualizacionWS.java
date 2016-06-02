package modelo;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import java.util.TimerTask;
import java.util.Timer;
 
public class ActualizacionWS extends TimerTask implements ServletContextListener {
    private Timer timer;
 
    public void contextInitialized(ServletContextEvent evt) {
        // Iniciamos el timer
        timer = new Timer();
        timer.schedule(this, 0, 10*60*1000);  // Corre cada 10 minutos.
    }
 
    public void contextDestroyed(ServletContextEvent evt) {
        timer.cancel();
    }
    
    public void run() {
    	Boolean OK = false;
		//ejecucion
		OK = Banco.consultaBancosWS();
    }    
}