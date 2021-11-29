package com.gabrielrossilopes.appmalote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.appmalote.model.dominio.Usuario;
import com.gabrielrossilopes.appmalote.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> busucaTodos() {
    	return usuarioRepository.findAll();
    }

}
