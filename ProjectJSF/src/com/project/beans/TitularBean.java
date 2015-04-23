package com.project.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.project.dao.ConnectionFactory;
import com.project.dao.TitularDao;
import com.project.model.Titular;

@ManagedBean
@RequestScoped
public class TitularBean {
	
	private Titular titular;
	private List<Titular> titulares;
	private int totalTitulares;
	private TitularDao dao = null;
	
	public TitularBean() {
		titular = new Titular();
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
		dao = new TitularDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		setTitulares(dao.findAll());
	}
	
	@PreDestroy
	private void quit() {
		dao.close();
	}
	
	public String saveTitular() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		titular.setCreatedDate(Calendar.getInstance());
		dao.create(titular);
		dao.commit();
		
		titulares.add(titular);
		FacesMessage message = new FacesMessage("Salvou com exito!", titular.getNome());
		context.addMessage(null, message);
		
		return "/pages/titular/cadastro?faces-redirect=false";
	}

	public void delete(Titular t) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Removido!", t.getNome());
		
		dao.delete(t);
		dao.commit();
		titulares.remove(t);
		
		context.addMessage(null, message);
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
		
		dao.update(titular);
		dao.commit();
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Actualizado com sucesso!");
		
		context.addMessage(null, message);
	}
	
	public void onRowSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage("Selecionado: ", ((Titular)event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
