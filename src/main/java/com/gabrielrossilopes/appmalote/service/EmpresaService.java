package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.dto.EmpresaDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class EmpresaService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.empresa.root}")
	private String apiRoot;

	public List<Empresa> buscaTodasOrdenado() {
		return List.of(Objects.requireNonNull(restTemplate.getForObject(apiRoot, Empresa[].class)));
	}
	
	public Empresa buscaPorId(Long id) {
		try {
			return restTemplate.getForObject(apiRoot.concat("/") + id, Empresa.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void alterarEmpresa(EmpresaDTO empresaDTO) {
		restTemplate.patchForObject(apiRoot, empresaDTO, Void.class);
	}

	public void criaEmpresa(EmpresaDTO empresaDTO) {
		restTemplate.postForObject(apiRoot, empresaDTO, Empresa.class);
	}

	public void removeEmpresa(Empresa empresa) {
		restTemplate.delete(apiRoot.concat("/") + empresa.getId());
	}
}
