package br.gov.mg.pmmg.challenge.analista.model.dto;

import java.math.BigInteger;

import br.gov.mg.pmmg.challenge.analista.enums.PlanoEnum;

public class ProcedimentoDto {

	private Integer id;

	private String nome;

	private String plano;

	public Integer getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id.intValue();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(Integer plano) {
		this.plano = PlanoEnum.values()[plano].getDescricao();
	}
	
	
}
