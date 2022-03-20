package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Transacao;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class TransacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private RestTemplate restTemplate;


    @Value("${maloteapi.transacao.root}")
    private String api;

    public List<Transacao> getAllTransacao() {
        if (usuarioLogadoSession.isAdmin()) {
            return List.of(Objects.requireNonNull(restTemplate.getForObject(api, Transacao[].class)));
        }

        Usuario usuario = usuarioService.getUsuarioById(usuarioLogadoSession.getId());
        Empresa empresa = usuario.getEmpresa();
        Transacao[] transacaosArr = restTemplate.getForObject(api.concat("/by-empresa/") + empresa.getId(), Transacao[].class);
        return List.of(Objects.requireNonNull(transacaosArr));
    }
}
