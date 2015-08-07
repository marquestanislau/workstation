package com.project.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import com.project.model.Role;
import com.project.model.Utilizador;
import com.project.report.mail.ConfiguradorEmail;
import com.project.repository.IUtilizador;
import com.project.util.FacesUtil;
import com.project.util.Repositorio;

@ManagedBean
@ViewScoped
public class UtilizadorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Utilizador utilizador;
	private Utilizador utilizadorSelecionado;
	private List<Utilizador> users;
	private List<Utilizador> filteredUsers;
	private int totalUsers;
	private Repositorio repositorio;
	private ConfiguradorEmail mailer;
	private String senhaSecundaria;

	public UtilizadorBean() {
		utilizador = new Utilizador();
		utilizadorSelecionado = new Utilizador();
	}

	public void setFilteredUsers(List<Utilizador> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public List<Utilizador> getFilteredUsers() {
		return filteredUsers;
	}

	public Utilizador getUser() {
		return utilizador;
	}
	
	public Utilizador getUtilizadorSelecionado() {
		return utilizadorSelecionado;
	}
	
	public void setUtilizadorSelecionado(Utilizador utilizadorSelecionado) {
		this.utilizadorSelecionado = utilizadorSelecionado;
	}

	public void setUser(Utilizador user) {
		this.utilizador = user;
	}

	public Role[] getRoles() {
		return Role.values();
	}

	public void addUser() {
		if (saoIguais()) {

			IUtilizador usuarios = repositorio.getUsuarios();
			utilizador.setCreated(Calendar.getInstance());

			try {
				usuarios.guardar(utilizador);
				users.add(utilizador);
				FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
						FacesUtil.getMensagemI18n("sucesso"));
			} catch (Exception e) {
				FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
						FacesUtil.getMensagemI18n("erro"));
			}
			
		} else {
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
					FacesUtil.getMensagemI18n("erro_senha"));
		}

	}

	public List<Utilizador> getUsers() {
		return users;
	}

	@PostConstruct
	public void init() {
		repositorio = new Repositorio();
		IUtilizador usuario = repositorio.getUsuarios();
		users = usuario.todos();
	}

	public Utilizador read() {
		IUtilizador usuarios = repositorio.getUsuarios();
		usuarios.porCodigo(utilizador.getId());
		return utilizador;
	}

	public void onRowSelect(SelectEvent event) {
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				((Utilizador) event.getObject()).getNome());
	}

	public int getTotalUsers() {
		totalUsers = users.size();
		return totalUsers;
	}

	public void update() {
		IUtilizador usuarios = repositorio.getUsuarios();
		usuarios.guardar(utilizador);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				FacesUtil.getMensagemI18n("sucesso"));
	}

	public void deleteUser() {
		IUtilizador usuarios = repositorio.getUsuarios();
		usuarios.apagar(this.utilizadorSelecionado);
		users.remove(this.utilizadorSelecionado);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				FacesUtil.getMensagemI18n("sucesso_apagar"));
	}

	public void enviarEmail() {
		this.mailer = new ConfiguradorEmail(utilizador);
		try {
			mailer.enviarEmailParaUtilizador();
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
					FacesUtil.getMensagemI18n("view_dialog_sucesso"));
		} catch (Exception e) {
			FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_ERROR,
					FacesUtil.getMensagemI18n("view_dialog_erro"));
		}
	}

	public String getSenhaSecundaria() {
		if (senhaSecundaria == null)
			senhaSecundaria = new String();
		return senhaSecundaria;
	}

	public void setSenhaSecundaria(String senhaSecundaria) {
		this.senhaSecundaria = senhaSecundaria;
	}

	private boolean saoIguais() {
		return this.utilizador.getPassword().contentEquals(senhaSecundaria);
	}
}
