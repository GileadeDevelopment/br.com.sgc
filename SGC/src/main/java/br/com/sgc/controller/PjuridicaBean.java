package br.com.sgc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sgc.model.Pjuridica;
import br.com.sgc.repository.RepositoryPessoaJuridica;
import br.com.sgc.tool.ConnectionJPA;
import br.com.sgc.tool.GetDateRegister;

@ViewScoped
@ManagedBean(name="PessoaJuridicaBean")
public class PjuridicaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Pjuridica pessoaJuridica = new Pjuridica();
	private List<Pjuridica> listpessoaJuridica;
	
	public Pjuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	
	public List<Pjuridica> getListpessoaJuridica() {
		return listpessoaJuridica;
	}

	public void cadastrar(){
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		EntityTransaction trx = entityManager.getTransaction();
		trx.begin();
		new RepositoryPessoaJuridica(entityManager).insert(pessoaJuridica);
		trx.commit();
		entityManager.close();
		this.pessoaJuridica = new Pjuridica();
	}
		
	public void consultar() {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		listpessoaJuridica = new RepositoryPessoaJuridica(entityManager).selectAll();
		entityManager.close();
	}
	
	public void actionListenerGetDataRegister(ActionEvent actionEvent) {
		this.pessoaJuridica.setDataCadastro(GetDateRegister.getDateRegister());		
	}
}
