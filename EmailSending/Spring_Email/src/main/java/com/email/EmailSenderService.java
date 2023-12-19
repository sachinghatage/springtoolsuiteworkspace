package com.email;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String toEmail,String body,String subject) {
		//SimpleMailMessage is a class,implements MailMessage, Serializable.
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("sachinghatage9372@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
		System.out.println("mail sent.......");
	}

}
