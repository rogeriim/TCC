package br.com.tccmanager.controller;

import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.dao.TemaDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.model.Estrutura;
import br.com.tccmanager.model.Tema;
import br.com.tccmanager.model.Trabalho;

@Resource
public class TrabalhoController {

	private final TrabalhoDAO dao;
	private final Result result;

	public TrabalhoController(TrabalhoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	public List<Trabalho> listar() {
		return dao.findAll();
	}

	public void adiciona(Trabalho trabalho, Tema tema) {
		trabalho.setTema(tema);
		trabalho.setData(new Date());
		dao.create(trabalho);
		result.redirectTo(this).listar();
	}

	public List<Tema> novo() {
		TemaDAO temaDao = new TemaDAO();
		return temaDao.findAll();
	}

	public void adicionaTema(Tema tema) {
		TemaDAO temaDao = new TemaDAO();
		temaDao.create(tema);
		result.redirectTo(this);
	}

	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

	public Estrutura editar(int id) {
		Estrutura estrutura = new Estrutura();
		estrutura.setId(10);
		estrutura.setTrabalho(dao.find(id));

		TemaDAO temaDao = new TemaDAO();
		estrutura.setTema(temaDao.findAll());

		// TODO implementar Query para buscar alunos interessados em realizar o trabalho.

		return estrutura;
	}

	public void altera(Trabalho trabalho, Tema tema) {
		trabalho.setTema(tema);
		System.out.println("Descricao: " + trabalho.getDescricao());
		// TODO implementar atualização de orientando também..
		
		dao.update(trabalho);
		result.redirectTo(this).listar();
	}

	public Trabalho ver(int id) {
		return dao.find(id);
	}

}
