package br.com.tccmanager.model;

import java.util.List;

public class EstruturaBanca {

	private Banca banca;
	private List<Usuario> avaliador1;
	private List<Usuario> avaliador2;

	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public List<Usuario> getAvaliador1() {
		return avaliador1;
	}
	public void setAvaliador1(List<Usuario> avaliador1) {
		this.avaliador1 = avaliador1;
	}
	public List<Usuario> getAvaliador2() {
		return avaliador2;
	}
	public void setAvaliador2(List<Usuario> avaliador2) {
		this.avaliador2 = avaliador2;
	}

}
