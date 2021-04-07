package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.PessoaDao;
import br.com.fiap.tds.entity.Pessoa;

public class PessoaDaoImpl extends GenericDaoImpl<Pessoa, Integer> implements PessoaDao {

	public PessoaDaoImpl(EntityManager em) {
		super(em);
	}

}
