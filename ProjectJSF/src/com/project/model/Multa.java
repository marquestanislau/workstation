/**
 * 
 */
package com.project.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Estanislau Marques
 *
 */

@Entity
public class Multa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer multa_id;
	
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Calendar createdDate;
	
	private String nome;
	
	private Double valorDaMulta;
	
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

	public Double getValorDaMulta() {
		return valorDaMulta;
	}

	public void setValorDaMulta(Double valorDaMulta) {
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
