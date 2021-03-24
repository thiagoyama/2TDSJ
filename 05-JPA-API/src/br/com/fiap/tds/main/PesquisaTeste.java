package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.tds.entity.Aluno;

public class PesquisaTeste {

	public static void main(String[] args) {
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Pesquisar um aluno pela PK (codigo)
		Aluno aluno = em.find(Aluno.class, 1);
		
		//Exibir os dados do aluno
		System.out.println(aluno);
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}