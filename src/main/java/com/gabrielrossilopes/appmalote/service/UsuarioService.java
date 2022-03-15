package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.dto.UsuarioDTO;
import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.usuario.root}")
    private String apiRoot;


    public Optional<Usuario> getUsuarioByEmail(String email) {
//        return usuarioRepository.findByEmail(email);
        return null;
    }

    public Usuario getUsuarioById(Long id) {
//        return usuarioRepository.getById(id);
        return null;
    }
    
    public Usuario cadastrarUsuario(Usuario usuario) {
//        return usuarioRepository.save(usuario);
        return null;
    }
    
    public List<Usuario> busucaTodos() {
//    	return usuarioRepository.findAll().stream().filter(u -> !u.isAdmin()).sorted(Comparator.comparing(Usuario::getNome)).toList();
        return null;
    }

    public void aceitarUsuario(long id) {
//        Usuario usuario = usuarioRepository.findById(id).get();
//        usuario.setAceito(true);
//        usuarioRepository.save(usuario);

    }

    public void removeUsuario(Usuario usuario) {
//        usuarioRepository.delete(usuario);
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
