package br.com.sgc.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sgc.model.Lancamento;
import br.com.sgc.model.PessoaFisica;
import br.com.sgc.model.TipoLancamento;
import br.com.sgc.repository.LancamentoRepository;
import br.com.sgc.repository.PessoaFisicaRepository;
import br.com.sgc.service.BusinessException;
import br.com.sgc.service.LancamentoService;
import br.com.sgc.tool.ConnectionJPA;
import br.com.sgc.tool.FacesTool;
import br.com.sgc.tool.GetDateRegister;

@ViewScoped
@ManagedBean(name = "LancamentoBean")
public class LancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Lancamento lancamento = new Lancamento();
	private List<PessoaFisica> listPessoaFisica;
	private List<Lancamento> listLancamento;

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<PessoaFisica> getListPessoFisica() {
		return listPessoaFisica;
	}

	public List<Lancamento> getListLancamento() {
		return listLancamento;
	}

	public TipoLancamento[] getListTipoLancamento() {
		return TipoLancamento.values();
	}

	public void valueChangeListenerSetPago(ValueChangeEvent valueChangeEvent) {
		this.lancamento.setPago((Boolean) valueChangeEvent.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
	}

	public void actionListenerGetDataRegister(ActionEvent actionEvent) {
		this.lancamento.setDataCadastro(GetDateRegister.getDateRegister());
	}

	public void selectAllPessoa() {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		try {
			this.listPessoaFisica = new PessoaFisicaRepository(entityManager).selectAllRepository();
		} finally {
			entityManager.close();
		}
	}

	public void selectAllLancamento() {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		try {
			this.listLancamento = new LancamentoRepository(entityManager).selectAllRepository();
		} finally {
			entityManager.close();
		}
	}

	public void insertBean() {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			new LancamentoService(new LancamentoRepository(entityManager)).insertService(lancamento);
			this.lancamento = new Lancamento();
			FacesTool.addMessage_Info("Lançamento Salvo Com Sucesso.");
			transaction.commit();
		} catch (BusinessException e) {
			transaction.rollback();
			FacesTool.addMessage_Error(e.getMessage());
		} finally {
			entityManager.close();
		}
	}

	public void deleteBean() {
		EntityManager entityManager = ConnectionJPA.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			new LancamentoService(new LancamentoRepository(entityManager)).deleteService(lancamento);
			FacesTool.addMessage_Info("Lancamento Excluído Com Sucesso.");
			transaction.commit();
			this.selectAllLancamento();
		} catch (BusinessException e) {
			transaction.rollback();
			FacesTool.addMessage_Error(e.getMessage());
		} finally {
			entityManager.close();
		}
	}
}
