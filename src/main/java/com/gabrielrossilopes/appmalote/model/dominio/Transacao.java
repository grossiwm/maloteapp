package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public abstract class Transacao {

	protected TransacaoStatus status;
	

	public Transacao() {
		this.status = TransacaoStatus.PROCESSANDO;
	}


	public TransacaoStatus getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(";").append(status.name()).toString();
		
	}
	
	public abstract TipoTransacao getTipoTransacao();
	
}
