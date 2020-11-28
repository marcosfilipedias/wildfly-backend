package br.gov.mg.pmmg.challenge.analista.model.dto;

import java.util.Date;

public class ProcedimentoRealizadoDto {

	private String nome;
	
	private Long dataInclusao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		if(dataInclusao!=null) {
			this.dataInclusao = dataInclusao.getTime();
		}else {
			this.dataInclusao = null;
		}
	}
	
	
}
