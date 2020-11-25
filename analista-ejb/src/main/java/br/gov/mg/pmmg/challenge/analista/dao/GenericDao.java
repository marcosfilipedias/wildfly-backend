package br.gov.mg.pmmg.challenge.analista.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4914862234404079491L;

	@PersistenceContext
	protected EntityManager em;

	public GenericDao(EntityManager em) {
		this.em = em;
	}
	
	public boolean create(T t) {
		try {
			em.persist(t);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(T t) {
		try {
			em.merge(t);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void delete(T t) {
		em.remove(t);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(Class klass, Long id) {
		return (T) em.find(klass, id);
	}
}
