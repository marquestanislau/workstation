package com.project.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.project.model.Titular;
import com.project.repositorio.ITitular;
import com.project.util.FacesUtil;
import com.project.util.Repositorio;

@ManagedBean
@ViewScoped
public class TitularBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Titular titular;
	private List<Titular> titulares;
	private int totalTitulares;
	private List<Titular> filterTitulares;
	private Repositorio repositorio;
	
	public TitularBean() {
		this.titular = new Titular();
	}
	
	//metodos usados para search automatico nas datatables
	public List<Titular> getFilterTitulares() {
		return filterTitulares;
	}
	
	public void setFilterTitulares(List<Titular> filterTitulares) {
		this.filterTitulares = filterTitulares;
	}

	public Titular getTitular() {
		return titular;
	}

	public void setTitular(Titular titular) {
		this.titular = titular;
	}

	public List<Titular> getTitulares() {
		return titulares;
	}

	public void setTitulares(List<Titular> titulares) {
		this.titulares = titulares;
	}
	
	@PostConstruct
	public void initList() {
		repositorio = new Repositorio();
		setTitulares(repositorio.getTitulares().todos());
	}
	

	public String saveTitular() {
		
		titular.setCreatedDate(Calendar.getInstance());
		ITitular titulares = repositorio.getTitulares();
		titulares.guardar(titular);		
		this.titulares.add(titular);
		this.titular = new Titular();
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"));
		
		return "/pages/titular/cadastro?faces-redirect=false";
	}

	public void delete(Titular t) {
		ITitular titulares = repositorio.getTitulares();
		titulares.remover(titular);
		this.titulares.remove(t);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso_apagar"));
		
	}
	
	public List<String> complete(String query) {
		System.out.println("testing");
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			newList.add(query + i);
		}
		return newList;
	}
	
	public int getTotalTitulares() {
		totalTitulares = getTitulares().size();
		return totalTitulares;
	}
	
	public void update() {
		ITitular titulares = repositorio.getTitulares();
		titulares.guardar(titular);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"));
	}
	
	public void onRowSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage("Selecionado: ", ((Titular)event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
