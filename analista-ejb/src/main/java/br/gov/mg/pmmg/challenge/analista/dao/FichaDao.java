package br.gov.mg.pmmg.challenge.analista.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.mg.pmmg.challenge.analista.model.Ficha;

public class FichaDao extends GenericDao<Ficha> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 485700131912449354L;

	public FichaDao(EntityManager em) {
		super(em);
	}

	public Ficha getFichaByIdCliente(Long idCliente) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM FICHA f WHERE f.CLIENT_ID =:idCliente ");
			Query query = em.createNativeQuery(sql.toString(), Ficha.class).setParameter("idCliente", idCliente);
			return (Ficha) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
