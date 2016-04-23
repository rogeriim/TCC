package br.com.tccmanager.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class HelloWorld {

	public List<String> boasVindas() {
		List<String> listString = new ArrayList<String>();

		listString.add("String 1");
		listString.add("String 2");
		listString.add("String 3");
		listString.add("String 4");

		return listString;
	}

}
