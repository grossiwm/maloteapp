package com.gabrielrossilopes.appmalote.model.dominio;

import com.gabrielrossilopes.appmalote.exception.CpfInvalidoException;
import com.gabrielrossilopes.appmalote.model.enums.TipoTransacao;
import com.gabrielrossilopes.appmalote.model.enums.TransacaoStatus;

import com.gabrielrossilopes.appmalote.utils.ValidationUtils;

public class Deposito extends Transacao {
	
	private String cpfBenefiaciario;
	private String nomeBeneficiario;
	
	
	public Deposito() {
		super();

	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStatus(TransacaoStatus status) {
		this.status = status;
	}
	
	public String getCpfBenefiaciario() {
		return cpfBenefiaciario;
	}
	public void setCpfBenefiaciario(String cpfBenefiaciario) throws CpfInvalidoException {
		if (!ValidationUtils.validaCPF(cpfBenefiaciario))
			throw new CpfInvalidoException("Cpf " + cpfBenefiaciario + " inválido");
		
		this.cpfBenefiaciario = cpfBenefiaciario;
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
		return new StringBuilder().append(super.toString()).append(";").append(cpfBenefiaciario).append(";").append(nomeBeneficiario).toString();
	}

}
