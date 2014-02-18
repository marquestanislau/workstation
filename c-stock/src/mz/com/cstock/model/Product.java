package mz.com.cstock.model;

import java.io.Serializable;
import java.util.Calendar;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "Product.findAll", query = "select e from Product e")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String ALL_PRODUCTS = "Product.findAll";
	private SimpleLongProperty id;
	private SimpleStringProperty name;
	private Calendar dateRegistered;
	private SimpleIntegerProperty quantity;
	public static final int MIN_QUANTITY = 1;
	private SimpleDoubleProperty buyPrice;
	private SimpleDoubleProperty sellPrice;

	private void initSupplierProperties() {
		this.quantity = new SimpleIntegerProperty();
		this.buyPrice = new SimpleDoubleProperty();
		this.sellPrice = new SimpleDoubleProperty();
		this.name = new SimpleStringProperty();
		this.id = new SimpleLongProperty();
	}

	public Product() {
		initSupplierProperties();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id.get();
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

	@Temporal(TemporalType.DATE)
	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Calendar dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Integer getQuantity() {
		return quantity.get();
	}

	public void setQuantity(Integer quantity) {
		this.quantity.set(quantity);
	}

	public Double getBuyPrice() {
		return buyPrice.get();
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice.set(buyPrice);
	}

	public Double getSellPrice() {
		return sellPrice.get();
	}

	public void setSellPrice(Double sellPrice) {
		this.sellPrice.set(sellPrice);
	}

	@Override
	public String toString() {
		return getName();
	}
}
