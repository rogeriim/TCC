package br.com.tccmanager.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.tccmanager.model.Trabalho;
import br.com.tccmanager.util.HibernateUtil;

@Component
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
		getSession().persist(trabalho);
		getSession().getTransaction().commit();
	}

	public List<Trabalho> findAll() {
		return getSession().createQuery("from Trabalho").list();
	}

	public List<Trabalho> findAllDisponiveis() {
		return getSession().createQuery("from Trabalho where status = 'ABERTO'").list();
	}

	public List<Trabalho> findAllByProfessor(String matricula) {
		return getSession().createQuery("from Trabalho where orientador = " + matricula).list();
	}

	public Trabalho find(int id) {
		return (Trabalho) getSession().createQuery("from Trabalho where id = " + id)
				.uniqueResult();
	}

	public List<Trabalho> findTrabalhosDisponiveis() {
		return getSession().createQuery("from Trabalho where status = 'ABERTO'").list();
	}

	public List<Trabalho> findTrabalhosDisponiveisCandidatura(String matricula) {
		return getSession().createQuery("from Trabalho where status = 'ABERTO' and id not in "
				+ "(select trabalho from Candidato where aluno = " + matricula + ")").list();
	}

	public Trabalho findTrabalhosDisponiveisCandidatura(int id, String matricula) {
		return (Trabalho) getSession().createQuery("from Trabalho where id = " + id 
				+ " status = 'ABERTO' and id not in "
				+ "(select trabalho from Candidato where aluno = " + matricula + ")").uniqueResult();
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
		t.setDescricao(trabalho.getDescricao());
		t.setTema(trabalho.getTema());
		t.setOrientando(trabalho.getOrientando());

		getSession().beginTransaction();
		getSession().update(t);
		getSession().getTransaction().commit();	
	}

}
