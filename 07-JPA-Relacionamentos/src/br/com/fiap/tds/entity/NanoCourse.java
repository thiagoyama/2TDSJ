package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_NANO_COURSE")
@SequenceGenerator(name="nano", sequenceName = "SQ_TB_NANO_COURSE", allocationSize = 1)
public class NanoCourse {
	
	@Id
	@Column(name="cd_nano_course")
	@GeneratedValue(generator = "nano", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_nano_course", length = 100, nullable = false)
	private String nome;
	
	@Column(name="nr_creditos", nullable = false)
	private Integer creditos;
	
	@Column(name="nr_horas", nullable = false)
	private Integer horas;
	
	@Column(name="ds_nano_course")
	private String descricao;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Aluno> alunos;
	
	public NanoCourse() {}

	public NanoCourse(String nome, Integer creditos, Integer horas, String descricao) {
		this.nome = nome;
		this.creditos = creditos;
		this.horas = horas;
		this.descricao = descricao;
	}

	public NanoCourse(int codigo, String nome, Integer creditos, Integer horas, String descricao) {
		this.codigo = codigo;
		this.nome = nome;
		this.creditos = creditos;
		this.horas = horas;
		this.descricao = descricao;
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

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
