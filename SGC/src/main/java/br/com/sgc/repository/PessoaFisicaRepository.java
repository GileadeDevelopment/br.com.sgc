package br.com.sgc.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sgc.model.PessoaFisica;

public class PessoaFisicaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;

	public PessoaFisicaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void insertRepository(PessoaFisica pessoaFisica){
		this.entityManager.persist(pessoaFisica);
	}
	
	public PessoaFisica selectIdRepository(Long id) {
		return entityManager.find(PessoaFisica.class, id);
	}
	
	public List<PessoaFisica> selectAllRepository() {
		TypedQuery<PessoaFisica> typedQuery = entityManager.createQuery("from PessoaFisica",PessoaFisica.class );
		return typedQuery.getResultList();
	}
}
