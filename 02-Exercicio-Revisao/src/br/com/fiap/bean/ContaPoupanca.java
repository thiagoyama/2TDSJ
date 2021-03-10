package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa; //CTRL + 1
	
	//Constante
	//final:  variável -> não pode ser alterada; 
	//			método -> não permite a sobrescrita;
	//			classe -> não permite a herança;
	
	//static -> o elemento pertence a classe e não mais ao objeto
	public static final float RENDIMENTO = 0.04f; 
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

	@Override
	public double retirar(double valor) throws SaldoInsuficienteException {
		if (saldo < valor + taxa) {
			throw new SaldoInsuficienteException(saldo);			
		} 
		return saldo -= valor + taxa;
	}

//	@Override
//	public double depositar(double valor) {
//		return saldo += valor;
//	}

	//Construtores CTRL + 3 -> gcuf
	public ContaPoupanca() {}
	
	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}
	
}