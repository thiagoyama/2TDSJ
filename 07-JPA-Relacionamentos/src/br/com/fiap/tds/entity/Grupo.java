package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_GRUPO")
@SequenceGenerator(name="grupo", sequenceName = "SQ_TB_GRUPO", allocationSize = 1)
public class Grupo {

	@Id
	@Column(name="cd_grupo")
	@GeneratedValue(generator = "grupo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_grupo", length = 50, nullable = false )
	private String nome;
	
	//Mapear o relacionamento um-para-um
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_projeto", nullable = false)
	private Projeto projeto;
	
	//Mapear o relacionamento um-para-muitos bidirecional
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<Aluno> alunos;
	
	//Método para adicionar aluno -> utilizar somente no OneToMany
	public void addAluno(Aluno aluno) {
		if (alunos == null)
			alunos = new ArrayList<>();
		//Aluno será adicionado na lista
		alunos.add(aluno);
		//Aluno terá o seu grupo setado
		aluno.setGrupo(this); //Garante que a FK será cadastrada no banco
	}
	
	public Grupo() {}
	
	public Grupo(String nome, Projeto projeto) {
		this.nome = nome;
		this.projeto = projeto;
	}

	public Grupo(int codigo, String nome, Projeto projeto) {
		this.codigo = codigo;
		this.nome = nome;
		this.projeto = projeto;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
}
