package br.com.tccmanager.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.HibernateUtil;

public class UsuarioDAO {
	
	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}
	
	public Usuario carrega(Usuario usuario) {
	    return (Usuario) getSession().createCriteria(Usuario.class)
	      .add(Restrictions.eq("matricula", usuario.getMatricula()))
	      .add(Restrictions.eq("senha", usuario.getSenha()))
	      .uniqueResult();
	  }

}
