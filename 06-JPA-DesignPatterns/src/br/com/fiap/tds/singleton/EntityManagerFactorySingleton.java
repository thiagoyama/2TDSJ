package br.com.fiap.tds.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gerenciar a única instância da fabrica - EntityManagerFactory 
 *
 */
public class EntityManagerFactorySingleton {

	// 1 - Atributo estático que armazena a única instância
	private static EntityManagerFactory fabrica;
	
	
	// 2 - Método estático que retorna a única instância
	public static EntityManagerFactory getInstance() {
		
		//validar se a fabrica já foi instanciada
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
	
	// 3 - Construtor privado -> ninguem consegue instanciar a singleton
	private EntityManagerFactorySingleton() {}
	
}