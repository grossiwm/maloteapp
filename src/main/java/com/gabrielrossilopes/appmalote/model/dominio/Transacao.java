package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

public abstract class Transacao {
	
	protected Integer id;
	protected TransacaoStatus status;
	

	public Transacao() {
		this.status = TransacaoStatus.PROCESSANDO;
	}
	public Integer getId() {
		return id;
	}

	public TransacaoStatus getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(id).append(";").append(status.name()).toString();
		
	}
	
	protected abstract TipoTransacao getTipoTransacao();
	
}
