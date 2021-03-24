package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Periodo;

public class AtualizacaoTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um Aluno com código que existe no banco (Estado: detached)
		Aluno aluno = new Aluno(1, "Pedro", "2TDSA", 
				new GregorianCalendar(2000, Calendar.DECEMBER, 10),
				Periodo.NOITE, false);
		
		Aluno alunoGerenciado = em.merge(aluno);
		
		//alunoGerenciado.setAtivo(true);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
