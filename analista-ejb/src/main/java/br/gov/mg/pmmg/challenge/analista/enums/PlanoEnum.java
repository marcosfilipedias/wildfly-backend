package br.gov.mg.pmmg.challenge.analista.enums;

public enum PlanoEnum {
	
	STARTER("Starter"),
	ESSENTIALS("Essentials"),
	TOP("Top");
	
	private String descricao;

	private PlanoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
