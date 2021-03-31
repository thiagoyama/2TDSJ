package br.com.fiap.tds.exception;

public class AlunoNotFoundException extends Exception {

	public AlunoNotFoundException() {
		super("Aluno não encontrado");
	}
	
	public AlunoNotFoundException(String msg) {
		super(msg);
	}
	
}
