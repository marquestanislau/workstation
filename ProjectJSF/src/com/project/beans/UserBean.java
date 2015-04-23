package com.project.beans;

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
import com.project.dao.UserDao;
import com.project.model.Role;
import com.project.model.User;

@ManagedBean
@RequestScoped
public class UserBean {

	private User user;
	private List<User> users;
	private List<User> filteredUsers;
	private int totalUsers;
	private UserDao dao = null;
	
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
		System.out.println("Managed bean working");
		FacesContext context = FacesContext.getCurrentInstance();
		
		user.setCreated(Calendar.getInstance());

		dao.create(user);
		dao.commit();
		users.add(user);
		
		context.addMessage(null, new FacesMessage("Salvou com exito!") );
		
		return "pages/user/cadastro?faces-redirect=false";
	}
	
	public List<User> getUsers() {
		return users;
	}
		
	@PostConstruct
	public void init() {
		dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		users = dao.findAll();
	}
	
	@PreDestroy
	private void destroy() {
		dao.close();
	}
	
	public User read() {
		User user = dao.read(3L);
		return user;
	}
	
	public void onRowSelect(SelectEvent event) {
		FacesMessage message = new FacesMessage("Usuario selecionado: ", ((User)event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public int getTotalUsers() {
		totalUsers = users.size();
		return totalUsers;
	}
	
	public void update() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Usuario Actualizado", user.getNome());
		
		if(dao.update(user) != null) {
			dao.commit();
			context.addMessage(null, message);
		} else {
			FacesMessage errorMessage = new FacesMessage("Usuario nao existe.", "Selecione um usuario na tabela");
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, errorMessage);
		}
		
	}
	
	public void deleteUser(User u) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Usuario removido!");
		
		dao.delete(u);
		dao.commit();
		users.remove(u);
		
		context.addMessage(null, message);
	}
}
