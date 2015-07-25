package com.project.report.mail;

import java.io.Serializable;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.MailException;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import com.project.model.User;
import com.project.util.FacesUtil;
import com.project.util.excepcoes.EmailNaoExisteException;

public class ConfiguradorEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Email email;
	private User user;
	
	public ConfiguradorEmail(User user) {
		this.email = new Email();
		this.user = user;
	}
	
	private Email produceEmail() throws EmailNaoExisteException {
		email.setFromAddress("Estanislau Marques", "estanislaumarques@gmail.com");
		email.setSubject(FacesUtil.getMensagemI18n("credenciais_usuario"));
		email.addRecipient(this.user.getNome() + " " + this.user.getApelido() , this.user.getEmail(), RecipientType.TO);
		email.setText("Programar ira nos dar um bom salario! ;)");
		email.setTextHTML("<img src='cid:wink1'><b>Programe mais ainda!</b><img src='cid:wink2'>");
		return email;
	}
	
	public void enviarEmailParaUtilizador() throws MailException, EmailNaoExisteException {
		Email email = produceEmail();
		Mailer mailerSender = new Mailer("smtp.gmail.com", 25, "estanislaumarques@gmail.com", "konvictmuzik", TransportStrategy.SMTP_TLS);
		mailerSender.sendMail(email);
	}
	
	public User getUser() {
		return user;
	}
	
}