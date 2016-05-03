package br.com.tccmanager.service;

import java.util.List;

import br.com.tccmanager.dao.PerfilDAO;
import br.com.tccmanager.model.Perfil;

public class Teste {
	
	public static void main(String[] args) {
				
		PerfilDAO dao = new PerfilDAO();
		Perfil perfil = new Perfil();
		List<Perfil> listPerfil = dao.findAll();
		
		System.out.println("Inserindo perfil.");
		perfil.setPerfil("ALUNO");
		
		dao.create(perfil);
		
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

	}

}
