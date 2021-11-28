package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

public class Transferencia extends Transacao {
	private String contaDestino;
	private String contaOrigem;
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
	
	

	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	@Override
	protected TipoTransacao getTipoTransacao() {
		return TipoTransacao.TRANSFERENCIA;
		
	}	
	
	@Override
	public String toString() {
		return new StringBuilder().append(super.toString()).append(contaDestino).append(";").append(contaOrigem).toString();
	}

}
