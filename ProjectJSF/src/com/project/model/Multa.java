/**
 * 
 */
package com.project.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
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
public class Multa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer multa_id;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Calendar createdDate;
	
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
	
}
