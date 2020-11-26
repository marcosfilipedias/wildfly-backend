package br.gov.mg.pmmg.challenge.analista.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.ClientDao;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.dto.ClientDto;

@Stateless
public class ClientBean {

	
	@PersistenceContext
	private EntityManager em;
	
	private ClientDao clienteDao;

	public ClientBean() {
	}
	
	@PostConstruct
	private void init() {
		this.clienteDao = new ClientDao(em);
	}
	
	public void save(Cliente client) {		
		if(client.getId()!=null) {
			this.clienteDao.update(client);
		}else {
			this.clienteDao.create(client);
		}
	}
	
	public Cliente getClientById(Long idClient) {
		return  this.clienteDao.getById(Cliente.class, idClient);
	}
	
	public boolean delete(Long idClient) {
		Cliente client = this.getClientById(idClient);
		if(client!=null) {
			this.clienteDao.delete(client);
			return true;
		}
		return false;
	}
	
	public List<ClientDto> getAllClients() {
		return this.clienteDao.getAllClients();
	}
}
