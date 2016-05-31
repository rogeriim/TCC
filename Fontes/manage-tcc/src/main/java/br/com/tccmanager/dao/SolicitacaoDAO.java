package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Solicitacao;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class SolicitacaoDAO {
	
	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}
	
	public void create(Solicitacao solicitacao) {
		getSession().beginTransaction();
		getSession().persist(solicitacao);
		getSession().getTransaction().commit();
	}
	
	public List<Solicitacao> findAll() {
		return getSession().createQuery("from Solicitacao").list();
	}
	
	public List<Solicitacao> findAllByCriador(String matricula) {
		return getSession().createQuery("from Solicitacao where abertoPor = " + matricula).list();
	}
	
	public List<Solicitacao> findAllByProfessor(String matricula) {
		return getSession().createQuery("from Solicitacao where professor = " + matricula).list();
	}
	
	public Solicitacao find(int id) {
		return (Solicitacao) getSession().createQuery("from Solicitacao where id = " + id)
				.uniqueResult();
	}

	public void remove(int id) {
		Solicitacao solicitacao = find(id);
		getSession().beginTransaction();
		getSession().delete(solicitacao);
		getSession().getTransaction().commit();	
	}

	public void update(Solicitacao solicitacao) {
		Solicitacao s = find(solicitacao.getId());

		// TODO parametros a serem atualizados
		
		getSession().beginTransaction();
		getSession().update(s);
		getSession().getTransaction().commit();	
	}

}
