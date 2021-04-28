package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Busca {
	
	public static void main(String[] args) {
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um sistemaDao
		SistemaDao dao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema
			Sistema sistema = dao.findById(1);
	
			//Exibir o nome do sistema
			System.out.println("Sistema: " + sistema.getNome());
			
			//Exibir os casos de teste do sistema
			for (CasoTeste caso : sistema.getCasos()) {
				System.out.println("\nCaso de Teste: " + caso.getNome());
				
				//Exibir os itens de teste do caso de teste
				for (ItemTeste item : caso.getItensTeste()) {
					System.out.println("\nItem de Teste: " + item.getDescricao());
					
					//Exibir os usuários que testaram os itens de teste
					System.out.println("Usuários:");
					for (Usuario usuario : item.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
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
