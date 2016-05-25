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
	public void adiciona(String matricula, Trabalho trabalho) {
		Candidato candidato = new Candidato();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		candidato.setAluno(usuarioDao.find(matricula));
		candidato.setTrabalho(trabalho);
		
		// Setando a prioridade automaticamente, conforme a ordem de inser��o
		int prioridade = dao.findAllByUser(matricula).size() + 1;
		candidato.setPrioridade(prioridade);
		
		dao.create(candidato);
		result.redirectTo(this).listar(candidato.getAluno().getMatricula());
	}

	@Restrito
	// Se o cara entrar nesse m�todo pela p�gina do trabalho, aparecer� s� aquele trabalho para ser selecionado.
	public List<Trabalho> criar(String id, String matricula) {
		List<Trabalho> trabalhoList = new ArrayList<Trabalho>();

		// Listar� apenas os trabalhos que estiverem dispon�veis e que j� n�o estiverem na lista de prioridades do aluno
		TrabalhoDAO trabalhoDao = new TrabalhoDAO();
		if (id != null) {
			if (id.isEmpty())
				trabalhoList = trabalhoDao.findTrabalhosDisponiveisCandidatura(matricula);
			else 
				trabalhoList.add(trabalhoDao.find(Integer.parseInt(id)));
		} else {
			trabalhoList = trabalhoDao.findTrabalhosDisponiveisCandidatura(matricula);
		}

		return trabalhoList;
	}

	@Restrito
	public void remove(int id) {
		Candidato c = dao.find(id);	
		String matricula = c.getAluno().getMatricula();
		
		// Atualiza as prioridades, decrementando para ajustar as ordens
		for (int i = c.getPrioridade(); i < dao.findAllByUser(matricula).size(); i++) {
			Candidato next = dao.findByPrioridade(matricula, (i + 1));
			next.setPrioridade(i);
			dao.update(next);
		}
		
		dao.remove(id);
		result.redirectTo(this).listar(c.getAluno().getMatricula());
	}

}
