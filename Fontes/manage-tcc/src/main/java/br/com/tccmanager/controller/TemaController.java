package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.TemaDAO;
import br.com.tccmanager.model.Tema;

@Resource
public class TemaController {

	private final TemaDAO dao;
	private final Result result;

	public TemaController(TemaDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Tema> listar() {
		return dao.findAll();
	}

	@Restrito
	public void adiciona(Tema tema) {
		dao.create(tema);
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

}
