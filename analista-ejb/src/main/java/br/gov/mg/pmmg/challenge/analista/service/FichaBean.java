package br.gov.mg.pmmg.challenge.analista.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.FichaDao;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.Ficha;
import br.gov.mg.pmmg.challenge.analista.model.MarcacaoProcedimento;
import br.gov.mg.pmmg.challenge.analista.model.Procedimento;

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
	

	public boolean marcarProcedimento(Long idCliente, Long idProcedimento) {		
		ProcedimentoBean procedimentoBean = new ProcedimentoBean();		
		Cliente cliente = new ClientBean().getClientById(idCliente);
		Procedimento procedimento = procedimentoBean.getProcedimentoById(idProcedimento);		
		if(validarLiberacaoAtendimento(cliente, procedimento)) {
			Ficha ficha = getFichaByIdCliente(idCliente);
			if(ficha == null) {
				criarFichaCliente(cliente);
				ficha = getFichaByIdCliente(idCliente);
			}
			
			MarcacaoProcedimento mp = new MarcacaoProcedimento();
			mp.setFicha(ficha);
			mp.setProcedimento(procedimento);
			mp.setDataInclusao(new Date());
			return procedimentoBean.marcarProcedimento(mp);
		}else {
			return false;
		}
	}
	
	public void criarFichaCliente(Cliente cliente) {
		Ficha ficha = new Ficha();
		ficha.setDataCriacao(new Date());
		ficha.setCliente(cliente);
		save(ficha);
	}
	
	public boolean validarLiberacaoAtendimento(Cliente cliente, Procedimento procedimento) {			
		return cliente.getPlano().ordinal() >= procedimento.getPlano().ordinal();
	}
	
	public Ficha getFichaByIdCliente(Long idCliente) {
		return this.fichaDao.getFichaByIdCliente(idCliente);
	}
}
