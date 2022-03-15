package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

import java.math.BigDecimal;

public class Deposito extends Transacao {

	private String cpfBeneficiario;

	private String nomeBeneficiario;

	private BigDecimal valor;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public Malote getMalote() {
		return malote;
	}

	public void setMalote(Malote malote) {
		this.malote = malote;
	}


	private Malote malote;
	
	public Deposito() {
		super();

	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
	
	public String getCpfBeneficiario() {
		return cpfBeneficiario;
	}
	public void setCpfBeneficiario(String cpfBeneficiario) {

		this.cpfBeneficiario = cpfBeneficiario;
	}
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}
	@Override
	public TipoTransacao getTipoTransacao() {
		return TipoTransacao.DEPOSITO;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(cpfBeneficiario).append(";").append(nomeBeneficiario).append(";R$ ").append(valor)
				.toString();
	}

}
