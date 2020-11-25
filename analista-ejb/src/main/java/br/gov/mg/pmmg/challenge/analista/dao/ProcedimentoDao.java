package br.gov.mg.pmmg.challenge.analista.dao;

import javax.persistence.EntityManager;

import br.gov.mg.pmmg.challenge.analista.model.Procedimento;

public class ProcedimentoDao extends GenericDao<Procedimento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5925388132782236013L;

	public ProcedimentoDao(EntityManager em) {
		super(em);
	}

}
