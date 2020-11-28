package br.gov.mg.pmmg.challenge.analista.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.dto.ClienteDto;

public class ClienteDao extends GenericDao<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292145760973825744L;

	public ClienteDao(EntityManager em) {
		super(em);
	}
	
	public Cliente getClienteById(Long idCliente) {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Cliente c WHERE c.id =:idCliente ");
			return (Cliente) em.createQuery(sql.toString(), Cliente.class).setParameter("idCliente", idCliente);
		}catch(NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ClienteDto> getAllClients(){
		try {
			List<ClienteDto> clientes = new ArrayList<ClienteDto>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Cliente c ORDER BY c.nome ");
			Query query = em.createNativeQuery(sql.toString());
			List<Object> objList = query.getResultList();
			
			for(int i=0; i< objList.size(); i++) {
				Object[] res = (Object[]) objList.get(i);
				ClienteDto c = new ClienteDto();
				c.setId((BigInteger) res[0]);
				c.setCpf((String) res[1]);
				c.setDataNascimento((Date) res[2]);
				c.setEmail((String) res[3]);
				c.setNome((String) res[4]);
				c.setPlano((Integer) res[5]);
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
