package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.MonografiaDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.model.Monografia;
import br.com.tccmanager.model.Trabalho;

@Resource
public class MonografiaController {

	private final MonografiaDAO dao;
	private final Result result;

	public MonografiaController(MonografiaDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Monografia> listar() {
		return dao.findAll();
	}

	@Restrito
	public List<Trabalho> novo() {
		TrabalhoDAO trabalhoDao = new TrabalhoDAO();
		return trabalhoDao.findAll();
	}

	@Restrito
	public void adiciona(Monografia monografia, Trabalho trabalho) {		
		monografia.setTrabalho(trabalho);
		
		dao.create(monografia);
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

	@Restrito
	public Monografia editar(int id) {
		return dao.find(id);
	}

	@Restrito
	public void altera(Monografia monografia) {
		dao.update(monografia);
		result.redirectTo(this).listar();
	}

	@Restrito
	public Monografia ver(int id) {
		return dao.find(id);
	}
	
}
