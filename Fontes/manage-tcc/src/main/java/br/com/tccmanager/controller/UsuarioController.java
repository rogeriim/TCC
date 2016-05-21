package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.tccmanager.auth.Restrito;
import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Perfil;
import br.com.tccmanager.model.Usuario;

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
