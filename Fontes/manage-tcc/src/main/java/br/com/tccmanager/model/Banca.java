package br.com.tccmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Banca {

	@Id
	@GeneratedValue
	private int id;
	private Date data;
	private String status;
	@OneToOne
	private Trabalho trabalho;
	@ManyToOne
	private Usuario avaliador1;
	@ManyToOne
	private Usuario avaliador2;
	@ManyToOne
	private Usuario criadoPor;

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
	public Trabalho getTrabalho() {
		return trabalho;
	}
	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}
	public Usuario getAvaliador1() {
		return avaliador1;
	}
	public void setAvaliador1(Usuario avaliador1) {
		this.avaliador1 = avaliador1;
	}
	public Usuario getAvaliador2() {
		return avaliador2;
	}
	public void setAvaliador2(Usuario avaliador2) {
		this.avaliador2 = avaliador2;
	}
	public Usuario getCriadoPor() {
		return criadoPor;
	}
	public void setCriadoPor(Usuario criadoPor) {
		this.criadoPor = criadoPor;
	}

}
