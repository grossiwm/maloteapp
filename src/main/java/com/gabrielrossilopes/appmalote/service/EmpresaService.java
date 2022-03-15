package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.dto.EmpresaDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {


	public List<Empresa> buscaTodasOrdenado() {
		return null;
	}
	
	public Empresa buscaPorId(Long id) {
		return null;
	}

	public void criaEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();

		empresa.setNome(empresaDTO.getNome());
		empresa.setCnpj(empresaDTO.getCnpj());

		return;
	}

	public void alterarEmpresa(EmpresaDTO empresaDTO) {
//		Empresa empresa = empresaRepository.findById(empresaDTO.getId()).get();
//		empresa.setNome(empresaDTO.getNome());
//		empresa.setCnpj(empresaDTO.getCnpj());
//
//		empresaRepository.save(empresa);
	}

	public void removeEmpresa(Empresa empresa) {
//		empresaRepository.delete(empresa);
	}
}
