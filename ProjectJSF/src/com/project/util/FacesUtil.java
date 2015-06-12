package com.project.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

	public static void adicionaMensagem(Severity tipo, String txt) {
		FacesMessage message = new FacesMessage(tipo, txt, txt);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static Object getRequestAttribute(String name) {
		FacesContext cxt = FacesContext.getCurrentInstance();
		ExternalContext ecxt = cxt.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ecxt.getRequest();
		return request.getAttribute(name);
	}

	public static String getMensagemI18n(String chave) {
		FacesContext context = FacesContext.getCurrentInstance();
		String mensagem = context.getApplication()
				.getResourceBundle(context, "msg").getString(chave);
		return mensagem;
	}

}
