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
	
	public T create(T t) {
		try {
			em.persist(t);
		}catch(Exception e){
			e.printStackTrace();
		}
		return t;
	}
	
	public T update(T t) {
		try {
			em.merge(t);
		}catch(Exception e){
			e.printStackTrace();
		} 
		return t;
	}
	
	public void delete(T t) {
		try {
			em.remove(t);
		}catch(Exception e){
			e.printStackTrace();
		} 	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(Class klass, Long id) {
		return (T) em.find(klass, id);
	}
}
