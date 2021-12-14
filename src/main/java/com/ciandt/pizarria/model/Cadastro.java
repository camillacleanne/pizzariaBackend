package com.ciandt.pizarria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_cadastro")
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O nome não pode ser nulo ou vazio")
	@Size(min = 3, max = 70, message = "Tamanho incorreto, deverá conter no mínimo 3 e máximo 70 caracteres ")
	@Column(name = "Nome", nullable = false)
	private String nome;

	@NotBlank(message = "A descrição não pode ser nula ou vazia")
	@Size(min = 3, max = 150, message = "Tamanho incorreto, deverá conter no mínimo 3 e máximo 150 caracteres")
	@Column(name = "Descrições", nullable = false)
	private String descricao;

	@Min(0)
	@Column(name = "preço", nullable = false)
	private double preco;

	public Cadastro(long id, String nome, String descricao, double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Cadastro() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
