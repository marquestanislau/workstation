package com.project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.project.dao.ConnectionFactory;
import com.project.dao.MultaDao;
import com.project.model.Gravidade;
import com.project.model.Multa;

@ManagedBean
@RequestScoped
public class MultaBean {

	private Multa multa;
	private List<Multa> multas;
	@SuppressWarnings("unused")
	private int totalMultas;
	private MultaDao dao = null;
	
	private TreeNode rootNode;
	
	public TreeNode getRootNode() {
		return rootNode;
	}
	
	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}
	
	private void fillNode() {
		rootNode = new DefaultTreeNode("rootNode", null);
		DefaultTreeNode nodeOne = new DefaultTreeNode("Nivel 1", rootNode);
		for(Multa multa: dao.findAll()) {
			nodeOne.getChildren().add(new DefaultTreeNode(multa));
		}
	}
	
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
		 dao = new MultaDao(ConnectionFactory.getConnection().createEntityManager());
		 dao.begin();
		 fillNode(); // preenchemento da lista em forma de nodos
	}
	
	public void add() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Salvou com exito.", multa.getNome());
		
		dao.create(multa);
		dao.commit();
		
		context.addMessage(null, message);
	}

	@PreDestroy
	private void terminateConnection() {
		dao.close();
	}
}