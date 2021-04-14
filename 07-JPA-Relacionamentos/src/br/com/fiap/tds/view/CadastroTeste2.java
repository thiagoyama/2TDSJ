package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GrupoDao;
import br.com.fiap.tds.dao.ProjetoDao;
import br.com.fiap.tds.dao.impl.GrupoDaoImpl;
import br.com.fiap.tds.dao.impl.ProjetoDaoImpl;
import br.com.fiap.tds.entity.Grupo;
import br.com.fiap.tds.entity.Projeto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste2 {

	// Cadastrar através do projeto
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
		
		//Setar o grupo do projeto
		projeto.setGrupo(grupo);
		
		//Cadastrar um projeto
		projetoDao.insert(projeto);
		
		//Cadastrar um grupo
		//grupoDao.insert(grupo);
		
		//Commit
		try {
			projetoDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
