package com.weblabs.srv;

import java.util.Properties;



import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ReferalLinkGenarate {
	 private static final String FROM_EMAIL;
	   private static final String FROM_PASSWORD;

	static {
        // Load properties from the resource bundle
        ResourceBundle rb = ResourceBundle.getBundle("application");
        FROM_EMAIL = rb.getString("mailer.email");
        FROM_PASSWORD = rb.getString("mailer.password");
    }
	
	public static void sendLinkEmail(String toEmail,String username,String message) {
		/* String otp = generateOTP(toEmail); */
		String subject =  "WhatsApp Bulk system";
		String body = "Hi"+  username + '\n'
				+ "Please find the Messageelow from  WhatsApp Bulk system. "
				+ "\n"+message;
		sendEmail(toEmail, subject, body);
		return ;
	}

	private static void sendEmail(String toEmail, String subject, String body) {
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Use TLSv1.2 protocol
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM_EMAIL));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
