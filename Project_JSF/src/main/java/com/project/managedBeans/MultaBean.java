package com.project.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.project.model.Gravidade;
import com.project.model.Multa;
import com.project.repositorio.IMulta;
import com.project.util.FacesUtil;
import com.project.util.Repositorio;

@ManagedBean
@ViewScoped
public class MultaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Multa multa;
	private List<Multa> multas;
	@SuppressWarnings("unused")
	private int totalMultas;
	private Repositorio repositorio;

	
	public Gravidade[] getGravidades() {
		return Gravidade.values();
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
	public int getTotalMultas() {
		return (totalMultas = getMultas().size());
	}
	
	public MultaBean() {
		multa = new Multa();
	}
	
	@PostConstruct
	public void init() {
		repositorio = new Repositorio();
		IMulta multas = repositorio.getMultas();
		setMultas(multas.todos());
	}
	
	public void add() {
		IMulta multas = repositorio.getMultas();
		multas.guardar(multa); // Interface IMulta
		this.multas.add(multa);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"));
	}

}