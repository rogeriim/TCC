package br.com.tccmanager.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.CriptografiaUtil;
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
				.add(Restrictions.eq("senha", CriptografiaUtil.criptografar(usuario.getSenha())))
				.uniqueResult();
	}

	// TODO criptografar a senha antes de gravar no banco.
	public void create(Usuario usuario) {
		getSession().beginTransaction();
		getSession().persist(usuario);
		getSession().getTransaction().commit();
	}

	public Usuario find(String matricula) {
		return (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("matricula", matricula))
				.uniqueResult();
	}
	
	public void alteraSenha(String matricula, String novaSenha) {
		Usuario usuario = find(matricula);
		usuario.setSenha(novaSenha);
		
		getSession().beginTransaction();
		getSession().update(usuario);
		getSession().getTransaction().commit();	
	}


}
