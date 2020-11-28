package br.gov.mg.pmmg.challenge.analista.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.ClienteDao;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.dto.ClienteDto;

@Stateless
@Remote
public class ClienteBean {

	
	@PersistenceContext
	private EntityManager em;
	
	private ClienteDao clienteDao;
	
	@PostConstruct
	private void init() {
		this.clienteDao = new ClienteDao(em);
	}
	
	public ClienteBean() {
	}
				
	public ClienteBean(EntityManager em) {
		this.em = em;
		this.clienteDao = new ClienteDao(em);
	}



	public void save(Cliente client) {		
		if(client.getId()!=null) {
			this.clienteDao.update(client);
		}else {
			this.clienteDao.create(client);
		}
	}
	
	public Cliente getClientById(Long idClient) {
		return this.clienteDao.getById(Cliente.class, idClient);
	}
	
	public boolean delete(Long idClient) {
		Cliente client = this.getClientById(idClient);
		if(client!=null) {
			this.clienteDao.delete(client);
			return true;
		}
		return false;
	}
	
	public List<ClienteDto> getAllClients() {
		return this.clienteDao.getAllClients();
	}
}
