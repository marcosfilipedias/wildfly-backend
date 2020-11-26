package br.gov.mg.pmmg.challenge.analista.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDIMENTO_MARCACAO")
public class MarcacaoProcedimento {
	
	@Id
	@GeneratedValue
	@Column(name = "PROCR_ID")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "FI_ID")
	private Ficha ficha;
	
	@ManyToOne
	@JoinColumn(name = "PR_ID", referencedColumnName = "PR_ID")
	private Procedimento procedimento;
	
	@Column(name = "DATA_INCLUSAO")
	private Date dataInclusao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	
}
