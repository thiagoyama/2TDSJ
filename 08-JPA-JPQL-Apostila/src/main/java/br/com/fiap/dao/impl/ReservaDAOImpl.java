package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscarPorNomeCliente(String nome) {
		return em.createNamedQuery("Reserva.PorNomeCliente", Reserva.class)
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public List<Reserva> buscarPorDescricaoPacote(String descricao) {
		return em.createNamedQuery("Reserva.PorDescricaoPacote", Reserva.class)
				.setParameter("n", "%"+ descricao + "%")
				.getResultList();
	}

}
