package br.com.fiap.tds.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int codigo;
	
	@Column(name="nm_aluno", length = 60, nullable = false)
	private String nome;
	
	@Column(name="ds_turma", length = 40, nullable = false)
	private String turma;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name="ds_periodo", length = 40)
	private Periodo periodo;
	
	@Column(name="st_ativo")
	private boolean ativo;
	
	@CreationTimestamp //Insere a data de cadastro de forma automática
	@Column(name="dt_cadastro", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	public Aluno() {}
	
	public Aluno(String nome, String turma, Calendar dataNascimento, Periodo periodo, 
																		boolean ativo) {
		super();
		this.nome = nome;
		this.turma = turma;
		this.dataNascimento = dataNascimento;
		this.periodo = periodo;
		this.ativo = ativo;
	}
	
	public Aluno(int codigo, String nome, String turma, Calendar dataNascimento, Periodo periodo, boolean ativo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
		this.dataNascimento = dataNascimento;
		this.periodo = periodo;
		this.ativo = ativo;
	}

	//CTRL + 3 -> gcuf
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		return "Código: " + codigo + "\nNome: " + nome + "\nTurma: " +
				turma + "\nPeríodo: " + periodo + "\nAtivo: " + ativo + 
				"\nData Nascimento: " + sdf.format(dataNascimento.getTime()) +
				"\nData Cadastro: " + sdf.format(dataCadastro.getTime());
	}

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

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
