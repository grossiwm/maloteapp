package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Deposito;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class DepositoService {


    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioService usuarioService;

    @Value("${maloteapi.deposito.root}")
    private String api;

    public List<Deposito> getAllDepositos() {
        if (usuarioLogadoSession.isAdmin())
            return List.of(Objects.requireNonNull(restTemplate.getForObject(api, Deposito[].class)));

        Usuario usuario = usuarioService.getUsuarioById(usuarioLogadoSession.getId());
        Empresa empresa = usuario.getEmpresa();
        return List.of(Objects.requireNonNull(restTemplate.getForObject(api.concat("/by-empresa/") + empresa.getId(), Deposito[].class)));
    }

    public List<Deposito> getAllDepositosByMalote(Long maloteId) {
        return List.of(Objects.requireNonNull(restTemplate.getForObject(api.concat("/by-malote/") + maloteId, Deposito[].class)));
    }

    public Deposito salvaDeposito(Deposito deposito) {
        return restTemplate.postForObject(api, deposito, Deposito.class);
    }

    public Deposito alteraDeposito(Deposito deposito) {
        deposito.setMalote(null);
        return restTemplate.patchForObject(api, deposito, Deposito.class);
    }

    public Deposito buscaPorId(Long id) {
        return restTemplate.getForObject(api.concat("/") + id, Deposito.class);
    }


    public void removeDeposito(Deposito deposito) {
        restTemplate.delete(api.concat("/") + deposito.getId());
    }
}
