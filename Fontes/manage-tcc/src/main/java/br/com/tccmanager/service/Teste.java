package br.com.tccmanager.service;

import java.util.List;

import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.model.Perfil;

public class Teste {
	
	public static void main(String[] args) {
		
		PerfilDAO dao = new PerfilDAO();
		List<Perfil> listPerfil = dao.findAll();
		
		if (listPerfil != null) {
		for (int i = 0; i < listPerfil.size(); i++) {
			System.out.println("Perfil encontrado: " + listPerfil.get(i).getPerfil());
			}
		}
		
		System.out.println("Perfil com id igual a 1: " + dao.find(1).getPerfil());
		
		System.out.println("Atualizando perfil de id igual a 1..");
		
		Perfil perfil = new Perfil();
		perfil.setId(1);
		perfil.setPerfil("Orientando");
		dao.update(perfil);
		
		System.out.println("Perfil com id igual a 1: " + dao.find(1).getPerfil());
		
		System.out.println("Removendo perfil de id igual a 1..");
		dao.remove(1);
		
		listPerfil = dao.findAll();
		if (listPerfil != null) {
			for (int i = 0; i < listPerfil.size(); i++) {
				System.out.println("Perfil encontrado: " + listPerfil.get(i).getPerfil());
			}
		}

	}

}
