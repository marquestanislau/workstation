package mz.co.sisgf.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banco implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String descricao;
	private Long numero_conta;
	private Double saldoInicial;

	@OneToMany
	private List<Accao> acoes;

	public Banco() {
		// this.acoes = new ArrayList<Accao>();
	}

	// @OneToMany(cascade = CascadeType.ALL)
	// public List<Accao> getAcoes() {
	// return acoes;
	// }
	//
	// public void setAcoes(List<Accao> acoes) {
	// this.acoes = acoes;
	// }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(Long numero_conta) {
		this.numero_conta = numero_conta;
	}

	@Override
	public String toString() {
		return this.getNome();
	}
}
