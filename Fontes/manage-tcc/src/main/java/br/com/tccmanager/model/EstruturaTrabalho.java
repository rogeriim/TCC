package br.com.tccmanager.model;

import java.util.List;

public class EstruturaTrabalho {
	
	private int id;
	private Trabalho trabalho;
	private List<Usuario> usuario;
	private List<Tema> tema;
	private List<Candidato> candidato;
	
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
	public List<Candidato> getCandidato() {
		return candidato;
	}
	public void setCandidato(List<Candidato> candidato) {
		this.candidato = candidato;
	}
		
}