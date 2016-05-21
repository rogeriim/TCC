package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.model.Perfil;

@Resource
public class PerfilController {

	private final PerfilDAO dao;
	private final Result result;

	public PerfilController(PerfilDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Perfil> listar() {
		return dao.findAll();
	}

	@Restrito
	public void adiciona(Perfil perfil) {
		dao.create(perfil);
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

}
