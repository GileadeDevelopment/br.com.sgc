package br.com.sgc.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;

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

	public PessoaFisica pessoasFisicaDuplicadaRepository(PessoaFisica pessoaFisica) {
		
              CriteriaBuilder builder = entityManager.getCriteriaBuilder();
              CriteriaQuery<PessoaFisica> criteriaQuery = builder.createQuery(PessoaFisica.class);
              Root<PessoaFisica> pessoaFisicaRoot = criteriaQuery.from(PessoaFisica.class);
       
               
/*
 * incompleto 
 * */
          
				
		return null;	
	}
}
