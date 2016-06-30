package modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Mail;

public class TestEnvioMail {
	
	
	@Before
	public void darContexto(){

	}
	

	// Muchas de las precondiciones podrian ir dentro de la parte @before

	@Test
	public void testEnviarMail(){
		//ejecucion
		
		Boolean OK = Mail.enviar("Mail de Prueba:\n\nNosotro' somo lo mejore vieja. Entregamo todo.", "nicolas.e.lopez@gmail.com,jmmarussi32@gmail.com,leandro.sanchezzarfino@gmail.com,erikaroque2@gmail.com,guibuadrian@gmail.com");
		
		//validacion
		Assert.assertTrue(OK); // El tercer campo es el margen de error permitido
			
	}

}
