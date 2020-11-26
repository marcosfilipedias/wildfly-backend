package br.gov.mg.pmmg.challenge.analista.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.mg.pmmg.challenge.analista.model.MarcacaoProcedimento;
import br.gov.mg.pmmg.challenge.analista.model.Procedimento;
import br.gov.mg.pmmg.challenge.analista.model.dto.ProcedimentoDto;

public class ProcedimentoDao extends GenericDao<Procedimento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5925388132782236013L;

	public ProcedimentoDao(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<ProcedimentoDto> getAll(){
		try {
			List<ProcedimentoDto> procedimentos = new ArrayList<ProcedimentoDto>();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM Procedimento p ORDER BY p.nome ");
			Query query = em.createNativeQuery(sql.toString());
			List<Object> objList = query.getResultList();
			
			for(int i=0; i< objList.size(); i++) {
				Object[] res = (Object[]) objList.get(i);
				ProcedimentoDto p = new ProcedimentoDto();
				p.setId((BigInteger) res[0]);
				p.setNome((String) res[1]);
				p.setPlano((Integer) res[2]);
				procedimentos.add(p);
			}
			return procedimentos;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean marcarProcedimento(MarcacaoProcedimento mp) {
		try {
			em.persist(mp);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
