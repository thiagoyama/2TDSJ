package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.model.Carro;

public class CarroOracleDao implements CarroDao {

	@Override
	public void cadastrar(Carro carro) {
		System.out.println("Cadastrando no oracle...");
	}

	@Override
	public List<Carro> listar() {
		System.out.println("Listando do oracle..");
		return null;
	}
	
}
