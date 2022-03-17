package com.gabrielrossilopes.appmalote.service;


import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Transferencia;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransferenciaService {


    @Autowired
    private RestTemplate restTemplate;

    @Value("${maloteapi.transferencia.root}")
    private String api;

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private UsuarioService usuarioService;


    public List<Transferencia> getAllTransferencia() {

        try {

            if (usuarioLogadoSession.isAdmin()) {
                return List.of(Objects.requireNonNull(restTemplate.getForObject(api, Transferencia[].class)));
            }

                Usuario usuario = usuarioService.getUsuarioById(usuarioLogadoSession.getId());
                Empresa empresa = usuario.getEmpresa();
                Transferencia[] transferenciasArr =
                        restTemplate.getForObject(api.concat("/by-empresa/") + empresa.getId(), Transferencia[].class);
                assert transferenciasArr != null;
                return List.of(transferenciasArr);

            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList<>();
            }

    }

    public Transferencia buscaPorId(Long id) {
        return restTemplate.getForObject(api.concat("/") + id, Transferencia.class);
    }

    public Transferencia salvaTransferencia(Transferencia transferencia) {
        return restTemplate.postForObject(api, transferencia, Transferencia.class);
    }

    public Transferencia alteraTransferencia(Transferencia transferencia) {

        return restTemplate.patchForObject(api, transferencia, Transferencia.class);
    }

    public void removeTransferencia(Transferencia transferencia) {
        restTemplate.delete(api.concat("/") + transferencia.getId());
    }
}
