package br.com.tccmanager.auth;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.tccmanager.model.Usuario;

@Component
@SessionScoped
public class UsuarioWeb {

	private Usuario logado;

	public void login(Usuario usuario) {
		this.logado = usuario;
	}
	
	public String getMatricula() {
		return logado.getMatricula();
	}

	public String getNome() {
		return logado.getNome();
	}

	public String getPerfil() {
		return logado.getPerfil().getPerfil();
	}

	public boolean isLogado() {
		return logado != null;
	}

	public boolean isPrimeiroAcesso() {
		return logado.isPrimeiroAcesso();
	}

	public boolean isAdministrador() {
		return logado.getPerfil().getPerfil().equalsIgnoreCase("ADMINISTRADOR");
	}
	
	public boolean isAluno() {
		return logado.getPerfil().getPerfil().equalsIgnoreCase("ALUNO");
	}
	
	public boolean isProfessor() {
		return logado.getPerfil().getPerfil().equalsIgnoreCase("PROFESSOR");
	}

	public void logout() {
		logado = null;
	}

}
