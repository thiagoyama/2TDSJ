package br.com.fiap.revisao.dao;

import java.util.List;

import br.com.fiap.revisao.model.Carro;

public class CarroMySqlDao implements CarroDao{

	@Override
	public void cadastrar(Carro carro) {
		System.out.println("Cadastrando no MySql...");
	}

	@Override
	public List<Carro> listar() {
		System.out.println("Listando do MySql...");
		return null;
	}

}
