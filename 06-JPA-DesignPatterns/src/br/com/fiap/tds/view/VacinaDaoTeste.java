package br.com.fiap.tds.view;

import java.util.Calendar;
import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.VacinaDao;
import br.com.fiap.tds.dao.impl.VacinaDaoImpl;
import br.com.fiap.tds.entity.Vacina;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class VacinaDaoTeste {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma VacinaDao
		VacinaDao dao = new VacinaDaoImpl(em);
		
		//Cadastrar
		Vacina vacina = new Vacina("Coronavac", true, Calendar.getInstance(), "Butantan");
		try {
			dao.insert(vacina);
			dao.commit();
			System.out.println("Vacina cadastrada!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar e exibir os dados
		try {
			vacina = dao.findById(1);
			System.out.println(vacina.getNome() + " " + vacina.getFabricante());
		} catch(EntityNotFoundException e) {
			System.out.println("Vacina não encontrada!");
		}
		
		//Atualizar
		vacina = new Vacina(1, "Fiapcina", true, Calendar.getInstance(), "FIAP");
		try {
			dao.update(vacina);
			dao.commit();
			System.out.println("Vacina atualizada!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Vacina removida!");
		} catch(CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}