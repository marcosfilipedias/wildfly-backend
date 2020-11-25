package br.gov.mg.pmmg.challenge.analista.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.ProcedimentoDao;
import br.gov.mg.pmmg.challenge.analista.model.Procedimento;

@Stateless
public class ProcedimentoBean {
	
	@PersistenceContext
	private EntityManager em;
	
	private ProcedimentoDao procedimentoDao;
	
	public ProcedimentoBean() {
	}

	@PostConstruct
	private void init() {
		this.procedimentoDao = new ProcedimentoDao(em);
	}
	
	public void save(Procedimento procedimento) {		
		if(procedimento.getId()!=null) {
			this.procedimentoDao.update(procedimento);
		}else {
			this.procedimentoDao.create(procedimento);
		}
	}
	
	public Procedimento getProcedimentoById(Long idProcedimento) {
		return  this.procedimentoDao.getById(Procedimento.class, idProcedimento);
	}
	
	public boolean delete(Long idProcedimento) {
		Procedimento procedimento = this.getProcedimentoById(idProcedimento);
		if(procedimento!=null) {
			this.procedimentoDao.delete(procedimento);
			return true;
		}
		return false;
	}
}
