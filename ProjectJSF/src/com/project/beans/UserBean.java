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
	
	public UserBean() {
		user = new User();
	}
	
	public Role[] getRoles() {
		return Role.values();
	}
	
	public String addUser() {
		IUsuario usuarios = repositorio.getUsuarios();
		user.setCreated(Calendar.getInstance());
		usuarios.guardar(user);
		users.add(user);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"));
		
		return "/pages/user/cadastro";
	}
	
	public List<User> getUsers() {
		return users;
	}
		
	@PostConstruct
	public void init() {
		repositorio =  new Repositorio();
		IUsuario usuario = repositorio.getUsuarios();
		users = usuario.todos();
	}
	
	public User read() {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.porCodigo(user.getId());
		return user;
	}
	
	public void onRowSelect(SelectEvent event) {
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, ((User)event.getObject()).getNome());
	}
	
	public int getTotalUsers() {
		totalUsers = users.size();
		return totalUsers;
	}
	
	public void update() {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.guardar(user);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso"));
	}
	
	public void deleteUser(User u) {
		IUsuario usuarios = repositorio.getUsuarios();
		usuarios.apagar(u);
		FacesUtil.adicionaMensagem(FacesMessage.SEVERITY_INFO, FacesUtil.getMensagemI18n("sucesso_apagar"));
	}
}
