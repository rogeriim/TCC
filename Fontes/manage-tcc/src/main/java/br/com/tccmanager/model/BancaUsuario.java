package br.com.tccmanager.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BancaUsuario {
	
	@Id
	@GeneratedValue
	private int id;
	@OneToMany
	private List<Banca> banca;
	@OneToMany
	private List<Usuario> usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Banca> getBanca() {
		return banca;
	}
	public void setBanca(List<Banca> banca) {
		this.banca = banca;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}


}
