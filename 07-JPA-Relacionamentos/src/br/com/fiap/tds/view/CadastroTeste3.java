package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.GrupoDaoImpl;
import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {

	public static void main(String[] args) {
		//Obter um EntityMananger
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um AlunoDao e GrupoDao
		GenericDao<Aluno, Integer> alunoDao = new GenericDaoImpl<Aluno, Integer>(em) {};
		GrupoDao grupoDao = new GrupoDaoImpl(em);
		
		// 1 - Cadastrar um aluno e associar a um grupo que existe no banco
		//Pesquisar um grupo
		
		//Instanciar um aluno com o grupo
		
		//Cadastrar o aluno
		
		
		// 2 - Associar um aluno e um nano course que já existem no banco
		
		//Pesquisar um aluno
		
		//Pesquisar um curso
		
		//Adicionar o curso no aluno
		
		//Atualizar o aluno
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
