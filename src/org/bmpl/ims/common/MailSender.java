package org.bmpl.ims.common;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public interface MailSender {
	ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static boolean sendMail(String mailId) throws AddressException, MessagingException {
			String username = bundle.getString("userid");
			String password = bundle.getString("password");
			
			Properties prop = new Properties();
			prop.put("mail.smtp.host", bundle.getString("smtp"));
	        prop.put("mail.smtp.port", bundle.getString("port"));
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true");
	        
	        
	        Session session = Session.getInstance(prop,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse(mailId)
	            );
	            message.setSubject("Registration SuccessFul");
	            message.setText("Dear User,"
	                    + "\n\n You are registered SuccesFully");
	            System.out.println("Before Send ......");
	            Transport.send(message);
	            System.out.println("mail Send SuccessFully");
	            
	            return true;
	}
}
