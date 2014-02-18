package mz.com.cstock.model;

import java.util.Calendar;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra {

	private Long id;
	private SimpleStringProperty name;
	private SimpleIntegerProperty qtd;
	private SimpleStringProperty userName;
	private Calendar date;

	public Compra() {
		start();
	}

	private void start() {
		name = new SimpleStringProperty();
		qtd = new SimpleIntegerProperty();
		userName = new SimpleStringProperty();
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public Integer getQtd() {
		return qtd.get();
	}

	public void setQtd(Integer qtd) {
		this.qtd.set(qtd);
	}

	public String getUserName() {
		return userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

}
