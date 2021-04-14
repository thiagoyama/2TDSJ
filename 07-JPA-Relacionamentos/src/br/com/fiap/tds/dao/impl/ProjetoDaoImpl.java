package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ProjetoDao;
import br.com.fiap.tds.entity.Projeto;

public class ProjetoDaoImpl extends GenericDaoImpl<Projeto, Integer> implements ProjetoDao {

	public ProjetoDaoImpl(EntityManager em) {
		super(em);
	}

}
