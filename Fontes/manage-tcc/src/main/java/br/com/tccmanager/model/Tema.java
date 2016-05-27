package br.com.tccmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tema {
	
	@Id
	@GeneratedValue
	private int id; 
	private String status;
	private String tema;
	@ManyToOne
	private Usuario adicionadoPor;
	
	/*
	 * Getters and Setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public Usuario getAdicionadoPor() {
		return adicionadoPor;
	}
	public void setAdicionadoPor(Usuario adicionadoPor) {
		this.adicionadoPor = adicionadoPor;
	}

}
