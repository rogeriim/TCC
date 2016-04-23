package br.com.tccmanager.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Banca {
	
	@Id
	@GeneratedValue
	private int id;
	private Date data;
	private String status;
	// TODO ver como mapear as chaves estrangeiras..
	// @ManyToOne
	// private List<Usuario> avaliador;
	// @ManyToOne
	// private Trabalho trabalho;
	
	/*
	 * Getters and Setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/* public List<Usuario> getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(List<Usuario> avaliador) {
		this.avaliador = avaliador;
	} 
	public Trabalho getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	} */
	
}
