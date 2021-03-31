package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.AlunoDao;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.exception.AlunoNotFoundException;
import br.com.fiap.tds.exception.CommitException;

// View - Controller - DAO - Banco

public class AlunoDaoImpl implements AlunoDao {

	private EntityManager em;
	
	public AlunoDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void insert(Aluno aluno) {
		em.persist(aluno);
	}

	@Override
	public Aluno findById(int codigo) throws AlunoNotFoundException {
		Aluno aluno = em.find(Aluno.class, codigo);
		if (aluno == null) {
			throw new AlunoNotFoundException();
		}
		return aluno;
	}

	@Override
	public void delete(int codigo) throws AlunoNotFoundException {
		Aluno aluno = findById(codigo);
		em.remove(aluno);
	}

	@Override
	public void update(Aluno aluno) {
		em.merge(aluno);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}
	
}
