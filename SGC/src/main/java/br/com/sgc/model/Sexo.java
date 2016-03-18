package br.com.sgc.model;

public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String sexo;

	public String getSexo() {
		return sexo;
	}

	private Sexo(String sexo) {
		this.sexo = sexo;
	}
}
