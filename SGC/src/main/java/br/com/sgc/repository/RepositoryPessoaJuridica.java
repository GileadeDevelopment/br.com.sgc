package br.com.sgc.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sgc.model.Pjuridica;

public class RepositoryPessoaJuridica implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public RepositoryPessoaJuridica(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insert(Pjuridica pesssoaJuridica) {
		this.entityManager.persist(pesssoaJuridica);
	}

	public Pjuridica selectId(Long id) {
		return entityManager.find(Pjuridica.class, id);
	}

	public List<Pjuridica> selectAll() {
		TypedQuery<Pjuridica> query = entityManager.createQuery("from Pjuridica", 
				Pjuridica.class);
		return query.getResultList();
	}
}
