package br.com.tccmanager.controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.tccmanager.dao.TrabalhoDAO;
import br.com.tccmanager.model.Trabalho;

@Resource
public class TrabalhoController {

	private TrabalhoDAO dao;

	public TrabalhoController(TrabalhoDAO dao) {
		this.dao = dao;
	}

	public List<Trabalho> listAll() {
		return dao.findAll();
	}

}
