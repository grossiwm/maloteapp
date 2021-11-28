package com.gabrielrossilopes.appmalote.model.dominio;

public class Empresa {
	
	private Integer id;
	
	private String cnpj;
	
	private String nome;

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
	
	@Override
	public String toString() {
		return new StringBuilder().append(id).append(";").append(nome).append(";").append(cnpj).toString();
		
	}

}
