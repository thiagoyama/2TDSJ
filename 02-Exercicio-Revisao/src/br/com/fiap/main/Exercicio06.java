package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		//Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(
				1, 12, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		//Instanciar uma conta poupança
		ContaPoupanca cp = new ContaPoupanca(
				1, 123, new GregorianCalendar(2021, Calendar.MARCH, 30), 1000, 1);
		
		try {
			//Chamar o método retirar()
			cc.retirar(300);
			System.out.println("Saque efetuado!");
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe
