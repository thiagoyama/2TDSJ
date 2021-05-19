package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	//Buscar por nome do cliente
	List<Reserva> buscarPorNomeCliente(String nome);
	
	//Buscar por parte da descrição da reserva
	List<Reserva> buscarPorDescricaoPacote(String desc);
	
}
