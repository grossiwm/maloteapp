package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Pagamento;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class PagamentoService {


    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${maloteapi.pagamento.root}")
    private String api;

    @Autowired
    private UsuarioService usuarioService;

    public List<Pagamento> getAllPagamentos() {
        if (usuarioLogadoSession.isAdmin())
            return List.of(Objects.requireNonNull(restTemplate.getForObject(api, Pagamento[].class)));

        Usuario usuario = usuarioService.getUsuarioById(usuarioLogadoSession.getId());
        Empresa empresa = usuario.getEmpresa();

        return List.of(Objects.requireNonNull(restTemplate.getForObject(api.concat("/by-empresa/") + empresa.getId(), Pagamento[].class)));
    }

    public List<Pagamento> getAllPagamentosByMalote(Long maloteId) {
        return List.of(Objects.requireNonNull(restTemplate.getForObject(api.concat("/by-malote/") + maloteId, Pagamento[].class)));
    }

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return restTemplate.postForObject(api, pagamento, Pagamento.class);
    }

    public Pagamento alterarPagamento(Pagamento pagamento)
    {
        pagamento.setMalote(null);
        return restTemplate.patchForObject(api, pagamento, Pagamento.class);
    }

    public Pagamento buscarPorId(Long id) {
        return restTemplate.getForObject(api.concat("/") + id, Pagamento.class);
    }

    public void removerPagamento(Pagamento pagamento) {
        restTemplate.delete(api.concat("/") + pagamento.getId());
    }
}
