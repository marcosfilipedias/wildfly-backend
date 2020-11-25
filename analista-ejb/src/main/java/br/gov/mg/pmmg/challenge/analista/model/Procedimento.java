package br.gov.mg.pmmg.challenge.analista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.gov.mg.pmmg.challenge.analista.enums.PlanoEnum;

@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento {

	@Id
	@GeneratedValue
	@Column(name = "PR_ID")
	private Long id;

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "PLANO_MINIMO")
	private PlanoEnum plano;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PlanoEnum getPlano() {
		return plano;
	}

	public void setPlano(PlanoEnum plano) {
		this.plano = plano;
	}
	
}
