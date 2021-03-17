package br.com.fiap.bean;

import java.sql.Date;
import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1
public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
	@Override
	public double retirar(double valor) throws SaldoInsuficienteException {
		//Conta comum e o saldo fica negativo dps do saque
		if (tipo == TipoConta.COMUM && saldo < valor) {
			//Erro
			throw new SaldoInsuficienteException(saldo);
		} 
		//saque...
		saldo -= valor;
		return saldo;
	}

//	@Override
//	public double depositar(double valor) {
//		saldo += valor; // saldo = saldo + valor;
//		return saldo;
//		//return saldo += valor;
//	}
	
	public ContaCorrente() {}
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	//CTRL + 3 -> gcuf

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}