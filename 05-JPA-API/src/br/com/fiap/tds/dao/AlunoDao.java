package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Aluno;
import br.com.fiap.tds.exception.AlunoNotFoundException;
import br.com.fiap.tds.exception.CommitException;

// Diminuir a dependência entre os objetos (acoplamento)
// View - Controller (AlunoDao) - DAO - Banco

public interface AlunoDao {

	void insert(Aluno aluno);
	
	Aluno findById(int codigo) throws AlunoNotFoundException;
	
	void delete(int codigo) throws AlunoNotFoundException;
	
	void update(Aluno aluno);
	
	void commit() throws CommitException;
	
}