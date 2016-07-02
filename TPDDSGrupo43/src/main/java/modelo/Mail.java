package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static Boolean enviar(String texto,String destinatario) {

		final String username = "infociudad.g43@gmail.com";
		final String password = "ciudadciudad";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ciudad@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(destinatario));
			message.setSubject("Alerta Consulta WebApp CIUDAD G43");
			message.setText(texto);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		return true;
	}

	public static String destinatarioAdministrador() {
		// TODO Auto-generated method stub
		String destinatarios = "";
		try{
			Conexion c=new Conexion();
			Connection con=c.getConexion();
			Statement st=con.createStatement();
			ResultSet rs;
			rs=st.executeQuery("Select email from usuarios where rol=1;");
			while(rs.next()){
				destinatarios = destinatarios + rs.getString(1) + ",";
			}
		}catch(Exception se){
			se.printStackTrace();
		}
		
		return destinatarios;
	}
}