package com.gabrielrossilopes.appmalote.service;

import java.util.List;
import java.util.Optional;

import com.gabrielrossilopes.appmalote.dto.EmpresaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	
	public List<Empresa> buscaTodasOrdenado() {
		return empresaRepository.findAllByOrderByNome();
	}
	
	public Optional<Empresa> buscaPorId(Long id) {
		return empresaRepository.findById(id);
	}

	public void criaEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();

		empresa.setNome(empresaDTO.getNome());
		empresa.setCnpj(empresa.getCnpj());

		empresaRepository.save(empresa);
	}

	public void alterarEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = empresaRepository.findById(empresaDTO.getId()).get();
		empresa.setNome(empresaDTO.getNome());
		empresa.setCnpj(empresaDTO.getCnpj());

		empresaRepository.save(empresa);
	}

	public void removeEmpresa(Empresa empresa) {
		empresaRepository.delete(empresa);
	}
}
