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
import com.project.model.User;
import com.project.report.mail.ConfiguradorEmail;
import com.project.repository.IUsuario;
import com.project.util.FacesUtil;
import com.project.util.Repositorio;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private User user;
	private List<User> users;
	private List<User> filteredUsers;
	private int totalUsers;
	private Repositorio repositorio;
	private ConfiguradorEmail mailer;
	private String senhaSecundaria;

	public UserBean() {
		user = new User();
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role[] getRoles() {
		return Role.values();
	}

	public void addUser() {
		if (saoIguais()) {

			IUsuario usuarios = repositorio.getUsuarios();
			user.setCreated(Calendar.getInstance());

			try {
				usuarios.guardar(user);
				users.add(user);
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

	public List<User> getUsers() {
		return users;
	}

	@PostConstruct
	public void init() {
		repositorio = new Repositorio();
		IUsuario usuario = repositorio.getUsuarios();
		users = usuario.todos();
	}

	public User read() {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.porCodigo(user.getId());
		return user;
	}

	public void onRowSelect(SelectEvent event) {
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				((User) event.getObject()).getNome());
	}

	public int getTotalUsers() {
		totalUsers = users.size();
		return totalUsers;
	}

	public void update() {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.guardar(user);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				FacesUtil.getMensagemI18n("sucesso"));
	}

	public void deleteUser(User u) {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.apagar(u);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO,
				FacesUtil.getMensagemI18n("sucesso_apagar"));
	}

	public void enviarEmail() {
		this.mailer = new ConfiguradorEmail(user);
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
		return this.user.getPassword().contentEquals(senhaSecundaria);
	}
}
