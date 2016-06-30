package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Perfil;
import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.CriptografiaUtil;
import br.com.tccmanager.util.EmailUtil;
import br.com.tccmanager.util.GeradorSenhaUtil;

@Resource
public class UsuarioController {

	private final UsuarioDAO dao;
	private final Result result;

	public UsuarioController(UsuarioDAO dao, Result result) {
		this.dao = dao;
		this.result = result;
	}

	@Restrito
	public List<Usuario> listar() {
		return dao.findAll();
	}

	@Restrito
	public List<Perfil> novo() {
		PerfilDAO perfilDao = new PerfilDAO();
		return perfilDao.findAll();
	}

	@Restrito
	public void adiciona(Usuario usuario, Perfil perfil) {
		usuario.setPerfil(perfil);

		String senha = GeradorSenhaUtil.randomString(8);
		
		// Envia email para o usuario informando sua senha de acesso.
		EmailUtil.sendEmail(usuario.getEmail(),
				"[TCC] Você foi cadastrado no sistema TCC Manager",
				"Olá, " + usuario.getNome() + "."
						+ "<br><br>Este é um email automático para informar que você foi cadastrado no sistema TCC Manager. " 
						+ "Para entrar no sistema, você deverá acessar o link <a href=\"http://192.168.0.108:8080/tcc-manager/home/loginForm\">"
						+ "http://localhost:8080/tcc-manager/home/loginForm</a> de seu brower e utilizar os seguintes dados: "
						+ "<br><br><b>Usuario: </b>" + usuario.getMatricula()
						+ "<br><b>Senha: </b>" + senha
						+ "<br><br>Att.");

		usuario.setSenha(CriptografiaUtil.criptografar(senha));

		dao.create(usuario);
		result.redirectTo(this).listar();
	}

	@Restrito
	public void remove(String id) {
		dao.remove(id);
		result.redirectTo(this).listar();
	}

	@Restrito
	public Usuario editar(String matricula) {
		return dao.find(matricula);
	}

	@Restrito
	public void altera(Usuario usuario) {
		dao.update(usuario);
		result.redirectTo(this).listar();
	}

	@Restrito
	public Usuario ver(String matricula) {
		return dao.find(matricula);
	}
}
