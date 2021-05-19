package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {
	
	//2 - Buscar por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//4 - Buscar por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//5 - Buscar por quantidade de dias de reserva
	List<Cliente> buscarPorDiasReserva(int dias);
	
	//2 - Buscar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//3 - Buscar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	// Buscar por parte do nome, sem diferenciar maiúsculas e minúsculas, ordenado por nome
	List<Cliente> buscarPorNome2(String nome);
	
	// Contar por estado
	long contarPorEstado(String estado);

}