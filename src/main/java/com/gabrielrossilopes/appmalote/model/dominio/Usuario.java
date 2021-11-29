package com.gabrielrossilopes.appmalote.model.dominio;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="usuario")
public class Usuario {
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
    @Column
	private String email;

    @Column
	private String senha;
    
    @Column
    private boolean admin;
    
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isAdmin() {
		if (Objects.isNull(admin))
			return false;
		return admin;
	}


	
	
}
