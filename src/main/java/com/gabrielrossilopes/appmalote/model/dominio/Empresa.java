package com.gabrielrossilopes.appmalote.model.dominio;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private Integer id;
	
	private String cnpj;
	
	private String nome;
	
	private List<Malote> malotes;
	
	

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
