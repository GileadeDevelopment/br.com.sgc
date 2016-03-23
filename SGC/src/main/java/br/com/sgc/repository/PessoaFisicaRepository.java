package br.com.sgc.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sgc.model.PessoaFisica;

public class PessoaFisicaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	public PessoaFisicaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void insertRepository(PessoaFisica pessoaFisica) {
		this.entityManager.persist(pessoaFisica);
	}
	
	public void editarRepository(PessoaFisica pessoaFisica) {
		this.entityManager.merge(pessoaFisica);
	}

	public PessoaFisica selectIdRepository(Long id) {
		return entityManager.find(PessoaFisica.class, id);
	}

	public List<PessoaFisica> selectAllRepository() {
		TypedQuery<PessoaFisica> typedQuery = entityManager.createQuery("from PessoaFisica", PessoaFisica.class);
		return typedQuery.getResultList();
	}

	public PessoaFisica pessoasFisicaDuplicadaRepository(PessoaFisica pessoaFisica) {

		Session session = entityManager.unwrap(Session.class);

		return (PessoaFisica) session.createCriteria(PessoaFisica.class)
				.add(Restrictions.ilike("nome", pessoaFisica.getNome()))
				.add(Restrictions.eq("cpf", pessoaFisica.getCpf()))
				.add(Restrictions.eq("rg", pessoaFisica.getRg()))
				.add(Restrictions.eq("dataNascimento",pessoaFisica.getDataNascimento()))
				.add(Restrictions.eq("sexo", pessoaFisica.getSexo())).uniqueResult();
	}
}
