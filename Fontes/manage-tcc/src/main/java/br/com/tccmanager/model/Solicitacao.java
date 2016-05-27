package br.com.tccmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Solicitacao {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Usuario abertoPor;
	@ManyToOne
	private Usuario professor;
	@ManyToOne
	private Banca banca;
	private String resposta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getAbertoPor() {
		return abertoPor;
	}
	public void setAbertoPor(Usuario abertoPor) {
		this.abertoPor = abertoPor;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
}
