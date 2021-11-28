package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

public class Pagamento extends Transacao {
	
	private String cnpjRecebedor;
	
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
	
	public String getCnpjRecebedor() {
		return cnpjRecebedor;
	}
	public void setCnpjRecebedor(String cnpjRecebedor) {
		this.cnpjRecebedor = cnpjRecebedor;
	}
	@Override
	protected TipoTransacao getTipoTransacao() {
		return TipoTransacao.PAGAMENTO;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(super.toString()).append(";").append(cnpjRecebedor).toString();
	}

}
