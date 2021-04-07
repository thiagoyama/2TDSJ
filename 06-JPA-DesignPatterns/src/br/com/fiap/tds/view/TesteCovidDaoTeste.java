package br.com.fiap.tds.view;

import java.util.Calendar;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.TesteCovid;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class TesteCovidDaoTeste {

	public static void main(String[] args) {
		
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um Dao genérico para o Teste Covid
		//Intanciar uma classe anônima -> define uma classe que é filha da GenericDaoImpl e intancia
		GenericDao<TesteCovid, Integer> dao = new GenericDaoImpl<TesteCovid, Integer>(em) {};
		
		//Cadastrar
		TesteCovid teste = new TesteCovid("PRC", Calendar.getInstance(), null);
		try {
			dao.insert(teste);
			dao.commit();
			System.out.println("Teste registrado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar
		try {
			teste = dao.findById(1);
			System.out.println(teste.getTipo() + " " + teste.isResultado());
		} catch (EntityNotFoundException e) {
			System.out.println("Teste não encontrado");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}