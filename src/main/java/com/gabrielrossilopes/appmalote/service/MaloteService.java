package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Malote;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaloteService {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    public Malote salvaMalote(Malote malote) {
        return null;
    }

    public Malote getById(Long id) {
        return null;
    }

    public List<Malote> buscaTodos() {

        if (usuarioLogadoSession.isAdmin())
            return null;

//        Usuario usuario = usuarioRepository.getById(usuarioLogadoSession.getId());
//        Empresa empresa = usuario.getEmpresa();
        return null;
    }

    public void removeMalote(Malote malote) {

//        maloteRepository.delete(malote);
    }

}
