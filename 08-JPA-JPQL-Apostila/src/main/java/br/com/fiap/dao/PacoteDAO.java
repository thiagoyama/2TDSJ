package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer>{

	//3 - Pesquisar pacotes por um transporte (Objeto Transporte)
	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	// Pesquisar pacotes por preço menor, retornando a descrição e qtd de dias em um vetor de objetos
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	// Pesquisar pacotes por preço menor, retornando a descrição e qtd de dias em um objeto Pacote
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	// Pesquisar pacote por preço menor, retornando a descrição em uma String
	List<String> buscarPorPrecoMenor3(float preco);
	
	// 1 - Pesquisar por data de saída
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
}
