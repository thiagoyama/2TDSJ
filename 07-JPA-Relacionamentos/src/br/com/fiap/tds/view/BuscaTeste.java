package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.dao.ProjetoDao;
import br.com.fiap.tds.dao.impl.GrupoDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.entity.Grupo;
import br.com.fiap.tds.entity.NanoCourse;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {
	
	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um projetoDao
		ProjetoDao dao = new ProjetoDaoImpl(em);
		GrupoDao grupoDao = new GrupoDaoImpl(em);
		
		try {
			//Pesquisar o Projeto de código 1
			//Projeto projeto = dao.findById(1);
			Grupo grupo = grupoDao.findById(4);
			
			//Exibir o nome do projeto
			//System.out.println(projeto.getNome());
			System.out.println(grupo.getNome());
			
			//Exibir o nome do grupo
			//System.out.println(projeto.getGrupo().getNome());
			System.out.println(grupo.getProjeto().getNome());
			
			//Exibir o nome dos alunos do grupo e exibir o nome dos cursos do aluno
			for (Aluno aluno : grupo.getAlunos()) {
				System.out.println(aluno.getNome());
				//Exibir o nome dos cursos do aluno
				for (NanoCourse nano : aluno.getCursos()) {
					System.out.println(nano.getNome());
				}
			}
			
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
