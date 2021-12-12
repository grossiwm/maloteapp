package com.gabrielrossilopes.appmalote.model.dominio;

import java.util.Objects;

import javax.persistence.*;

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
    private Boolean admin;
    
	@ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

	@Column
	private Boolean aceito;

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Boolean isAceito() {
		if (Objects.isNull(aceito))
			return false;
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}

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

	public Boolean isAdmin() {
		if (Objects.isNull(admin))
			return false;
		return admin;
	}


	
	
}
