package com.gabrielrossilopes.appmalote.model.dominio;

import java.util.List;

public class Malote {
	
	private Integer id;
	private Empresa empresa;
	private List<Transacao> transacoes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

}
