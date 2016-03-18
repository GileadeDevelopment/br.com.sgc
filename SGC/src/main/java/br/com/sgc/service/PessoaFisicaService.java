package br.com.sgc.service;

import java.io.Serializable;
import java.util.Date;

import br.com.sgc.model.PessoaFisica;
import br.com.sgc.repository.PessoaFisicaRepository;

public class PessoaFisicaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private PessoaFisicaRepository pessoaFisicaRepository;

	public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}
	
	public void inserService(PessoaFisica pessoaFisica) throws BusinessException {
		if(pessoaFisica.getDataNascimento()!=null && pessoaFisica.getDataNascimento().after(new Date())){
			throw new BusinessException("Data de nascimento não pode ser uma data futura.");
		}
		this.pessoaFisicaRepository.insertRepository(pessoaFisica);
	}

}
