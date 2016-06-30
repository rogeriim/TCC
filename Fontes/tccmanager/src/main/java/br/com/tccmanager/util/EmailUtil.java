package br.com.tccmanager.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
	
	private static String username = "tccmanager.bsiufu@outlook.com";
	private static String password = "bsiufu2016";

	public static int sendEmail(String destinatario, String assunto, String mensagem) {
		int retorno = 0;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		// Habilita o LOG das ações executadas durante o envio do email
		// session.setDebug(true); 

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("tccmanager.bsiufu@outlook.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			message.setSubject(assunto);
			message.setContent("<html><head></head><body>" + mensagem + "</body></html>", "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
			retorno = 0;
			return retorno;
		}

		return retorno;

	}
	
	public static void main (String[] args) {
		int i = EmailUtil.sendEmail("rogeriocustodio@live.com", "[TCC] Teste", "Mensagem de teste.");
		System.out.println("Resultado envio email: " + i);
	}

}
