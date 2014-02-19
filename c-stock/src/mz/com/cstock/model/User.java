package mz.com.cstock.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class User implements Serializable {

	public static final String ALL_USERS = "User.findAll";
	private static final long serialVersionUID = 1L;
	private SimpleLongProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty email;
	private SimpleStringProperty password;
	private Calendar dateRegistered;
	private SimpleStringProperty data;
	private Permission permission;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id.get();
	}

	public void setData(String data) {
		this.data.set(data);
	}
	
	@Transient
	public String getData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dia = sdf.format(getDateRegistered().getTime());
		data.setValue(dia);
		return data.get();
	}
	
	public void setId(Long id) {
		this.id.set(id);
	}
	
	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	@Column(name = "email", unique = true)
	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Calendar dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	@Enumerated(EnumType.STRING)
	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Transient
	public boolean isAdmin() {
		return Permission.ADMIN.equals(permission);
	}

	@Transient
	public boolean isUser() {
		return Permission.USER.equals(permission);
	}

	public User() {
		initUserProperties();
	}

	private void initUserProperties() {
		this.email = new SimpleStringProperty();
		this.id = new SimpleLongProperty();
		this.name = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
		this.data = new SimpleStringProperty();
	}
}
