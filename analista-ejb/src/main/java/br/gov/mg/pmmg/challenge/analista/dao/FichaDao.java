package br.gov.mg.pmmg.challenge.analista.dao;

import javax.persistence.EntityManager;

import br.gov.mg.pmmg.challenge.analista.model.Ficha;

public class FichaDao extends GenericDao<Ficha> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 485700131912449354L;

	public FichaDao(EntityManager em) {
		super(em);
	}

}
