package com.gabrielrossilopes.appmalote.dto;

public class UsuarioDTO {
	
	private String email;
	
	private String senha;
	
	private Long empresa;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Long empresaId) {
		this.empresa = empresaId;
	}

}
