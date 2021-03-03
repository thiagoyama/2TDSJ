package br.com.fiap.revisao.main;

import br.com.fiap.revisao.model.Carro;
import br.com.fiap.revisao.model.Veiculo;

public class TesteMetodos {

	public static void main(String[] args) {
		//Instanciar um veiculo
		Veiculo veiculo = new Veiculo("Hyundai", 2020, true);
		
		//Chamar o método frear() do veiculo
		veiculo.frear(); // Veiculo
		
		//Instanciar um carro
		Carro carro = new Carro();
		
		//Chamar o método frear() do carro
		carro.frear(); // Carro
		
		Veiculo v = new Carro();
		
		v.frear(); // Carro
		
		//Carro c = new Veiculo(); //Não compila
		
	}
	
}
