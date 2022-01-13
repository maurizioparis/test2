package com.max.openshift.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATTO")
public class Contatto implements Serializable {
	private static final long serialVersionUID = 5653173288765769397L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "nome", nullable = true)
	private String nome;
	@Column(name = "cognome", nullable = false)
	private String cognome;
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	public Contatto(String nome, String cognome, String username) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
	}

	public Contatto() {
		super();
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
