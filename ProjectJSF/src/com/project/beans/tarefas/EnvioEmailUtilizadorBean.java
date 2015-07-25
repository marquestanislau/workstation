package com.project.beans.tarefas;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.project.model.User;
import com.project.report.mail.ConfiguradorEmail;
import com.project.util.FacesUtil;

@ManagedBean
@RequestScoped
public class EnvioEmailUtilizadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ConfiguradorEmail mailer;
	private User user;
	
	public EnvioEmailUtilizadorBean() {
		this.user = new User();
		this.mailer = new ConfiguradorEmail(user);
	}
	
	public void enviarEmail() {
		System.out.println("Enviando...");
		try {
			mailer.enviarEmailParaUtilizador();
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, "Email enviado.");
		} catch (Exception e) {
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR, "Nao foi possivel enviar o email.");
		}
	}

}
