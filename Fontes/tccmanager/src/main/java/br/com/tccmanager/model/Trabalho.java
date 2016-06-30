package br.com.tccmanager.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Trabalho {
	
	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private String descricao;
	private String status;
	private Date data;
	private boolean publicavel;
	@ManyToOne
	private Tema tema;
	@ManyToOne
	private Usuario orientador;
	@ManyToOne
	private Usuario orientando;
	
	/*
	 * Getters and Setters
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean isPublicavel() {
		return publicavel;
	}
	public void setPublicavel(boolean publicavel) {
		this.publicavel = publicavel;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public Usuario getOrientador() {
		return orientador;
	}
	public void setOrientador(Usuario orientador) {
		this.orientador = orientador;
	}
	public Usuario getOrientando() {
		return orientando;
	}
	public void setOrientando(Usuario orientando) {
		this.orientando = orientando;
	}

}
