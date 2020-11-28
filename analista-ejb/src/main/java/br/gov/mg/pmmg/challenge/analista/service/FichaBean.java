package br.gov.mg.pmmg.challenge.analista.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.FichaDao;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.Ficha;

@Stateless
@Remote
public class FichaBean {

	@PersistenceContext
	private EntityManager em;
	
	private FichaDao fichaDao;
	
	@PostConstruct
	private void init() {
		this.fichaDao = new FichaDao(em);
	}
	
	public FichaBean() {
	}

	public FichaBean(EntityManager em) {
		this.em = em;
		this.fichaDao = new FichaDao(em);
	}
	
	public Ficha save(Ficha ficha) {		
		if(ficha.getId()!=null) {
			return this.fichaDao.update(ficha);
		}else {
			return this.fichaDao.create(ficha);
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
		
	public Ficha criarFichaCliente(Cliente cliente) {
		Ficha ficha = new Ficha();
		ficha.setDataCriacao(new Date());
		ficha.setCliente(cliente);
		return save(ficha);
	}
		
	public Ficha getFichaByIdCliente(Long idCliente) {
		return this.fichaDao.getFichaByIdCliente(idCliente);
	}
}
