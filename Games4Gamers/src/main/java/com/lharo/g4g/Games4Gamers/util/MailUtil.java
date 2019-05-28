package com.lharo.g4g.Games4Gamers.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public Boolean sendMail2(String to, String msgBody, String subject) {

		String User = "noreplygames4gamers@gmail.com";
		String Pwd = "mantequilla95";
		try {
			Properties props = null;
			if (props == null) {
				props = new Properties();
				props.put("mail.smtp.auth", true);
				props.put("mail.smtp.starttls.enable", true);
				props.put("mail.smtp.host", "smtp.office365.com");
				props.put("mail.debug", "true");
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.user", User);
				props.put("mail.smtp.pwd", Pwd);     
			}
			Session session = Session.getInstance(props, null);
			session.setDebug(true);
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(User));
			msg.setSubject(subject);
			msg.setText(msgBody);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.office365.com", 587, User, Pwd);
			transport.sendMessage(msg, msg.getAllRecipients());
			System.out.println("Mail sent successfully at " + to);
			transport.close();
		} catch(MessagingException e) {
			System.out.println(e);
			return false;
		}
		return true;	 
	}
	
	public Boolean sendMail(String[] toArr, String msgBody, String subject) {
		
		final String username = "noreplygames4gamers@gmail.com";
		final String password = "quesadilla95";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        String recipients = "";
        for(String to: toArr) {
        	recipients += to + ", ";
        }
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipients)
            );
            message.setSubject(subject);
            message.setText(msgBody);

            Transport.send(message);

            System.out.println("Done");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        	return false;
        }
	}
}
