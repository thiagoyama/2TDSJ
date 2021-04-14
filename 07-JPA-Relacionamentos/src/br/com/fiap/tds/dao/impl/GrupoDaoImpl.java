package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.entity.Grupo;

public class GrupoDaoImpl 
				extends GenericDaoImpl<Grupo, Integer>
										implements GrupoDao {

	public GrupoDaoImpl(EntityManager em) {
		super(em);
	}

}