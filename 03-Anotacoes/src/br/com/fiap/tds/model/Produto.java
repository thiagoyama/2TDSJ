package br.com.fiap.tds.model;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome="TAB_PRODUTO")
public class Produto {
	
	@Coluna(nome="cd_produto", pk = true)
	private int codigo;
	
	@Coluna(nome="nm_produto", tamanho = 100, unico = true)
	private String nome;
	
	@Coluna(nome="vl_produto")
	private double valor;
	
	//CTRL + 3 -> ggas

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
