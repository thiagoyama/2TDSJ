package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import br.com.fiap.util.DataUtil;

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
		
		//Listar clientes com paginação
		clientes = clienteDao.listar(10, 10);
		System.out.println("Listar clientes com paginação");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar pacotes por preço menor, retornando uma lista de vetor de objetos
		List<Object[]> listaObjetos = pacoteDao.buscarPorPrecoMenor(5000);
		System.out.println("Buscar pacotes por preço menor, retornando uma lista de vetor de objetos");
		listaObjetos.forEach(v -> System.out.println(v[0] + " " + v[1]));
		
		//Pesquisar pacotes por preço menor, retornando uma lista de Pacotes
		List<Pacote> pacotes = pacoteDao.buscarPorPrecoMenor2(5000); 
		System.out.println("Buscar por pacotes com preço menor, retorndo uma lista de pacotes");
		pacotes.forEach(p ->System.out.println(p.getDescricao() + " " + p.getQtdDias() + " " + p.getDataSaida()));
		
		//Pesquisar pacotes por preço menor, retornando uma lista de String
		List<String> listaString = pacoteDao.buscarPorPrecoMenor3(7000);
		System.out.println("Buscar pacotes por preço menor, retornando somente a descrição");
		listaString.forEach(c -> System.out.println(c));
		
		//Pesquisar pacotes por data de saída
		Calendar inicio = new GregorianCalendar(2020, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2021, Calendar.DECEMBER, 30);
		pacotes = pacoteDao.buscarPorDatas(inicio, fim);
		System.out.println("Buscar pacotes por data de saída");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + DataUtil.formatar(p.getDataSaida())));
		
		//Pesquisar cliente por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Salva");
		System.out.println("Buscar clientes por parte do nome e parte do nome da cidade");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome()));
		
		//Pesquisar clientes por estados
		List<String> estados = new ArrayList<>();
		estados.add("BA");
		estados.add("PR");
		clientes = clienteDao.buscarPorEstados(estados);
		System.out.println("Buscar clientes por estados");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Buscar cliente por nome sem case sensitive
		clientes = clienteDao.buscarPorNome2("MARIA");
		System.out.println("Buscar clientes por nome sem case sensitive");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Contar clientes por estado
		long qtd = clienteDao.contarPorEstado("SP");
		System.out.println("Contar os clientes por estado: " + qtd);
		
		//Somar os preços dos pacotes por um transporte 
		transporte = transporteDao.pesquisar(2);
		double soma = pacoteDao.somarPorTransporte(transporte);
		System.out.println("Soma dos preços dos pacotes: " + soma);
		
		//Instanciar uma ReservaDao
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Pesquisar reserva por parte do nome do cliente
		List<Reserva> reservas = reservaDao.buscarPorNomeCliente("o");
		System.out.println("Buscar reservas por parte do nome do cliente");
		//Exibir a data da reserva e o nome do cliente
		reservas.forEach(r -> System.out.println(r.getCliente().getNome() + " " 
		                                                   + DataUtil.formatar(r.getDataReserva())));
		
		//Pesquisar reserva por parte da descrição do pacote
		reservas = reservaDao.buscarPorDescricaoPacote("Porto");
		System.out.println("Buscar reservas por parte da descrição do pacote");
		reservas.forEach(r -> System.out.println(r.getPacote().getDescricao() + " " + r.getCliente().getNome()));
		
		//Pesquisar pacote por qtd de dias e preço
		pacotes = pacoteDao.buscarPorQtdDiasMaiorEPrecoMenor(5, 2100);
		System.out.println("Buscar pacotes por qtd de dias maior e preço menor");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " Qtd: " + p.getQtdDias() + " Preço:" + p.getPreco()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe