package br.com.tccmanager.model;

import java.util.List;

public class EstruturaSolicitacao {

	private Banca banca;
	private List<Usuario> professor;
	
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public List<Usuario> getProfessor() {
		return professor;
	}
	public void setProfessor(List<Usuario> professor) {
		this.professor = professor;
	}
	
}
