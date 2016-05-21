package br.com.tccmanager.model;

import java.util.List;

public class EstruturaBanca {

	private int id;
	private List<Trabalho> trabalho;
	private List<Usuario> avaliador1;
	private List<Usuario> avaliador2;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Trabalho> getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(List<Trabalho> trabalho) {
		this.trabalho = trabalho;
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
