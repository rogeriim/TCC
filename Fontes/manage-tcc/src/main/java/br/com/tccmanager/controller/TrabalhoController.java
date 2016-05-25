package br.com.tccmanager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.CandidatoDAO;
import br.com.tccmanager.dao.TemaDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.model.Candidato;
import br.com.tccmanager.model.EstruturaTrabalho;
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

	@Restrito
	public List<Trabalho> listar() {
		return dao.findAll();
	}

	@Restrito
	public void adiciona(Trabalho trabalho, Tema tema) {
		trabalho.setTema(tema);
		trabalho.setData(new Date());
		dao.create(trabalho);
		result.redirectTo(this).listar();
	}

	@Restrito
	public List<Tema> novo() {
		TemaDAO temaDao = new TemaDAO();
		return temaDao.findAll();
	}

	@Restrito
	public void adicionaTema(Tema tema, String pagina, int trabalhoId) {
		TemaDAO temaDao = new TemaDAO();
		temaDao.create(tema);

		if (pagina.equalsIgnoreCase("editar"))
			result.redirectTo(this).editar(trabalhoId);
		else result.redirectTo(this).novo();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

	@Restrito
	public EstruturaTrabalho editar(int id) {
		EstruturaTrabalho estrutura = new EstruturaTrabalho();
		estrutura.setId(id);
		estrutura.setTrabalho(dao.find(id));

		TemaDAO temaDao = new TemaDAO();
		estrutura.setTema(temaDao.findAll());

		// TODO implementar Query para buscar alunos interessados em realizar o trabalho.

		return estrutura;
	}

	@Restrito
	public void altera(Trabalho trabalho, Tema tema) {
		trabalho.setTema(tema);
		System.out.println("Descricao: " + trabalho.getDescricao());
		// TODO implementar atualização de orientando também..

		dao.update(trabalho);
		result.redirectTo(this).listar();
	}

	@Restrito
	public EstruturaTrabalho ver(int id, String matricula) {
		EstruturaTrabalho estrutura = new EstruturaTrabalho();

		estrutura.setTrabalho(dao.find(id));

		// verifica se o aluno logado já é candidato àquele trabalho..
		List<Candidato> candidatoList = new ArrayList<Candidato>();
		CandidatoDAO candidatoDao = new CandidatoDAO();
		Candidato candidato = candidatoDao.findByTrabalhoAndMatricula(id, matricula);

		if (candidato != null) {
			candidatoList.add(candidatoDao.findByTrabalhoAndMatricula(id, matricula));
			estrutura.setCandidato(candidatoList);
		}

		return estrutura;
	}

}
