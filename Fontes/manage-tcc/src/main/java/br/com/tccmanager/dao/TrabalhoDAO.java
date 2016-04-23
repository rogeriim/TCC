package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Trabalho;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class TrabalhoDAO {
	
	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}
	
	public void create(Trabalho trabalho) {
		getSession().beginTransaction();
		getSession().save(trabalho);
		getSession().getTransaction().commit();
	}
	
	public List<Trabalho> findAll() {
		return getSession().createQuery("from Trabalho").list();
	}
	
	public Trabalho find(int id) {
		return (Trabalho) getSession().createQuery("from Trabalho where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Trabalho trabalho = find(id);
		getSession().beginTransaction();
		getSession().delete(trabalho);
		getSession().getTransaction().commit();	
	}

	public void update(Trabalho trabalho) {
		Trabalho t = find(trabalho.getId());
		t.setTitulo(trabalho.getTitulo());
		
		getSession().beginTransaction();
		getSession().update(t);
		getSession().getTransaction().commit();	
	}

}
