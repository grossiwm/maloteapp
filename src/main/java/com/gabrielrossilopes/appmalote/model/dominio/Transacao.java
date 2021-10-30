package com.gabrielrossilopes.appmalote.model.dominio;

import java.time.LocalDateTime;

import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

public abstract class Transacao {
	

	public Transacao() {
		this.data = LocalDateTime.now();
		this.status = TransacaoStatus.PROCESSANDO;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	private Integer id;
	private LocalDateTime data;
	private TransacaoStatus status;
	public TransacaoStatus getStatus() {
		return status;
	}
	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
}
