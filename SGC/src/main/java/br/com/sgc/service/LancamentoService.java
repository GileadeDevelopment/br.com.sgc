package br.com.sgc.service;

import java.io.Serializable;
import java.util.Date;

import br.com.sgc.model.Lancamento;
import br.com.sgc.repository.LancamentoRepository;

public class LancamentoService implements Serializable {

	private static final long serialVersionUID = 1L;

	LancamentoRepository lancamentoRepository;

	public LancamentoService(LancamentoRepository repositoryLancamento) {
		this.lancamentoRepository = repositoryLancamento;
	}

	public void insertService(Lancamento lancamento) throws BusinessException {
		if (lancamento.getDataPagamento() != null && lancamento.getDataPagamento().after(new Date())) {
			throw new BusinessException("Data de pagamento não pode ser uma data futura.");
		}
		this.lancamentoRepository.insertRepository(lancamento);
	}

	public void deleteService(Lancamento lancamento)throws BusinessException{
		if(lancamento.isPago()){
			throw new BusinessException("Não é possível excluír lançamento pago");
		}
		this.lancamentoRepository.deleteRepository(lancamento);
	}
}
