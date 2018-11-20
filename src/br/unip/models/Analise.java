package br.unip.models;

public class Analise {
	private String reserva;
	private String cidade;
	private String estado;
	private int populacao;
	private int natalidade;
	private int mortalidade;
	private int denuncias;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReserva() {
		return reserva;
	}
	public void setReserva(String reserva) {
		this.reserva = reserva;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public int getNatalidade() {
		return natalidade;
	}
	public void setNatalidade(int natalidade) {
		this.natalidade = natalidade;
	}
	public int getMortalidade() {
		return mortalidade;
	}
	public void setMortalidade(int mortalidade) {
		this.mortalidade = mortalidade;
	}
	public int getDenuncias() {
		return denuncias;
	}
	public void setDenuncias(int denuncias) {
		this.denuncias = denuncias;
	}
	
	
}
