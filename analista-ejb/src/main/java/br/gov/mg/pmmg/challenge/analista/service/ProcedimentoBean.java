package br.gov.mg.pmmg.challenge.analista.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.pmmg.challenge.analista.dao.MarcarProcedimentoDao;
import br.gov.mg.pmmg.challenge.analista.dao.ProcedimentoDao;
import br.gov.mg.pmmg.challenge.analista.model.Cliente;
import br.gov.mg.pmmg.challenge.analista.model.Ficha;
import br.gov.mg.pmmg.challenge.analista.model.MarcacaoProcedimento;
import br.gov.mg.pmmg.challenge.analista.model.Procedimento;
import br.gov.mg.pmmg.challenge.analista.model.dto.ProcedimentoDto;
import br.gov.mg.pmmg.challenge.analista.model.dto.ProcedimentoRealizadoDto;

@Stateless
public class ProcedimentoBean{
	
	@PersistenceContext
	private EntityManager em;
	private ProcedimentoDao procedimentoDao;
	private ClienteBean clienteBean;
	private FichaBean fichaBean;
	private MarcarProcedimentoDao marcarProcedimentoDao;
	
	@PostConstruct
	private void init() {
		this.procedimentoDao = new ProcedimentoDao(em);
		this.clienteBean = new ClienteBean(em);
		this.fichaBean = new FichaBean(em);
		this.marcarProcedimentoDao = new MarcarProcedimentoDao(em);
	}
	
	public ProcedimentoBean() {
	}

	public void save(Procedimento procedimento) {		
		if(procedimento.getId()!=null) {
			this.procedimentoDao.update(procedimento);
		}else {
			this.procedimentoDao.create(procedimento);
		}
	}
	
	public Procedimento getProcedimentoById(Long idProcedimento) {
		return  this.procedimentoDao.getById(Procedimento.class, idProcedimento);
	}
	
	public boolean delete(Long idProcedimento) {
		Procedimento procedimento = this.getProcedimentoById(idProcedimento);
		if(procedimento!=null) {
			this.procedimentoDao.delete(procedimento);
			return true;
		}
		return false;
	}

	public List<ProcedimentoDto> getAll() {
		return this.procedimentoDao.getAll();
	}
	
	public boolean marcarProcedimento(Long idCliente, Long idProcedimento) {
		Cliente cliente = clienteBean.getClientById(idCliente);
		Procedimento procedimento = getProcedimentoById(idProcedimento);		
		if(validarLiberacaoAtendimento(cliente, procedimento)) {
			Ficha ficha = new Ficha();
			ficha = fichaBean.getFichaByIdCliente(idCliente);
			if(ficha == null) {				
				ficha = fichaBean.criarFichaCliente(cliente);
			}			
			MarcacaoProcedimento mp = new MarcacaoProcedimento();
			mp.setFicha(ficha);
			mp.setProcedimento(procedimento);
			mp.setDataInclusao(new Date());
			marcarProcedimento(mp);
			return true;
		}else {
			return false;
		}
	}
	
	public MarcacaoProcedimento marcarProcedimento(MarcacaoProcedimento mp) {
		return marcarProcedimentoDao.create(mp);
	}
	
	public boolean validarLiberacaoAtendimento(Cliente cliente, Procedimento procedimento) {			
		return cliente.getPlano().ordinal() >= procedimento.getPlano().ordinal();
	}

	public List<ProcedimentoRealizadoDto> procedimentosRealizados(Long idCliente) {
		Ficha ficha = fichaBean.getFichaByIdCliente(idCliente);
		if(ficha != null) {
			return marcarProcedimentoDao.procedimentosRealizadosPorFicha(ficha.getId());
		}else {
			return new ArrayList<ProcedimentoRealizadoDto>();
		}
	}

}
