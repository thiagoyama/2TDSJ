package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_VACINA")
@SequenceGenerator(name="vacina", sequenceName = "SQ_TB_VACINA", allocationSize = 1)
public class Vacina {

	@Id
	@Column(name="cd_vacina")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacina")
	private int codigo;
	
	@Column(name="nm_vacina", length = 40, nullable = false)
	private String nome;
	
	@Column(name="st_aprovado")
	private boolean aprovado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_distribuicao")
	private Calendar dataDistribuicao;
	
	@Column(name="nm_fabricante", nullable = false, length = 80)
	private String fabricante;
	
	public Vacina() {}
	
	public Vacina(String nome, boolean aprovado, Calendar dataDistribuicao, String fabricante) {
		this.nome = nome;
		this.aprovado = aprovado;
		this.dataDistribuicao = dataDistribuicao;
		this.fabricante = fabricante;
	}
	
	public Vacina(int codigo, String nome, boolean aprovado, Calendar dataDistribuicao, String fabricante) {
		this.codigo = codigo;
		this.nome = nome;
		this.aprovado = aprovado;
		this.dataDistribuicao = dataDistribuicao;
		this.fabricante = fabricante;
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

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Calendar getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Calendar dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
}
