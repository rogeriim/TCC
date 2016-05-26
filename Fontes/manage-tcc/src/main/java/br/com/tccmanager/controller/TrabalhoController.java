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
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Candidato;
import br.com.tccmanager.model.EstruturaTrabalho;
import br.com.tccmanager.model.Tema;
import br.com.tccmanager.model.Trabalho;
import br.com.tccmanager.model.Usuario;

@Resource
public class TrabalhoController {

	private final TrabalhoDAO dao;
	private final Result result;

	public TrabalhoController(TrabalhoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Trabalho> listar(String matricula) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario usuario = userDao.find(matricula);

		if (usuario.getPerfil().getPerfil().equalsIgnoreCase("ALUNO")) 
			return dao.findAllDisponiveis();
		else return dao.findAllByProfessor(matricula);

	}

	@Restrito
	public void adiciona(Trabalho trabalho, Tema tema, String matricula) {
		UsuarioDAO userDao = new UsuarioDAO();

		Usuario orientador = userDao.find(matricula);

		trabalho.setTema(tema);
		trabalho.setData(new Date());
		trabalho.setOrientador(orientador);
		trabalho.setDisponivel(true);

		dao.create(trabalho);
		result.redirectTo(this).listar(matricula);
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
		Trabalho trabalho = dao.find(id);
		dao.remove(id);
		result.redirectTo(this).listar(trabalho.getOrientador().getMatricula());
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
		result.redirectTo(this).listar(trabalho.getOrientador().getMatricula());
	}

	@Restrito
	public EstruturaTrabalho ver(int id, String matricula) {
		EstruturaTrabalho estrutura = new EstruturaTrabalho();
		CandidatoDAO candidatoDao = new CandidatoDAO();

		estrutura.setTrabalho(dao.find(id));

		// verifica se o aluno ainda possui a opção para se candidatar..
		List<Candidato> candidatoList = new ArrayList<Candidato>();
		candidatoList = candidatoDao.findAllByUser(matricula);

		if ((!candidatoList.isEmpty() && candidatoList.size() < 3)) {
			if (candidatoList.get(0).getStatus().equalsIgnoreCase("FECHADO")) {
				estrutura.setMostrarOpcaoCandidatura(false);
				return estrutura;
			}
		}

		Candidato candidato = candidatoDao.findByTrabalhoAndMatricula(id, matricula);

		// verifica se o aluno logado já é candidato àquele trabalho..
		if (candidato != null) {
			candidatoList.add(candidatoDao.findByTrabalhoAndMatricula(id, matricula));
			estrutura.setCandidato(candidatoList);
		}

		return estrutura;
	}

	@Restrito
	public void desfazer(String id, String matricula) {
		EstruturaTrabalho estrutura = new EstruturaTrabalho();

		estrutura.setTrabalho(dao.find(Integer.parseInt(id)));

		CandidatoDAO candidatoDao = new CandidatoDAO();
		Candidato candidato = candidatoDao.findByTrabalhoAndMatricula(Integer.parseInt(id), matricula);

		// Atualiza as prioridades, decrementando para ajustar as ordens
		for (int i = candidato.getPrioridade(); i < candidatoDao.findAllByUser(matricula).size(); i++) {
			Candidato next = candidatoDao.findByPrioridade(matricula, (i + 1));
			next.setPrioridade(i);
			candidatoDao.update(next);
		}

		candidatoDao.remove(candidato.getId());

		result.redirectTo(this).ver(Integer.parseInt(id), matricula);
	}

}
