package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Perfil;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class PerfilDAO {
	
	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}
	
	public void create(Perfil perfil) {
		getSession().beginTransaction();
		getSession().save(perfil);
		getSession().getTransaction().commit();
	}
	
	public List<Perfil> findAll() {
		return getSession().createQuery("from Perfil").list();
	}
	
	public Perfil find(int id) {
		return (Perfil) getSession().createQuery("from Perfil where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Perfil perfil = find(id);
		getSession().beginTransaction();
		getSession().delete(perfil);
		getSession().getTransaction().commit();	
	}

	public void update(Perfil perfil) {
		Perfil p = find(perfil.getId());
		p.setPerfil(perfil.getPerfil());
		
		getSession().beginTransaction();
		getSession().update(p);
		getSession().getTransaction().commit();	
	}

}
