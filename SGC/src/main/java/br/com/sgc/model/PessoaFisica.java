package br.com.sgc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class PessoaFisica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private String rg;
	private Sexo sexo;
	private Date dataNascimento;
	private PessoaFisica conjuge;

	@Column(name = "cpf", length = 60, nullable = false)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "rg", length = 60, nullable = false)
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", length = 10, nullable = false)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@OneToOne(optional = true)
	@JoinColumn(name = "pessoa_fisica_id")
	public PessoaFisica getConjuge() {
		return conjuge;
	}

	public void setConjuge(PessoaFisica conjuge) {
		this.conjuge = conjuge;
	}
}