package br.com.fiap.revisao.model;


public class Carro extends Veiculo {

	//Construtor é herdado? -> NÃO!
	
	public Carro(String marca, int ano, boolean alienado) {
		super(marca, ano, alienado);
	}
	
	public Carro() {}
	
	//Sobrescrita -> mesmo método na classe filha
	@Override
	public void frear() {
		System.out.println("Carro parando...");
	}
	
}