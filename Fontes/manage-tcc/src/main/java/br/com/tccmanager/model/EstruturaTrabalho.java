package br.com.tccmanager.model;

import java.util.List;

public class EstruturaTrabalho {
	
	private int id;
	private Trabalho trabalho;
	private List<Usuario> usuario;
	private List<Tema> tema;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Trabalho getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	public List<Tema> getTema() {
		return tema;
	}
	public void setTema(List<Tema> tema) {
		this.tema = tema;
	}
		
}