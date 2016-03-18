package br.com.sgc.model;

public enum TipoLancamento {
	RECEITA("Receita"),
	DESPESA("Despesa"),
	INVESTIMENTO("Investimento");
	
	private String tipoLancamento;
	
	public String getTipoLancamento() {
		return tipoLancamento;
	}

	private TipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
}
