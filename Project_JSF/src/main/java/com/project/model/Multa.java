/**
 * 
 */
package com.project.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Estanislau Marques
 *
 */

@Entity
public class Multa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer multa_id;
	
	@Lob
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar createdDate;
	
	private String nome;
	private String capitulo;
	private Integer numArtigo;
	private double valorDaMulta;
	
	
	public String getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(String capitulo) {
		this.capitulo = capitulo;
	}

	public Integer getNumArtigo() {
		return numArtigo;
	}

	public void setNumArtigo(Integer numArtigo) {
		this.numArtigo = numArtigo;
	}

	@Enumerated(EnumType.STRING)
	private Gravidade gravidade;

	public Integer getMulta_id() {
		return multa_id;
	}

	public void setMulta_id(Integer multa_id) {
		this.multa_id = multa_id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorDaMulta() {
		return valorDaMulta;
	}

	public void setValorDaMulta(double valorDaMulta) {
		this.valorDaMulta = valorDaMulta;
	}

	public Gravidade getGravidade() {
		return gravidade;
	}

	public void setGravidade(Gravidade gravidade) {
		this.gravidade = gravidade;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
