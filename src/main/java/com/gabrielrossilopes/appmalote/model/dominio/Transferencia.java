package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

import java.math.BigDecimal;

public class Transferencia extends Transacao {

	private String contaDestino;
	private String contaOrigem;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	private BigDecimal valor;

	public Transferencia() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Long id;

	public Malote getMalote() {
		return malote;
	}

	public void setMalote(Malote malote) {
		this.malote = malote;
	}

	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}

	private Malote malote;

	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino)  {
//		if (!ValidationUtils.validaConta(contaDestino))
//			throw new ContaInvalidaException("Conta " + contaDestino + " inválida");
			
		this.contaDestino = contaDestino;
	}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.TRANSFERENCIA;
		
	}	
	
	@Override
	public String toString() {
		return new StringBuilder().append(contaDestino).append(";").append(contaOrigem).append(";R$ ").append(valor)
				.toString();
	}

}
