package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {
	
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma CidadeDAO
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Pesquisar por todas as cidades
		List<Cidade> cidades = cidadeDao.listar();
		
		//Exibir todas as cidades cadastradas
		System.out.println("Lista das cidades:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar por cidades de ddd 11
		cidades = cidadeDao.buscarPorDdd(11);
		
		//Exibir as cidades de ddd 11
		System.out.println("Buscar cidades por ddd:");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome() + " " + cidade.getDdd());
		}
		
		//Instanciar um ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Pesquisar todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		
		//Exibir todos os clientes
		System.out.println("Listar todos os clientes:");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar os clientes por parte do nome
		System.out.println("Buscar cliente por parte do nome:");
		clienteDao.buscarPorNome("Le").forEach(c -> System.out.println(c.getNome()));
		
		//Instanciar um PacoteDAO e TransporteDAO
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Pesquisar o Transporte
		Transporte transporte = transporteDao.pesquisar(3);
		
		//Pesquisar e exibir os pacotes que possuem o transporte
		System.out.println("Buscar pacotes por transporte:");
		pacoteDao.buscarPorTransporte(transporte).forEach(p -> 
			System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//Pesquisar os clientes do estado do PR
		System.out.println("Buscar clientes por estado:");
		clienteDao.buscarPorEstado("BA").forEach(c -> 
			System.out.println(c.getNome() + " - " + c.getEndereco().getCidade().getUf()));
		
		//Pesquisar clientes por dias de reserva
		System.out.println("Buscar clientes por dias de reserva:");
		clienteDao.buscarPorDiasReserva(10).forEach(c -> 
			System.out.println(c.getNome()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe