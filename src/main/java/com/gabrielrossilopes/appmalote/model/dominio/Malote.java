package com.gabrielrossilopes.appmalote.model.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Malote {
	
	
	
	public Malote(Empresa empresa, LocalDateTime data) {
		this.empresa = empresa;
		this.transacoes = new ArrayList<Transacao>();
		this.data = LocalDateTime.now();
	}
	
	public Malote() {
		this.transacoes = new ArrayList<Transacao>();
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
		return new ArrayList<>(transacoes);
	}
	public void addTransacoes(List<Transacao> transacoes) {
		this.transacoes.addAll(transacoes);
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format("%s; %s; %s", id, empresa, formato.format(data));
	}

}
