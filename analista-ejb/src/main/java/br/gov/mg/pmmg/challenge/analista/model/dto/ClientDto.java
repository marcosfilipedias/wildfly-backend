package br.gov.mg.pmmg.challenge.analista.model.dto;

import java.math.BigInteger;
import java.util.Date;

public class ClientDto {

	private Integer id;

	private String nome;

	private String cpf;

	private Long dataNascimento;
	
	private String sexo;
	
	private String telefone;
	
	private String email;
	
	private Integer plano;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setId(BigInteger id) {
		this.id = Integer.valueOf(id.intValue());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		if(dataNascimento!=null) {
			this.dataNascimento = dataNascimento.getTime();
		}else {
			this.dataNascimento = null;
		}
	}


	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPlano() {
		return plano;
	}

	public void setPlano(Integer plano) {
		this.plano = plano;
	}
	
}
