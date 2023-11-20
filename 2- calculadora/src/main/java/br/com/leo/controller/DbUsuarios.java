package br.com.leo.controller;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "db_usuarios")
public class DbUsuarios {
	
	@Id
	 @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
	private Integer id;
	 @Column(name = "nome", length = 50, nullable = false)
	private String nome;
	 @Column(name = "email", length = 50, nullable = false)    
	private String email;
	 @Column(name = "senha", length = 20, nullable = false)  
	private String senha;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name = "nascimento", length = 10, nullable = false)  
		private Date nascimento;
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
}
