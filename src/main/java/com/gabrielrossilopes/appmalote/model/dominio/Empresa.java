package com.gabrielrossilopes.appmalote.model.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name="empresa")
public class Empresa {
	
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Column
	private String cnpj;
	
    @Column
	private String nome;
	
    @Transient
	private List<Malote> malotes;
	
    @OneToMany
	private List<Usuario> usuarios; 

	public Empresa() {
		malotes = new ArrayList<>();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Malote> getMalotes() {
		return new ArrayList<>(malotes);
	}

	public void addMalote(Malote malote) {
		malotes.add(malote);
	}
	
	public void addMalotes(List<Malote> malotes) {
		this.malotes.addAll(malotes);
	}

	@Override
	public String toString() {
		return new StringBuilder().append(id).append(";").append(nome).append(";").append(cnpj).toString();
		
	}

}
