package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tccmanager.model.Usuario;
import br.com.tccmanager.util.CriptografiaUtil;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
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

	public void create(Usuario usuario) {
		getSession().beginTransaction();
		usuario.setPrimeiroAcesso(true);
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

		usuario.setSenha(CriptografiaUtil.criptografar(novaSenha));
		usuario.setPrimeiroAcesso(false);

		getSession().beginTransaction();
		getSession().update(usuario);
		getSession().getTransaction().commit();	
	}

	public List<Usuario> findAll() {
		return getSession().createQuery("from Usuario").list();
	}

	public List<Usuario> findAllByPerfil(String perfil) {
		if (perfil.equalsIgnoreCase("PROFESSOR"))
			return getSession().createQuery("from Usuario where perfil_id in "
					+ "(select id from Perfil where perfil in ('" + perfil + "' , 'ADMINISTRADOR'))").list();
		else return getSession().createQuery("from Usuario where perfil_id = "
				+ "(select id from Perfil where perfil = " + perfil + ")").list();
	}

	public List<Usuario> findAllProfessorSolicitacaoBanca(String matricula, int bancaId) {
		return getSession().createQuery("from Usuario where perfil_id in "
				+ "(select id from Perfil where perfil in ('PROFESSOR' , 'ADMINISTRADOR'))"
				+ " and matricula not in (select professor from Solicitacao where banca_id = " + bancaId + ") "
				+ "and matricula != '" + matricula + "'").list();
	}

	public void remove(String matricula) {
		Usuario usuario = find(matricula);
		getSession().beginTransaction();
		getSession().delete(usuario);
		getSession().getTransaction().commit();	
	}

	public void update(Usuario usuario) {
		Usuario user = find(usuario.getMatricula());

		user.setEmail(usuario.getEmail());
		user.setNome(usuario.getNome());

		getSession().beginTransaction();
		getSession().update(user);
		getSession().getTransaction().commit();	
	}

}
