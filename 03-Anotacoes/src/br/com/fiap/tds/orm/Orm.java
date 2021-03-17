package br.com.fiap.tds.orm;

import br.com.fiap.tds.annotation.Tabela;

public class Orm {

	public String gerarPesquisa(Object object) {
		//Recuperar a anotação @Tabela
		Tabela anotacao = object.getClass().getAnnotation(Tabela.class);
		//Recuperar o nome da tabela
		String nome = anotacao.nome();
		return "SELECT * FROM " + nome;
	}
	
}
