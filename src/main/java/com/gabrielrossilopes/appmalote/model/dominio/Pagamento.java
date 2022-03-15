package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

import java.math.BigDecimal;

public class Pagamento extends Transacao {

	private String cnpjRecebedor;

	private Malote malote;

	private Long id;

	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Malote getMalote() {
		return malote;
	}

	public void setMalote(Malote malote) {
		this.malote = malote;
	}

	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
	
	public String getCnpjRecebedor() {
		return cnpjRecebedor;
	}
	public void setCnpjRecebedor(String cnpjRecebedor) {
//		if (!ValidationUtils.validaCNPJ(cnpjRecebedor))
//			throw new CnpjInvalidoException("cnpj " + cnpjRecebedor + " inválido");
		
		this.cnpjRecebedor = cnpjRecebedor;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.PAGAMENTO;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(cnpjRecebedor).append(";R$ ").append(valor)
				.toString();
	}

}
