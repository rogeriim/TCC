package br.com.tccmanager.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.tccmanager.auth.UsuarioWeb;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Usuario;

@Resource
public class HomeController {

	private UsuarioDAO usuarioDao;
	private Result result;
	private Validator validator;
	private UsuarioWeb usuarioWeb;

	public HomeController(UsuarioDAO usuarioDao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	public void loginForm() {
	}

	public void login(Usuario usuario) {
		Usuario carregado = usuarioDao.carrega(usuario);
		if (carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inv�lidos",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(HomeController.class).loginForm();
		usuarioWeb.login(carregado);
		if(carregado.isPrimeiroAcesso())
			result.redirectTo(this).primeiroLogin(carregado);
		else result.redirectTo(TrabalhoController.class).listar();
	}

	public Usuario primeiroLogin(Usuario usuario) {
		return usuario;
	}

	public void alteraSenha(String matricula, String senha, String senhaConfirmada) {
		if (!senha.equals(senhaConfirmada)) {
			validator.add(new ValidationMessage("Senhas digitadas n�o s�o iguais", null));
		}

		Usuario usuario = usuarioDao.find(matricula);
		validator.onErrorUsePageOf(HomeController.class).primeiroLogin(usuario);

		usuarioDao.alteraSenha(matricula, senhaConfirmada);

		result.redirectTo(TrabalhoController.class).listar();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(HomeController.class).loginForm();
	}

}
