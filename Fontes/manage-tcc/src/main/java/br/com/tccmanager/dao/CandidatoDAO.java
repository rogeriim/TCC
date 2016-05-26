package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.tccmanager.model.Candidato;
import br.com.tccmanager.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class CandidatoDAO {

	private Session session;

	private Session getSession() {
		if (session == null || !session.isOpen()) session = HibernateUtil.
				getSessionFactory().openSession();
		return session;
	}

	public void create(Candidato candidato) {
		getSession().beginTransaction();
		getSession().persist(candidato);
		getSession().getTransaction().commit();
	}

	public List<Candidato> findAll() {
		return getSession().createQuery("from Candidato").list();
	}

	public List<Candidato> findAllByUser(String matricula) {
		return getSession().createQuery("from Candidato where aluno = " + matricula).list();
	}

	public Candidato findByTrabalhoAndMatricula(int id, String matricula) {
		return (Candidato) getSession().createQuery("from Candidato where aluno = " + matricula
				+ " and trabalho = " + id).uniqueResult();
	}

	public List<Candidato> findByTrabalho(int id) {
		return getSession().createQuery("from Candidato where trabalho = " + id).list();
	}
	
	public List<Candidato> findByTrabalhoInteresse(int id) {
		return getSession().createQuery("from Candidato c where c.trabalho = " + id
				+ " and c.status = 'FECHADO' and c.aluno not in ("
				+ "select orientando from Trabalho where status = 'FECHADO')").list();
	}

	public Candidato find(int id) {
		return (Candidato) getSession().createQuery("from Candidato where id = " + id)
				.uniqueResult();
	}

	public Candidato findByPrioridade(String matricula, int prioridade) {
		return (Candidato) getSession().createQuery("from Candidato where aluno = " + matricula 
				+ " and prioridade = " + prioridade).uniqueResult();
	}

	public void remove(int id) {
		Candidato candidato = find(id);
		getSession().beginTransaction();
		getSession().delete(candidato);
		getSession().getTransaction().commit();	
	}

	public void update(Candidato candidato) {
		Candidato c = find(candidato.getId());

		// TODO parametros a serem atualizados..
		c.setPrioridade(candidato.getPrioridade());

		getSession().beginTransaction();
		getSession().update(c);
		getSession().getTransaction().commit();	
	}

}
