package com.gabrielrossilopes.appmalote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> buscaTodas() {
		return empresaRepository.findAll();
	}
	
	public Optional<Empresa> buscaPorId(Long id) {
		return empresaRepository.findById(id);
	}
}
