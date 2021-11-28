package com.gabrielrossilopes.appmalote.model.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Malote {
	
	
	
	public Malote(Integer id, Empresa empresa, List<Transacao> transacoes, LocalDateTime data) {
		this.id = id;
		this.empresa = empresa;
		this.transacoes = transacoes;
		this.data = LocalDateTime.now();
	}
	
	public Malote() {
		this.data = LocalDateTime.now();
	}


	private Integer id;
	

	private Empresa empresa;
	
	private List<Transacao> transacoes;
	
	private LocalDateTime data;
	
	public LocalDateTime getData() {
		return data;
	}
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
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("%s; %s; %s", id, empresa, formato.format(data));
	}

}
