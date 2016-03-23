package br.com.sgc.service;

import java.io.Serializable;
import java.util.Date;

import br.com.sgc.model.PessoaFisica;
import br.com.sgc.repository.PessoaFisicaRepository;

public class PessoaFisicaService implements Serializable {
	
	/*
	 *	Class Attributes
	 */	
	private static final long serialVersionUID = 1L;

	private PessoaFisicaRepository pessoaFisicaRepository;

	
	/*
	 *	Constructor
	 */
	public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
		this.pessoaFisicaRepository = pessoaFisicaRepository;
	}

	/*
	 *	Method  - inserService
	 *	Responsibility - 
	 */
	public void inserService(PessoaFisica pessoaFisica) throws BusinessException {
		if (pessoaFisicaDuplicadaService(pessoaFisica)) {
			throw new BusinessException("Já Existe Pessoa Cadastrada.");
		}
		
		else if (pessoaFisica.getDataNascimento() != null && pessoaFisica.getDataNascimento().after(new Date())) {
			throw new BusinessException("Data de nascimento não pode ser uma data futura.");
		}
		else {
			this.pessoaFisicaRepository.insertRepository(pessoaFisica);
		}
	}
	
	/*
	 *	Method  - 
	 *	Responsibility - 
	 */
	public void editarService(PessoaFisica pessoaFisica) throws BusinessException {
		if (pessoaFisicaDuplicadaService(pessoaFisica)) {
			throw new BusinessException("Já Existe Pessoa Cadastrada.");
		}
		
		else if (pessoaFisica.getDataNascimento() != null && pessoaFisica.getDataNascimento().after(new Date())) {
			throw new BusinessException("Data de nascimento não pode ser uma data futura.");
		}
		else {
			this.pessoaFisicaRepository.editarRepository(pessoaFisica);
		}
	}

	/*
	 *	Method  - 
	 *	Responsibility - 
	 */
	private boolean pessoaFisicaDuplicadaService(PessoaFisica pessoaFisica) throws BusinessException {
		PessoaFisica pessoaFisicaDuplicada = this.pessoaFisicaRepository.pessoasFisicaDuplicadaRepository(pessoaFisica);
		return pessoaFisicaDuplicada != null && !pessoaFisicaDuplicada.equals(pessoaFisica);
	}

	/*
	 *	Method  - 
	 *	Responsibility - 
	 */
	public void deleteService(PessoaFisicaRepository fisicaRepository) throws BusinessException {

	}

}