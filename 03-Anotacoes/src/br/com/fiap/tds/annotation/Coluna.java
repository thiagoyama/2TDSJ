package br.com.fiap.tds.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Teste.java - Compilação -> Teste.class (bytecode) -> "Execução" Intepretação JVM

//Define até quando a anotação estará presente
@Retention(RetentionPolicy.RUNTIME)
//SOURCE -> código fonte (.java)
//CLASS -> até o bytecode (.class) (padrão)
//RUNTIME -> até a execução

//Define o lugar onde a anotação pode ser utilizada
//Field -> atributos
@Target( { ElementType.FIELD, ElementType.METHOD } )

public @interface Coluna {

	String nome();
	boolean unico() default false;
	boolean pk() default false;
	int tamanho() default 255;
	
}
