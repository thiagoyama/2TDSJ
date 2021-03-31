package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.VacinaDao;
import br.com.fiap.tds.entity.Vacina;

public class VacinaDaoImpl 
			extends GenericDaoImpl<Vacina, Integer> implements VacinaDao {

	public VacinaDaoImpl(EntityManager em) {
		super(em);
	}

}