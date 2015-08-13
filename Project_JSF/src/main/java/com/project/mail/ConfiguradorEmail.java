package com.project.mail;

import java.io.Serializable;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.MailException;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import com.project.excepcoes.EmailNaoExisteException;
import com.project.model.Utilizador;
import com.project.util.FacesUtil;
public class ConfiguradorEmail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Email email;
	private Utilizador user;
	
	public ConfiguradorEmail(Utilizador user) {
		this.email = new Email();
		this.user = user;
	}
	
	private Email produceEmail() throws EmailNaoExisteException {
		email.setFromAddress("Estanislau Marques", "estanislaumarques@gmail.com");
		email.setSubject(FacesUtil.getMensagemI18n("credenciais_usuario"));
		email.addRecipient(this.user.getNome() + " " + this.user.getApelido() , this.user.getEmail(), RecipientType.TO);
		email.setTextHTML("<html><body>"
				+"<h1>Ol&aacute; <strong style='color: blue;'>"+this.user.getNome()+" "+this.user.getApelido() +"</strong>, </ br>seja bem-vindo(a) ao PEGASUS</h1>"
				+"<table><tr><td>O seu nome de utilizador:</td><td><i>"+this.user.getNome()+"</i></td></tr><tr>"+
				"</table>"+
				"<p> Se recebeu este email &eacute; porque registou o seu nome no sistema.</>"
				+"<h1 style='color: green;font-weight:bold;'>PEGASUS</h1>"
				+"</body></html>");
		return email;
	}
	
	public void enviarEmailParaUtilizador() throws MailException, EmailNaoExisteException {
		Email email = produceEmail();
		Mailer mailerSender = new Mailer("smtp.gmail.com", 25, "estanislaumarques@gmail.com", "konvictmuzik", TransportStrategy.SMTP_TLS);
		mailerSender.sendMail(email);
	}
	
	public Utilizador getUser() {
		return user;
	}
	
}