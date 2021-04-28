package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar um Sistema com o nome
		Sistema sistema = new Sistema("Fiap Challenge");
		
		//Instanciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Entrega da challenge", "Entrega dos arquivos pelos alunos");
		CasoTeste caso2 = new CasoTeste("Publicação de notas", "Publicação de notas para os alunos");
		
		//Adicionar os casos de teste no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		//Instanciar 3 itens de teste com a descrição
		ItemTeste item1 = new ItemTeste("Upload de arquivo com sucesso com mais de 100mb");
		ItemTeste item2 = new ItemTeste("Não permitir upload de arquivo com 0 bytes");
		ItemTeste item3 = new ItemTeste("Publicação das notas dos alunos quando todos os profs lancarem as notas");
		
		//Adicionar 2 itens no primeiro caso de teste e 1 item no segundo
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Instanciar 2 usuários
		Usuario user1 = new Usuario("Martin");
		Usuario user2 = new Usuario("Christian");
		
		//Criar uma lista de usuários e adicioná-los
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(user1);
		usuarios.add(user2);
		
		//Setar a lista de usuários em alguns dos itens de teste
		item1.setUsuarios(usuarios);
		item3.setUsuarios(usuarios);
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um SistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Cadastrar um sistema
			dao.insert(sistema);
			//Commit
			dao.commit();
			System.out.println("Deu bom!");
		} catch (CommitException e ) {
			System.out.println("Deu ruim..");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe
