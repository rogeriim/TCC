package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.BancaDAO;
import br.com.tccmanager.dao.SolicitacaoDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.EstruturaSolicitacao;
import br.com.tccmanager.model.Solicitacao;

@Resource
public class SolicitacaoController {

	private final SolicitacaoDAO dao;
	private final Result result;

	public SolicitacaoController(SolicitacaoDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Solicitacao> listar(String matricula) {
		return dao.findAllByCriador(matricula);
	}
	
	@Restrito
	public List<Solicitacao> pendencias(String matricula) {
		return dao.findAllByProfessor(matricula);
	}

	@Restrito
	public void remove(int id, String matricula) {
		dao.remove(id);
		result.redirectTo(this).listar(matricula);
	}
	
	@Restrito
	public void aceitar(int id) {
		Solicitacao s = dao.find(id);
		String matricula = s.getProfessor().getMatricula();
		
		s.setResposta("SIM");
		// TODO enviar email informando o professor criador da solicitação..
		
		dao.update(s);
		result.redirectTo(this).pendencias(matricula);
	}
	
	@Restrito
	public void recusar(int id) {
		Solicitacao s = dao.find(id);
		
		String matricula = s.getProfessor().getMatricula();
		
		s.setResposta("NAO");
		// TODO enviar email informando o professor criador da solicitação..
		
		dao.update(s);
		result.redirectTo(this).pendencias(matricula);
	}
	
	@Restrito
	// Retorna para a página JSP uma estrutura com os professores disponíveis para enviar solicitacao
	public EstruturaSolicitacao criar(int id) {
		EstruturaSolicitacao estrutura = new EstruturaSolicitacao();

		BancaDAO bancaDao = new BancaDAO();
		UsuarioDAO userDao = new UsuarioDAO();
		
		estrutura.setBanca(bancaDao.find(id));
		estrutura.setProfessor(userDao.findAllProfessorSolicitacaoBanca(
				bancaDao.find(id).getCriadoPor().getMatricula(), id));
		
		return estrutura;
	}
	
	@Restrito
	public void adiciona(String matricula, String matriculaProfessor, int bancaId) {
		Solicitacao solicitacao = new Solicitacao();
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		BancaDAO bancaDao = new BancaDAO();
		
		solicitacao.setProfessor(usuarioDao.find(matriculaProfessor));
		solicitacao.setAbertoPor(usuarioDao.find(matricula));
		solicitacao.setBanca(bancaDao.find(bancaId));
		solicitacao.setResposta("PENDENTE");
		
		dao.create(solicitacao);
		
		// TODO enviar email ao professor informando da solicitacao..
		
		result.redirectTo(BancaController.class).listar(matricula);
	}

}