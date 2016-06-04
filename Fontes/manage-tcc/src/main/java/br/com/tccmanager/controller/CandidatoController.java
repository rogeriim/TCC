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
import br.com.tccmanager.util.EmailUtil;

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
		candidato.setStatus("ABERTO");
		
		// Setando a prioridade automaticamente, conforme a ordem de inserção
		int prioridade = dao.findAllByUser(matricula).size() + 1;
		candidato.setPrioridade(prioridade);
		
		dao.create(candidato);
		result.redirectTo(this).listar(matricula);
	}
	
	// método utilizado para salvar os interesses do aluno, uma vez salvo, não poderão mais ser alterados
	@Restrito
	public void salvar(String id) {
		List<Candidato> candidatoList = new ArrayList<Candidato>();
		
		candidatoList = dao.findAllByUser(id);
		
		for (int i = 0; i < candidatoList.size(); i++) {
			candidatoList.get(i).setStatus("FECHADO");
			
			// envia email para os orientadores informando o interesse do aluno
			EmailUtil.sendEmail(candidatoList.get(i).getTrabalho().getOrientador().getEmail(),
					"[TCC] Aluno interessado em realizar o trabalho \"" + candidatoList.get(i).getTrabalho().getTitulo() + "\"",
					"Olá, professor " + candidatoList.get(i).getTrabalho().getOrientador().getNome() + "."
					+ "\n\nO aluno <i>" + candidatoList.get(i).getAluno().getNome() + "</i> manifestou interesse em realizar o trabalho <i>"
					+ candidatoList.get(i).getTrabalho().getTitulo() + "</i> disponibilizado por você. Para selecionar o aluno "
					+ "para ser seu orientando no desenvolvimento do trabalho, acesse a aplicação TCC Manager e vá à pagina "
					+ "de edição do trabalho.\n\nAtt.");
			
			dao.update(candidatoList.get(i));
		}
		
		result.redirectTo(this).listar(id);
	}

	@Restrito
	// Se o cara entrar nesse método pela página do trabalho, aparecerá só aquele trabalho para ser selecionado.
	public List<Trabalho> criar(String id, String matricula) {
		List<Trabalho> trabalhoList = new ArrayList<Trabalho>();

		// Listará apenas os trabalhos que estiverem disponíveis e que já não estiverem na lista de prioridades do aluno
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
