package br.com.fiap.tds.main;

import br.com.fiap.tds.model.Aluno;
import br.com.fiap.tds.model.Produto;
import br.com.fiap.tds.orm.Orm;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um produto e um aluno
		Produto produto = new Produto();
		Aluno aluno = new Aluno();
		//Instanciar um orm
		Orm orm = new Orm();
		//Chamar o método gerarPesquisa
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(produto));
	}
	
}
