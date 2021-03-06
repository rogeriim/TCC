package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tccmanager.model.Banca;
import br.com.tccmanager.util.HibernateUtil;

@Component
@SuppressWarnings("unchecked")
public class BancaDAO {

	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}

	public void create(Banca banca) {
		getSession().beginTransaction();
		getSession().persist(banca);
		getSession().getTransaction().commit();
	}

	public List<Banca> findAll() {
		return getSession().createQuery("from Banca").list();
	}

	public List<Banca> findAllByCriador(String matricula) {
		return getSession().createQuery("from Banca where criadoPor = " + matricula).list();
	}

	public Banca find(int id) {
		return (Banca) getSession().createQuery("from Banca where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Banca banca = find(id);
		getSession().beginTransaction();
		getSession().delete(banca);
		getSession().getTransaction().commit();	
	}

	public void update(Banca banca) {
		Banca b = find(banca.getId());

		// TODO parametros a serem atualizados;
		if (banca.getData() != null)
			b.setData(banca.getData());
		if (banca.getStatus() != null)
			b.setStatus(banca.getStatus());
		b.setAvaliador1(banca.getAvaliador1());
		b.setAvaliador2(banca.getAvaliador2());

		getSession().beginTransaction();
		getSession().update(b);
		getSession().getTransaction().commit();	
	}

}

