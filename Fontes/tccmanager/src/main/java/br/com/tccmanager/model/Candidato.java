package br.com.tccmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Candidato {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Usuario aluno;
	@ManyToOne
	private Trabalho trabalho;
	private int prioridade;
	private String status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getAluno() {
		return aluno;
	}
	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}
	public Trabalho getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
