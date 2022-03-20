package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.exception.PossuiDependenciasException;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Malote;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class MaloteService {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${maloteapi.malote.root}")
    private String api;

    public Malote salvaMalote(Malote malote) {
        return null;
    }

    public Malote getById(Long id) {
        return restTemplate.getForObject(api.concat("/") + id, Malote.class);
    }

    public List<Malote> buscaTodos() {

        if (usuarioLogadoSession.isAdmin())
            return List.of(Objects.requireNonNull(restTemplate.getForObject(api, Malote[].class)));

        Usuario usuario = usuarioService.getUsuarioById(usuarioLogadoSession.getId());
        Empresa empresa = usuario.getEmpresa();

        Malote[] malotesArr = restTemplate.getForObject(api.concat("/by-empresa/") + empresa.getId(), Malote[].class);

        assert malotesArr != null;
        return List.of(malotesArr);
    }

    public void removeMalote(Malote malote)  throws PossuiDependenciasException {
        try {
            restTemplate.delete(api.concat("/") + malote.getId());
        } catch (HttpClientErrorException e) {
            int statusCode = e.getStatusCode().value();
            if (statusCode == 418)
                throw new PossuiDependenciasException("Este malote possui dependências e não pôde ser excluído");
        }
    }

}
