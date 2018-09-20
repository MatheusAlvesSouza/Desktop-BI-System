package br.unip.sicc.trabalho.model;

public class Escola {
	
	private int id;
	private String nomeFantasia;
	private int qtdeAlunos;
	private TipoEscola tipo;
	
	
	
	public TipoEscola getTipo() {
		return tipo;
	}

	public void setTipo(TipoEscola tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getQtdeAlunos() {
		return qtdeAlunos;
	}

	public void setQtdeAlunos(int qtdeAlunos) {
		this.qtdeAlunos = qtdeAlunos;
	}

	public void equals () {
		
	}
	
	public int hashCode () {
		return 1;
	}
	
	public String toString () {
		return "Escola";
	}
	
}
