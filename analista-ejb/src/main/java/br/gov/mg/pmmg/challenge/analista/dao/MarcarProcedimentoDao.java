package br.gov.mg.pmmg.challenge.analista.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import br.gov.mg.pmmg.challenge.analista.model.MarcacaoProcedimento;
import br.gov.mg.pmmg.challenge.analista.model.Procedimento;
import br.gov.mg.pmmg.challenge.analista.model.dto.ProcedimentoRealizadoDto;

public class MarcarProcedimentoDao extends GenericDao<MarcacaoProcedimento>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4631406291054126966L;

	public MarcarProcedimentoDao(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<ProcedimentoRealizadoDto> procedimentosRealizadosPorFicha(Long idFicha) {
		List<ProcedimentoRealizadoDto> lista = new ArrayList<ProcedimentoRealizadoDto>();		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT p.PR_ID, p.DATA_INCLUSAO FROM PROCEDIMENTO_MARCACAO p WHERE P.FI_ID =:idFicha ORDER BY p.DATA_INCLUSAO DESC ");
			List<Object> objList = em.createNativeQuery(sql.toString()).setParameter("idFicha", idFicha) .getResultList();
			for(int i=0; i < objList.size(); i++) {
				ProcedimentoRealizadoDto modelo = new ProcedimentoRealizadoDto();
				Object[] res = (Object[]) objList.get(i);
				BigInteger idProcedimento = (BigInteger) res[0];
				modelo.setNome((String) em.find(Procedimento.class, Long.valueOf(idProcedimento.longValue())).getNome());
				modelo.setDataInclusao((Date) res[1]);
				lista.add(modelo);
			}
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		return lista;
	}
}
