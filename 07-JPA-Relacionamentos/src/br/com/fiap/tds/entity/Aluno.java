package br.com.fiap.tds.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_ALUNO")
@SequenceGenerator(name="aluno", sequenceName = "SQ_TB_ALUNO", allocationSize = 1)
public class Aluno {
	
	@Id
	@Column(name="nr_rm")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno")
	private int codigo;
	
	@Column(name="nm_aluno", nullable = false, length = 100)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private Genero genero;
	
	//Mapeamento do relacionamento muitos para um
	@ManyToOne
	@JoinColumn(name="cd_grupo")
	private Grupo grupo;
	
	//Mapeamento do relacionamento muitos para muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	//Configuração da tabela associativa
	//name -> nome da tabela associativa
	//joinColums -> coluna PK/FK da tabela corrente
	//inverseJoinColumnns -> coluna PK/FK da tabela do outro lado da relação
	@JoinTable(name="TB_ALUNO_CURSO",
			joinColumns = @JoinColumn(name="nr_rm"),
			inverseJoinColumns = @JoinColumn(name="cd_nano_course"))
	private List<NanoCourse> cursos;
	
	public Aluno() {}

	public Aluno(String nome, Calendar dataNascimento, Genero genero) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Aluno(int codigo, String nome, Calendar dataNascimento, Genero genero) {
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<NanoCourse> getCursos() {
		return cursos;
	}

	public void setCursos(List<NanoCourse> cursos) {
		this.cursos = cursos;
	}
	
}
