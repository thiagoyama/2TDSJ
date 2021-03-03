package br.com.fiap.revisao.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.revisao.model.Veiculo;

public class TesteColecao {

	public static void main(String[] args) {
		
		//Instanciar uma lista de veiculo
		List<Veiculo> lista = new ArrayList<Veiculo>();
		
		//Adicionar dois veiculos na lista
		lista.add(new Veiculo("Toyota", 1999, false));
		
		Veiculo veiculo = new Veiculo("Ford", 2018, true);
		lista.add(veiculo);
		
		//Exibir os veiculos da lista
		for (int i = 0; i < lista.size(); i++ ) {
			System.out.println(lista.get(i).getMarca() + " " 
											+ lista.get(i).getAno());
		}
		
		//Foreach
		for (Veiculo v : lista) {
			System.out.println(v);
			//System.out.println(v.getMarca() + " " + v.getAno());
		}
		
		lista.forEach(v -> System.out.println(v.getMarca() + " " + v.getAno()));
		
		//Mapa
		Map<String,Veiculo> mapa = new HashMap<String, Veiculo>();
		
		//Adicionar dois veiculos no mapa
		mapa.put("Martin", new Veiculo("Bmw", 2018, false));
		mapa.put("Gustavo", new Veiculo("Fiat", 2010, false));
		
		//Recuperar o veiculo através da chave
		veiculo = mapa.get("Martin");
		System.out.println(veiculo.getMarca() + " " + veiculo.getAno());
				
	}
	
}
