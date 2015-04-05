package com.project.beans;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
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
	private int totalUsers;

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
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		user.setCreated(Calendar.getInstance());
		dao.begin();
		dao.create(user);
		dao.commit();
		dao.close();
		
		users.add(user);
		
		context.addMessage(null, new FacesMessage("Salvou com exito!") );
		
		return "pages/user/cadastro?faces-redirect=false";
	}
	
	public List<User> getUsers() {
		return users;
	}
		
	@PostConstruct
	public void init() {
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		users = dao.findAll();
		dao.close();
	}
	
	public User read() {
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		User user = dao.read(3L);
		dao.close();
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
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		dao.update(user);
		dao.commit();
		dao.close();
		
		context.addMessage(null, message);
	}
	
	public void deleteUser(User u) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Usuario removido!");
		
		UserDao dao = new UserDao(ConnectionFactory.getConnection().createEntityManager());
		dao.begin();
		dao.delete(u);
		dao.commit();
		users.remove(u);
		dao.close();
		
		context.addMessage(null, message);
	}
}
