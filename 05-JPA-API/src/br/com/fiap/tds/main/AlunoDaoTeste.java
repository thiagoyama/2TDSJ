package br.com.fiap.tds.main;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.AlunoDao;
import br.com.fiap.tds.dao.impl.AlunoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Periodo;
import br.com.fiap.tds.exception.AlunoNotFoundException;
import br.com.fiap.tds.exception.CommitException;

public class AlunoDaoTeste {

	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Obter uma instânca do AlunoDao
		AlunoDao dao = new AlunoDaoImpl(em);
		
		//Cadastrar um aluno
		Aluno aluno = new Aluno("Paulo", "2TDSJ", Calendar.getInstance(), Periodo.MANHA, true);
		
		try {
			dao.insert(aluno);
			dao.commit();
			System.out.println("Aluno registrado!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um aluno e exibir os dados
		try {
			aluno = dao.findById(3);
			System.out.println(aluno);
		}catch(AlunoNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar um aluno
		aluno = new Aluno(3, "Martin", "2TDSR", Calendar.getInstance(), Periodo.NOITE, true);
		try {
			dao.update(aluno);
			dao.commit();
			System.out.println("Aluno atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um aluno
		try {
			dao.delete(3);
			dao.commit();
			System.out.println("Aluno removido!");
		} catch (AlunoNotFoundException e) {
			System.out.println("Aluno não existe para ser removido");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		//Fechar
		em.close();
		fabrica.close();
	}
	
}