package model.entities;

import java.io.Serializable;

public class Vendedor implements Serializable {
   

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cpf;
	private Integer codigo;
	private String nome;
	
	public Vendedor() {
		
	}

	public Vendedor(Integer id, String cpf, Integer codigo, String nome) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
