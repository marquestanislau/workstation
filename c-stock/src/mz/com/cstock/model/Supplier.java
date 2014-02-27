package mz.com.cstock.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Supplier.findAll", query = "select e from Supplier e")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String ALL_SUPPLIERS = "Supplier.findAll"; 
	private List<Product> products;
	private Calendar dateRegistered;
	private SimpleStringProperty name;
	private SimpleStringProperty address;
	private SimpleStringProperty email;
	private SimpleStringProperty contact;
	private SimpleLongProperty id;
	
	public Supplier() {
		initSupplierProperties();
	}

	private void initSupplierProperties() {
		this.products = new ArrayList<Product>();
		this.name = new SimpleStringProperty();
		this.address = new SimpleStringProperty();
		this.email = new SimpleStringProperty();
		this.id = new SimpleLongProperty();
		this.contact = new SimpleStringProperty();
	}
	
	public void setContact(String contact) {
		this.contact.set(contact);
	}
	
	public String getContact() {
		return contact.get();
	}

	@OneToMany
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Calendar dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getAddress() {
		return address.get();
	}

	public void setAddress(String address) {
		this.address.set(address);
	}

	@Column(name = "email", unique = true)
	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id.get();
	}

	public void setId(Long id) {
		this.id.set(id);
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
