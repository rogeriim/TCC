package br.com.tccmanager.controller;

import java.text.ParseException;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.BancaDAO;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Banca;
import br.com.tccmanager.model.EstruturaBanca;
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
	public List<Banca> listar() {
		return dao.findAll();
	}

	@Restrito
	public EstruturaBanca novo(String matricula) {
		EstruturaBanca estrutura = new EstruturaBanca();

		TrabalhoDAO trabalhoDao = new TrabalhoDAO();

		estrutura.setTrabalho(trabalhoDao.findAllByOrientador(matricula));

		UsuarioDAO usuarioDao = new UsuarioDAO();
		estrutura.setAvaliador1(usuarioDao.findAllByPerfil("PROFESSOR"));
		estrutura.setAvaliador2(usuarioDao.findAllByPerfil("PROFESSOR"));

		return estrutura;
	}

	@Restrito
	public void adiciona(Banca banca, Trabalho trabalho, 
			Usuario avaliador1, Usuario avaliador2, String data) throws ParseException {
		
		banca.setData(DataUtil.StringToDate(data));
		banca.setStatus("ABERTO");
		banca.setTrabalho(trabalho);
		banca.setAvaliador1(avaliador1);
		//TODO enviar email avaliador 1
		banca.setAvaliador2(avaliador2);
		//TODO enviar email avaliador 2

		dao.create(banca);
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(int id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

	@Restrito
	public EstruturaBanca editar(int id) {
		EstruturaBanca estrutura = new EstruturaBanca();

		estrutura.setId(id);

		UsuarioDAO usuarioDao = new UsuarioDAO();
		estrutura.setAvaliador1(usuarioDao.findAll());
		estrutura.setAvaliador2(usuarioDao.findAll());

		return estrutura;
	}

	@Restrito
	public void altera(Banca banca, Usuario avaliador1, Usuario avaliador2) {
		banca.setAvaliador1(avaliador1);
		banca.setAvaliador2(avaliador2);	
		dao.update(banca);
		result.redirectTo(this).listar();
	}

	@Restrito
	public Banca ver(int id) {
		return dao.find(id);
	}

}
