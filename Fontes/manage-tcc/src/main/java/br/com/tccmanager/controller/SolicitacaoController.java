package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.SolicitacaoDAO;
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
	public List<Solicitacao> listar() {
		return dao.findAll();
	}

	@Restrito
	public void adiciona(Solicitacao solicitacao) {
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}


}
