package br.com.tccmanager.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.CandidatoDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Candidato;
import br.com.tccmanager.model.Trabalho;

@Resource
public class CandidatoController {

	private final CandidatoDAO dao;
	private final Result result;

	public CandidatoController(CandidatoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Candidato> listar(String matricula) {
		return dao.findAllByUser(matricula);
	}

	@Restrito
	public void adiciona(String matricula, Trabalho trabalho, int prioridade) {
		Candidato candidato = new Candidato();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		candidato.setAluno(usuarioDao.find(matricula));
		candidato.setTrabalho(trabalho);
		candidato.setPrioridade(prioridade);
		
		dao.create(candidato);
		result.redirectTo(this).listar(candidato.getAluno().getMatricula());
	}

	@Restrito
	public List<Trabalho> criar(String id) {
		List<Trabalho> trabalhoList = new ArrayList<Trabalho>();

		TrabalhoDAO trabalhoDao = new TrabalhoDAO();
		if (id != null) {
			if (id.isEmpty())
				trabalhoList = trabalhoDao.findAll();
			else 
				trabalhoList.add(trabalhoDao.find(Integer.parseInt(id)));
		} else {
			trabalhoList = trabalhoDao.findAll();
		}

		return trabalhoList;
	}

	@Restrito
	public void remove(int id) {
		Candidato c = dao.find(id);
		dao.remove(id);
		result.redirectTo(this).listar(c.getAluno().getMatricula());
	}

}
