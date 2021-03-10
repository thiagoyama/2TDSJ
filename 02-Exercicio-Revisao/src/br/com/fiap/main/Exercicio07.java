package br.com.fiap.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.TipoConta;

public class Exercicio07 {

	public static void main(String[] args) {
		//Criar um lista de conta corrente
		List<ContaCorrente> lista = new ArrayList<>();
		
		//Adicionar 3 contas na lista
		lista.add(new ContaCorrente(1, 23, Calendar.getInstance(), 100, TipoConta.COMUM));
		lista.add(new ContaCorrente(1, 234, Calendar.getInstance(), 200, TipoConta.PREMIUM));
		lista.add(new ContaCorrente(1, 344, Calendar.getInstance(), 600, TipoConta.ESPECIAL));
		
		//Exibir o saldo das contas
		for (ContaCorrente c: lista) {
			System.out.println(c.getSaldo());
		}
		
		lista.forEach(churros -> System.out.println(churros.getSaldo()));
		
		
	}//main
	
}//classe
