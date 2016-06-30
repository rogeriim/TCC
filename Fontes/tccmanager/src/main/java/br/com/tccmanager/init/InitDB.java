package br.com.tccmanager.init;

import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.dao.UsuarioDAO;
import br.com.tccmanager.model.Perfil;
import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.CriptografiaUtil;

public class InitDB {

	public static void initDB() {

		PerfilDAO dao = new PerfilDAO();

		if (dao.findAll().size() < 1) {
			System.out.println("Inicializando base de dados.. Criando tabelas..");

			Perfil perfil = new Perfil();

			perfil.setPerfil("ADMINISTRADOR");

			System.out.println("Inserindo perfil ADMINISTRADOR.");
			dao.create(perfil);

			UsuarioDAO userDao = new UsuarioDAO();
			Usuario usuario = new Usuario();

			usuario.setMatricula("1");
			usuario.setSenha(CriptografiaUtil.criptografar("admin123"));
			usuario.setPrimeiroAcesso(true);
			usuario.setNome("Administrador");
			usuario.setEmail("rogeriocustodio@live.com");
			usuario.setPerfil(perfil);

			System.out.println("Inserindo usuario ADMINISTRADOR.");
			userDao.create(usuario);

		}

		/*
		if (listPerfil != null) {
		for (int i = 0; i < listPerfil.size(); i++) {
			System.out.println("Perfil encontrado: " + listPerfil.get(i).getPerfil());
			}
		}

		int position = listPerfil.get(listPerfil.size() - 1).getId();

		System.out.println("Perfil com id igual a " + position + 
				": " + dao.find(position).getPerfil());

		System.out.println("Atualizando perfil de id igual a " + position);
		perfil.setPerfil("ORIENTANDO");
		dao.update(perfil);

		System.out.println("Perfil com id igual a " + position + 
				": " + dao.find(position).getPerfil());

		System.out.println("Removendo perfil de id igual a " + position);
		dao.remove(position);

		listPerfil = dao.findAll();
		if (listPerfil != null) {
			for (int i = 0; i < listPerfil.size(); i++) {
				System.out.println("Perfil encontrado: " + listPerfil.get(i).getPerfil());
			}
		}
		 */

	}

}
