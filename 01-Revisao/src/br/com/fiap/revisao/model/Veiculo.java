package br.com.fiap.revisao.model;

public class Veiculo {

	//Modificadores de acessos:
	//private -> somente a própria classe;
	//public -> todos;
	//protected -> própria classe, classes filhas e mesmo pacote;
	//default (package) -> própria classe e mesmo pacote; 
	
	//Tipos primitivos: byte, short, int, char, long, float ,double, boolean
	//Valor padrão: números = 0, boolean = false
	
	//Tipos de referência: String, Veiculo, Date....
	//Valor padrão: null
	
	//Atributos
	private String marca;
	
	private Integer ano;
	
	private boolean alienado;
	
	private Estado estado;  //CTRL + 1 
	
	//Construtores
	public Veiculo(String marca, int ano, boolean alienado) {
		this.marca = marca;
		this.ano = ano;
		this.alienado = alienado;
	}
	
	public Veiculo() {}
	
	//Sobrescrever o método toString
	@Override
	public String toString() {
		return marca + " - " + ano + " - " + alienado;
	}
	
	//Métodos
	public void frear() {
		System.out.println("Veiculo parando...");
	}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void frear(float velocidade) {
		System.out.println("Veiculo na velocidade " + velocidade);
	}
	
	public void frear(float velocidade, boolean abs) {
		System.out.println("Veiculo parando "
					+ velocidade + " " + abs);
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public boolean isAlienado() {
		return alienado;
	}

	public void setAlienado(boolean alienado) {
		this.alienado = alienado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}