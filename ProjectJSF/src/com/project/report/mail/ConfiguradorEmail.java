package com.project.report.mail;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Message.RecipientType;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
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
		email.setTextHTML(getVelocityTemplateAsText());
		return email;
	}
	
	public void enviarEmailParaUtilizador() throws MailException, EmailNaoExisteException {
		Email email = produceEmail();
		Mailer mailerSender = new Mailer("smtp.gmail.com", 25, "estanislaumarques@gmail.com", "konvictmuzik", TransportStrategy.SMTP_TLS);
		mailerSender.sendMail(email);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String getVelocityTemplateAsText() {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();
		
		ArrayList velocityParams = new ArrayList();
		Map map = new HashMap();
		map.put("nome", this.user.getNome());
		map.put("apelido", this.user.getNome());
		
		velocityParams.add(map);
		
		StringWriter writer = new StringWriter();
		
		Template template = velocityEngine.getTemplate("com/project/resources/emails/utlilizadores.vm");
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("lista", velocityParams);
		
		template.merge(velocityContext, writer);
		
		return writer.toString();
	}
	
	public User getUser() {
		return user;
	}
	
}