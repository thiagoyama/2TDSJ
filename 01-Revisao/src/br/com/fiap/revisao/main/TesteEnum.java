package br.com.fiap.revisao.main;

import br.com.fiap.revisao.model.Carro;
import br.com.fiap.revisao.model.Estado;

public class TesteEnum {

	public static void main(String[] args) {
		//Instanciar um Carro
		Carro carro = new Carro("Hyundai", 20000, false);
		
		//Atribuir um valor para o Estado do carro
		carro.setEstado(Estado.NOVO);
		
		//Validar se o carro é NOVO
		if ( carro.getEstado() == Estado.NOVO ) {
			System.out.println("Carro 0 KM");
		}
		
		//Exibir o estado do carro
		System.out.println(carro.getEstado());
	}
	
}
