package br.gov.mg.pmmg.challenge.analista.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FICHA")
public class Ficha{

	@Id
	@GeneratedValue
	@Column(name = "FI_ID")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
	private Client cliente;
	
	@Column(name = "DATA_CRIACAO")
	private Date dataCriacao;
	
	@OneToMany(mappedBy = "ficha")
	private List<ProcedimentoRealizado> procedimentosRealizados;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<ProcedimentoRealizado> getProcedimentosRealizados() {
		return procedimentosRealizados;
	}

	public void setProcedimentosRealizados(List<ProcedimentoRealizado> procedimentosRealizados) {
		this.procedimentosRealizados = procedimentosRealizados;
	}
	
}

