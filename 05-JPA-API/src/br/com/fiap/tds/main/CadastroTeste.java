package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Periodo;

public class CadastroTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um novo aluno sem o código (Estado: new - não gerenciado)
		Aluno aluno = new Aluno("Gabriel", "2TDSJ", 
				new GregorianCalendar(2000, Calendar.JULY, 10), Periodo.MANHA, true);
		
		//Adiciona o aluno no contexto do Entity Manager (gerencia-lo)
		em.persist(aluno);
		
		//Começar uma transação
		em.getTransaction().begin();
		//Realizar o commit
		em.getTransaction().commit();
		
		System.out.println("Aluno registrado!");
		
		//Objeto gerenciado, será atualizado no banco após o commit
		aluno.setNome("Martin");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}