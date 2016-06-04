package br.com.tccmanager.model;

import java.util.List;

public class EstruturaBanca {
	
	private int bancaId;
	private List<Usuario> usuario;
	
	public int getBancaId() {
		return bancaId;
	}
	public void setBancaId(int bancaId) {
		this.bancaId = bancaId;
	}
	public List<Usuario> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}
