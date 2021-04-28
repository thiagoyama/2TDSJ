package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Grupo;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	public static void main(String[] args) {
		//Obter um EntityMananger
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um AlunoDao e GrupoDao
		GenericDao<Aluno, Integer> alunoDao = new GenericDaoImpl<Aluno, Integer>(em) {};
		GrupoDao grupoDao = new GrupoDaoImpl(em);
		
		// 1 - Cadastrar um aluno e associar a um grupo que existe no banco
		try {
			//Pesquisar um grupo
			Grupo grupo = grupoDao.findById(1);
			
			//Instanciar um aluno com o grupo
			Aluno aluno = new Aluno("Carolina", new GregorianCalendar(2001, Calendar.MARCH, 30), Genero.FEMININO);
			aluno.setGrupo(grupo);
			
			//Cadastrar o aluno
			alunoDao.insert(aluno);
			alunoDao.commit();
			System.out.println("Aluno registrado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		// 2 - Associar um aluno e um nano course que já existem no banco
		GenericDao<NanoCourse,Integer> nanoDao = new GenericDaoImpl<NanoCourse,Integer>(em){};
		try {
			//Pesquisar um aluno
			Aluno aluno = alunoDao.findById(4);
			
			//Pesquisar um curso
			NanoCourse curso = nanoDao.findById(1);
			
			//Adicionar o curso no aluno
			aluno.getCursos().add(curso);
			
			//Atualizar o aluno
			alunoDao.update(aluno);
			alunoDao.commit();
			System.out.println("Aluno matriculado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
