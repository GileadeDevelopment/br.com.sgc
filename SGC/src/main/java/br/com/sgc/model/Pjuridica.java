package br.com.sgc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa_juridica")
@PrimaryKeyJoinColumn(name="pessoa_id")
public class Pjuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String ie; //inscrição estadual 
	private String nomeFantasia;
	private Date dataAbertura;
	//private Pfisica representante;
	
	@Column(name = "cnpj", length = 60, nullable = false)
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Column(name = "inscricao_estadual", length = 60, nullable = false)
	public String getIe() {
		return ie;
	}
	public void setIe(String ie) {
		this.ie = ie;
	}
	
	@Column(name = "nome_fantasia", length = 60, nullable = false)
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	/*
	public Pfisica getRepresentante() {
		return representante;
	}
	public void setRepresentante(Pfisica representante) {
		this.representante = representante;
	}
	*/

}
