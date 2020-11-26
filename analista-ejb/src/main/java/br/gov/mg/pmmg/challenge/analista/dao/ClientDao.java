package br.gov.mg.pmmg.challenge.analista.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.mg.pmmg.challenge.analista.model.Client;
import br.gov.mg.pmmg.challenge.analista.model.dto.ClientDto;

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
	public List<ClientDto> getAllClients(){
		try {
			List<ClientDto> clientes = new ArrayList<ClientDto>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Client c ORDER BY c.nome ");
			Query query = em.createNativeQuery(sql.toString());
			List<Object> objList = query.getResultList();
			
			for(int i=0; i< objList.size(); i++) {
				Object[] res = (Object[]) objList.get(i);
				ClientDto c = new ClientDto();
				c.setId((BigInteger) res[0]);
				c.setCpf((String) res[1]);
				c.setDataNascimento((Date) res[2]);
				c.setEmail((String) res[3]);
				c.setNome((String) res[4]);
				c.setPlano((int) res[5]);
				c.setSexo((String) res[6]);
				c.setTelefone((String) res[7]);
				clientes.add(c);
			}
			return clientes;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
