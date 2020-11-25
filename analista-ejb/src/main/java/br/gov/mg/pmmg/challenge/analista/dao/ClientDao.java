package br.gov.mg.pmmg.challenge.analista.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.mg.pmmg.challenge.analista.model.Client;

public class ClientDao extends GenericDao<Client> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292145760973825744L;

	public ClientDao(EntityManager em) {
		super(em);
	}
	
	public Client getClientByEmail(String email) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Client c WHERE c.email =:email ");
			Query query = em.createNativeQuery(sql.toString(), Client.class);
			query.setParameter("email", email);
			query.setMaxResults(1);			
			return (Client) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getAllClients(){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Client c ORDER BY c.nome ");
			Query query = em.createNativeQuery(sql.toString(), Client.class);
			return (List<Client>) query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
