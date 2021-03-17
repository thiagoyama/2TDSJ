package br.com.fiap.tds.main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.model.Produto;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um Produto
		Produto produto = new Produto();
		
		//API Reflection -> obtem a estrutura da classe
		//Obter o nome da classe
		String nome = produto.getClass().getName();
		System.out.println(nome);
		
		//Obter os métodos da classe
		System.out.println("Métodos:");
		Method[] metodos = produto.getClass().getDeclaredMethods();
		//Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		System.out.println("Atributos:");
		//Obter os atributos da classe
		Field[] atributos = produto.getClass().getDeclaredFields();
		//Exibir o nome e o tipo dos atributos
		for (Field f : atributos) {
			System.out.println(f.getName() + " " + f.getType());
			//Recuperar a anotação @Coluna
			Coluna a = f.getAnnotation(Coluna.class);
			System.out.println(a.nome() + " PK: " + a.pk() + " Único: "
					+ a.unico() + " Tamanho: " + a.tamanho());
		}
		
	}//main
	
}//classe
