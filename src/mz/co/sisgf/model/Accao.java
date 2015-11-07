package mz.co.sisgf.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Accao.findByBank",
				query = "select a from Accao a where a.banco.id =:banco_id"),
	@NamedQuery(name = "Accao.findByDate", 
				query = "select a from Accao a where a.banco.id =:banco_id and a.data_accao between :data_inicio and :data_fim") })
public class Accao implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private StringProperty descricao;
	private DoubleProperty saldo;
	private Calendar data_accao;
	private StringProperty referencia;
	private Tipo tipo;
	private String dataformatada;
	private Banco banco;

	@ManyToOne
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Double getSaldo() {
		return saldo.get();
	}

	public String getReferencia() {
		return referencia.get();
	}

	public String getDescricao() {
		return descricao.getValue();
	}

	public void setDescricao(String descricao) {
		if (this.descricao == null) {
			this.descricao = new SimpleStringProperty();
		}
		this.descricao.setValue(descricao);
	}

	public void setReferencia(String referencia) {
		if (this.referencia == null) {
			this.referencia = new SimpleStringProperty();
		}
		this.referencia.setValue(referencia);
	}

	public void setSaldo(Double saldo) {
		if (this.saldo == null) {
			this.saldo = new SimpleDoubleProperty();
		}
		this.saldo.setValue(saldo);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData_accao() {
		return data_accao;
	}

	public void setData_accao(Calendar data_accao) {
		this.data_accao = data_accao;
	}

	@Enumerated(EnumType.STRING)
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Column(name = "dataformatada")
	public String getDataformatada() {
		return dataformatada;
	}

	public void setDataformatada(String data_formatada) {
		this.dataformatada = data_formatada;
	}

}
