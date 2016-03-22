package br.com.sgc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import br.com.sgc.model.PessoaFisica;
import br.com.sgc.model.Sexo;
import br.com.sgc.repository.PessoaFisicaRepository;
import br.com.sgc.service.PessoaFisicaService;
import br.com.sgc.tool.FacesTool;
import br.com.sgc.tool.GetDateRegister;

@ViewScoped
@ManagedBean(name ="PessoaFisicaBean")
public class PessoaFisicaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PessoaFisica pessoaFisica = new PessoaFisica();
	private List<PessoaFisica> listPessoaFisica;
	
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public List<PessoaFisica> getListPessoaFisica() {
		return listPessoaFisica;
	}
	
	public Sexo[] getListSexo() {
		return Sexo.values();
	}
	
	public void actionListenerGetDataRegister(ActionEvent actionEvent) {
		this.pessoaFisica.setDataCadastro(GetDateRegister.getDateRegister());		
	}
	
	public void insertBean() {
		EntityManager entityManager = (EntityManager) FacesTool.getRequestAttribute("session");
		try {
			new PessoaFisicaService(new PessoaFisicaRepository(entityManager)).inserService(pessoaFisica);
			this.pessoaFisica = new PessoaFisica();
			FacesTool.addMessage_Info("Cadastro Salvo Com Sucesso!");
		} catch (Exception e) {
			FacesTool.addMessage_Error(e.getMessage());
		}
	} 
	
	public void selectAllBean() {
		EntityManager entityManager = (EntityManager) FacesTool.getRequestAttribute("session");
		listPessoaFisica = new PessoaFisicaRepository(entityManager).selectAllRepository();
	}
}
