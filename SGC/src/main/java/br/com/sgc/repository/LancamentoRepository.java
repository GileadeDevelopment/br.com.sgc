package br.com.sgc.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sgc.model.Lancamento;

public class LancamentoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager;

	public LancamentoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void insertRepository(Lancamento lancamento) {
		this.entityManager.persist(lancamento);
	}
	
	public Lancamento selectIdRepository(Long id) {
		return this.entityManager.find(Lancamento.class, id);
	}
	
	public List<Lancamento> selectAllRepository() {
		TypedQuery<Lancamento> typedQuery = entityManager.createQuery("from Lancamento",Lancamento.class );
		return typedQuery.getResultList();
	}
	
	public void deleteRepository(Lancamento lancamento) {
		entityManager.remove(entityManager.find(Lancamento.class, lancamento.getId()));
	}
}
