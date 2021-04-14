package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.dao.ProjetoDao;
import br.com.fiap.tds.dao.impl.GrupoDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Grupo;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.entity.Projeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	//Cadastrar através do grupo
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um GrupoDao e ProjetoDao
		ProjetoDao projetoDao = new ProjetoDaoImpl(em);
		GrupoDao grupoDao = new GrupoDaoImpl(em);
		
		//Instanciar um projeto
		Projeto projeto = new Projeto("IOT para mudar vidas", Calendar.getInstance(), 
				new GregorianCalendar(2021, Calendar.OCTOBER, 10));
		
		//Instanciar um grupo com o projeto
		Grupo grupo = new Grupo("Devs Fiap", projeto);
		
		//Cadastrar um projeto
		//projetoDao.insert(projeto);
		
		//Instanciar 3 alunos e adiciona-los no grupo
		Aluno aluno1 = new Aluno("Christian", 
				new GregorianCalendar(1999, Calendar.APRIL, 10), Genero.MASCULINO);
		
		Aluno aluno2 = new Aluno("Gabriel",
				new GregorianCalendar(2000, Calendar.AUGUST, 2), Genero.MASCULINO);
		
		Aluno aluno3 = new Aluno("Gustavo",
				new GregorianCalendar(2001, Calendar.DECEMBER, 20), Genero.MASCULINO);
				
		grupo.addAluno(aluno1);
		grupo.addAluno(aluno2);
		grupo.addAluno(aluno3);
		
		//Cadastrar os cursos relacionados com alunos 
		//Instanciar os nanos
		NanoCourse nano1 = new NanoCourse("Java", 10, 40, "JPA Top");
		NanoCourse nano2 = new NanoCourse("Phyton", 10, 50, "BI");
		NanoCourse nano3 = new NanoCourse("Wordpress", 10, 40, "Sites");
		
		//Criar uma lista de nano e adicionar os cursos
		List<NanoCourse> nanos = new ArrayList<>();
		nanos.add(nano1);
		nanos.add(nano2);
		nanos.add(nano3);
		
		//Adicionar os cursos nos alunos
		aluno1.setCursos(nanos);
		aluno2.setCursos(nanos);
		
		//Cadastrar um grupo
		grupoDao.insert(grupo);
		
		//Commit
		try {
			grupoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
