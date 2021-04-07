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
@Table(name="TB_TESTE_COVID")
@SequenceGenerator(name="teste", sequenceName = "SQ_TB_TESTE_COVID", allocationSize = 1)
public class TesteCovid {
	
	@Id
	@Column(name="cd_teste")
	@GeneratedValue(generator = "teste", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_tipo", length = 50, nullable = false)
	private String tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_teste", nullable = false)
	private Calendar data;
	
	@Column(name="st_resultado")
	private Boolean resultado;
	
	public TesteCovid() {}

	public TesteCovid(String tipo, Calendar data, Boolean resultado) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.resultado = resultado;
	}

	public TesteCovid(int codigo, String tipo, Calendar data, Boolean resultado) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.data = data;
		this.resultado = resultado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Boolean isResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}
	
}
