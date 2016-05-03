package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Tema;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class TemaDAO {
	
	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}
	
	public void create(Tema tema) {
		getSession().beginTransaction();
		getSession().persist(tema);
		getSession().getTransaction().commit();
	}
	
	public List<Tema> findAll() {
		return getSession().createQuery("from Tema").list();
	}
	
	public Tema find(int id) {
		return (Tema) getSession().createQuery("from Tema where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Tema tema = find(id);
		getSession().beginTransaction();
		getSession().delete(tema);
		getSession().getTransaction().commit();	
	}

	public void update(Tema tema) {
		Tema p = find(tema.getId());
		p.setTema(tema.getTema());
		
		getSession().beginTransaction();
		getSession().update(p);
		getSession().getTransaction().commit();	
	}

}
