package com.project.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.project.model.Multa;
import com.project.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProcuraMultasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Multa multa;
	private List<Multa> multas;

	public void action() {
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, "Teste");
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	
}
