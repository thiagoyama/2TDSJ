package br.com.fiap.tds.view;

import java.util.Calendar;
import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;
import br.com.fiap.tds.entity.Pedido;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		//Cadastrar todas as entidades
		
		//Obter um EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um ItemPedidoDao
		ItemPedidoDao itemDao = new ItemPedidoDaoImpl(em);
		
		//Instanciar um produto
		Produto produto = new Produto("Coca Zero");
		
		//Instanciar um pedido
		Pedido pedido = new Pedido(Calendar.getInstance());
		
		//Instanciar um item pedido com o produto e pedido
		ItemPedido item = new ItemPedido(pedido,produto, 5.0, 1);
		
		//Cadastrar o item
		try {
			itemDao.insert(item);
			itemDao.commit();
			System.out.println("Produto, item e pedido cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Buscar um item pela PK
			ItemPedidoPK pk = new ItemPedidoPK(1, 1, 1);
			ItemPedido busca = itemDao.findById(pk);
			System.out.println(busca.getProduto().getNome() + " " + busca.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
