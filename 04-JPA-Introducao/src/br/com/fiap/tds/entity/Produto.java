package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name="produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;
	
	@Column(name="nm_produto", nullable = false, length = 50)
	private String nome;
	
	@Column(name="ds_produto", nullable = false)
	private String descricao;
	
	@Column(name="vl_produto", nullable = false)
	private double valor;
	
	@Column(name="dt_entrada")
	@Temporal(TemporalType.DATE)
	private Calendar dataEntrada;
	
	@Column(name="dt_fabricacao")
	@Temporal(TemporalType.DATE)
	private Calendar dataFabricacao;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@Column(name="ds_estado")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	//CTRL + 3 -> ggas

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
