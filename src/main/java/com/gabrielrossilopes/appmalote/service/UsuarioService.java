package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.exception.PossuiDependenciasException;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${maloteapi.usuario.root}")
    private String apiRoot;


    public Optional<Usuario> getUsuarioByEmail(String email) {
        return Optional.ofNullable(restTemplate.getForObject(apiRoot.concat("/by-email/").concat(email), Usuario.class));
    }

    public Usuario getUsuarioById(Long id) {
        return restTemplate.getForObject(apiRoot.concat("/") + id, Usuario.class);
    }
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        return restTemplate.postForObject(apiRoot, usuario, Usuario.class);
    }
    
    public List<Usuario> busucaTodos() {
        return List.of(Objects.requireNonNull(restTemplate.getForObject(apiRoot, Usuario[].class)));
    }

    public void aceitarUsuario(long id) {
//        Usuario usuario = usuarioRepository.findById(id).get();
//        usuario.setAceito(true);
//        usuarioRepository.save(usuario);

    }

    public void removeUsuario(Usuario usuario) throws PossuiDependenciasException {
        try {
            restTemplate.delete(apiRoot.concat("/") + usuario.getId());
        } catch (HttpClientErrorException e) {
            int status = e.getStatusCode().value();
            if (status == 418)
                throw new PossuiDependenciasException("Este usuário possui dependências e não pôde ser deletado");
        }
    }

    public Optional<UsuarioDTO> autenticar(String email, String senha) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(email, senha);
        try {
            return Optional.ofNullable(restTemplate.postForObject(apiRoot.concat("/validar"), usuarioDTO, UsuarioDTO.class));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
