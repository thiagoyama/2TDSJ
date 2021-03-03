package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.model.Carro;

public interface CarroDao {

	void cadastrar(Carro carro);
	
	List<Carro> listar();
	
}