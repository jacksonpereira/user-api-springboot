package com.crud.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class UserMO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name = "nome")
	@NotBlank(message = "O nome não deve ser vazio!")
	String nome;
	
	@Column(name = "endereco")
	@NotBlank(message = "O endereço não deve ser vazio")
	String endereco;
	
	@Column(name = "usuario")
	@NotBlank(message = "O usuário não deve ser vazio")
	String usuario;
	
	@Column(name = "senha")
	@NotBlank(message = "A senha não deve ser vazia")
	String senha;
	
	public UserMO() {}
	
	public UserMO(String nome, String endereco, String usuario, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public UserMO(long id, String nome, String endereco, String usuario, String senha) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.usuario = usuario;
		this.senha = senha;
	}
	
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

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
