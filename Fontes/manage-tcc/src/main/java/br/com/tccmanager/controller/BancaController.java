package br.com.tccmanager.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.BancaDAO;
import br.com.tccmanager.dao.SolicitacaoDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Banca;
import br.com.tccmanager.model.EstruturaBanca;
import br.com.tccmanager.model.Solicitacao;
import br.com.tccmanager.model.Trabalho;
import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.DataUtil;

@Resource
public class BancaController {

	private final BancaDAO dao;
	private final Result result;

	public BancaController(BancaDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Banca> listar(String matricula) {
		return dao.findAllByCriador(matricula);
	}

	@Restrito
	public List<Trabalho> novo(String matricula) {
		List<Trabalho> trabalhoList = new ArrayList<Trabalho>();
		TrabalhoDAO trabalhoDao = new TrabalhoDAO();

		trabalhoList = trabalhoDao.findAllFechadosByProfessor(matricula);

		return trabalhoList;
	}

	@Restrito
	// Banca � criada sem setar os avaliadores, para isto, devera ser criada uma solicitacao
	public void adiciona(Banca banca, Trabalho trabalho, 
			String matricula, String data) throws ParseException {

		UsuarioDAO userDao = new UsuarioDAO();

		banca.setData(DataUtil.StringToDate(data));
		banca.setStatus("ABERTO");
		banca.setCriadoPor(userDao.find(matricula));
		banca.setTrabalho(trabalho);

		dao.create(banca);
		result.redirectTo(this).listar(matricula);
	}

	@Restrito
	public void remove(int id) {
		String matricula = dao.find(id).getCriadoPor().getMatricula();
		dao.remove(id);
		result.redirectTo(this).listar(matricula);
	}

	@Restrito
	public void fechar(int id) {
		Banca banca = dao.find(id);

		banca.setStatus("FECHADO");
		dao.update(banca);

		result.redirectTo(this).listar(banca.getCriadoPor().getMatricula());
	}

	@Restrito
	public EstruturaBanca editar(int id) {
		EstruturaBanca estrutura = new EstruturaBanca();

		List<Usuario> avaliador1 = new ArrayList<Usuario>();
		List<Usuario> avaliador2 = new ArrayList<Usuario>();
		List<Solicitacao> solicitacao = new ArrayList<Solicitacao>();

		UsuarioDAO usuarioDao = new UsuarioDAO();
		SolicitacaoDAO solicitacaoDao = new SolicitacaoDAO();

		solicitacao = solicitacaoDao.findAllAceitasByBanca(id);

		// Dividindo a lista de professores..
		if (solicitacao != null) {
			for (int i = 0; i < solicitacao.size(); i++) {
				if ((i % 2) == 0)
					avaliador1.add(usuarioDao.find(solicitacao.get(i).getProfessor().getMatricula()));
				else avaliador2.add(usuarioDao.find(solicitacao.get(i).getProfessor().getMatricula()));
			}
		}

		estrutura.setBanca(dao.find(id));
		estrutura.setAvaliador1(avaliador1);
		estrutura.setAvaliador2(avaliador2);

		return estrutura;
	}

	@Restrito
	public void altera(Banca banca, Usuario avaliador1, Usuario avaliador2, String data) {
		
		if (avaliador1.getNome() != null)
			banca.setAvaliador1(avaliador1);
		if (avaliador2.getNome() != null)
			banca.setAvaliador2(avaliador2);
		if (data != null)
			banca.setData(DataUtil.StringToDate(data));

		dao.update(banca);

		result.redirectTo(this).listar(banca.getCriadoPor().getMatricula());
	}

	@Restrito
	public Banca ver(int id) {
		return dao.find(id);
	}

}
