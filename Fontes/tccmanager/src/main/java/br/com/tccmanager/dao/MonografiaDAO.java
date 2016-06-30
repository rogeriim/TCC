package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Monografia;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class MonografiaDAO {

	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}

	public void create(Monografia monografia) {
		getSession().beginTransaction();
		getSession().persist(monografia);
		getSession().getTransaction().commit();
	}

	public List<Monografia> findAll() {
		return getSession().createQuery("from Monografia").list();
	}

	public Monografia find(int id) {
		return (Monografia) getSession().createQuery("from Monografia where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Monografia monografia = find(id);
		getSession().beginTransaction();
		getSession().delete(monografia);
		getSession().getTransaction().commit();	
	}

	public void update(Monografia monografia) {
		Monografia m = find(monografia.getId());

		m.setResumo(monografia.getResumo());

		getSession().beginTransaction();
		getSession().update(m);
		getSession().getTransaction().commit();	
	}

}
