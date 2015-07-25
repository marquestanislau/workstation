package com.project.report.mail;

import java.io.Serializable;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.MailException;
import org.codemonkey.simplejavamail.Mailer;

import com.project.model.User;

public class ConfiguradorEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Email email;
	private User user;
	
	public ConfiguradorEmail(User user) {
		this.email = new Email();
		this.user = user;
	}
	
	private Email produceEmail() {
		email.setFromAddress("Estanislau Marques", "estanislau@live.com");
		email.setSubject("Programming Pegasus System");
		email.addRecipient("Marques", "estanislaumarques@gmail.com", RecipientType.TO);
		email.setText("Programar ira nos dar um bom salario! ;)");
		email.setTextHTML("<img src='cid:wink1'><b>Programe mais ainda!</b><img src='cid:wink2'>");
		return email;
	}
	
	public void enviarEmailParaUtilizador() throws MailException {
		Email email = produceEmail();
		Mailer mailerSender = new Mailer("smtp.outlook.com", 25, "estanislau@live.com", "konvict");
		mailerSender.sendMail(email);		
	}
	
	public User getUser() {
		return user;
	}
	
}
