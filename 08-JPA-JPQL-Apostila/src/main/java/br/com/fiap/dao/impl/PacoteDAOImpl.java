package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :t", Pacote.class)
				.setParameter("t", transporte)
				.getResultList();
	}

}
