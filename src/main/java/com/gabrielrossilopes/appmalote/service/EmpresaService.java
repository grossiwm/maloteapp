package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.dto.EmpresaDTO;
import com.gabrielrossilopes.appmalote.exception.PossuiDependenciasException;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class EmpresaService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${maloteapi.empresa.root}")
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

	public void removeEmpresa(Empresa empresa) throws PossuiDependenciasException {
		try {
			restTemplate.delete(apiRoot.concat("/") + empresa.getId());
		} catch (HttpClientErrorException e) {
			int statusCode = e.getStatusCode().value();
			if (statusCode == 418)
				throw new PossuiDependenciasException("Esta empresa possui dependências e não pôde ser deletada");
		}
	}
}
