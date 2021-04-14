package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PROJETO")
@SequenceGenerator(name="projeto", sequenceName = "SQ_TB_PROJETO", allocationSize = 1)
public class Projeto {

	@Id
	@Column(name="cd_projeto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projeto")
	private int codigo;
	
	@Column(name="nm_projeto", nullable = false, length = 50)
	private String nome;
	
	@Column(name="dt_inicio")
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="dt_entrega")
	@Temporal(TemporalType.DATE)
	private Calendar dataEntrega;
	
	//Mapear o relacionamento one-to-one bidirecional
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "projeto", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Grupo grupo;
	
	public Projeto() {}

	public Projeto(String nome, Calendar dataInicio, Calendar dataEntrega) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEntrega = dataEntrega;
	}

	public Projeto(int codigo, String nome, Calendar dataInicio, Calendar dataEntrega) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataEntrega = dataEntrega;
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

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
