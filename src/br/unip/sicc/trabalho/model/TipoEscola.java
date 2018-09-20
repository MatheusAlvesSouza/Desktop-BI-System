package br.unip.sicc.trabalho.model;

public enum TipoEscola {
	
	MEDIO("Médio"),
	FUNDAMENTAL("Fundamental"),
	SUPERIOR("Superior");

	private String descricao;

	TipoEscola(String descricao){
		this.descricao = descricao;
	}	

	public String getDescricao(){
		return this.descricao;
	}
	
}
