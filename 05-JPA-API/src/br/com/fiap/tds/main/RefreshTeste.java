package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Periodo;

public class RefreshTeste {

	//Atualiza os dados do banco no objeto
	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um aluno de código 1
		Aluno aluno = em.find(Aluno.class, 1);
		
		//Exibir os dados
		System.out.println(aluno);
		
		//Alterar os valores nome e período no objeto
		aluno.setNome("Gustavo");
		aluno.setPeriodo(Periodo.TARDE);
		
		//Exibir os dados
		System.out.println(aluno);
		
		//Refresh
		em.refresh(aluno);
		
		//Exibir os dados
		System.out.println(aluno);
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
