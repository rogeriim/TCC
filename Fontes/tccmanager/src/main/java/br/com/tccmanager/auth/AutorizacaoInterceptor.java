package br.com.tccmanager.auth;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.tccmanager.controller.HomeController;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor{

	private final UsuarioWeb usuario;
	private final Result result;

	public AutorizacaoInterceptor(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}
	
	public boolean accepts(ResourceMethod method) {
		return !usuario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	public void intercept(InterceptorStack arg0, ResourceMethod arg1,
			Object arg2) throws InterceptionException {
		result.redirectTo(HomeController.class).loginForm();
	}
}
