package com.emailsend;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Preparing to send message..." );
        String message="Hii, dear noman";
        String subject="trail";
        String to="vineet2013@gmail.com";
        String from="guptavineet287@gmail.com";
//        for(int i=1;i<=5;i++) {
        SendEmail(message,subject,to,from);
        //}
        }
    // This is responsible for email Send....
	private static void SendEmail(String message, String subject, String to, String from) {
		
		//Variable for gmail...
		
		String host="smtp.gmail.com";
		
		//get the system properties..
		
		Properties properties=System.getProperties();
		System.out.println("Properties"+properties);
		
		//setting important information to properties object
		
		//set host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port",465);
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step1: to get the session object
		
		Session session=Session.getInstance(properties, new Authenticator() {
		
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication("guptavineet287@gmail.com","Vineet@1008");
				
			}
			
		});
		
		session.setDebug(true);
		
		//Step2: compose the message text
		
		MimeMessage m=new MimeMessage(session);
		
		
		try {
			//from email
			
		m.setFrom();
		
		//adding receipent
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding Subject
		
		m.setSubject(subject);
		
		//adding text to message
		
		m.setText(message);
		
		
		//send
		
		//step3: send the message using Transport class
		
		Transport.send(m);
		
		System.out.println("Message has been sent!!!!!");
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
