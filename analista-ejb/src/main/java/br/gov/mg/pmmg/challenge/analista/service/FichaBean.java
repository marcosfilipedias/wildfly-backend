package br.gov.mg.pmmg.challenge.analista.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.FichaDao;
import br.gov.mg.pmmg.challenge.analista.model.Ficha;

@Stateless
public class FichaBean {

	@PersistenceContext
	private EntityManager em;
	
	private FichaDao fichaDao;
	
	public FichaBean() {
	}

	@PostConstruct
	private void init() {
		this.fichaDao = new FichaDao(em);
	}
	
	public void save(Ficha ficha) {		
		if(ficha.getId()!=null) {
			this.fichaDao.update(ficha);
		}else {
			this.fichaDao.create(ficha);
		}
	}
	
	public Ficha getFichaById(Long idFicha) {
		return this.fichaDao.getById(Ficha.class, idFicha);
	}
	
	public boolean delete(Long idFicha) {
		Ficha ficha = this.getFichaById(idFicha);
		if(ficha!=null) {
			this.fichaDao.delete(ficha);
			return true;
		}
		return false;
	}
}
