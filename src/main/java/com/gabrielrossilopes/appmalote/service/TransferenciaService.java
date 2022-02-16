package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Transferencia;
import com.gabrielrossilopes.appmalote.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> getAllTransferencia() {
        return transferenciaRepository.findAll();
    }

    public Transferencia buscaPorId(Long id) {
        return transferenciaRepository.getById(id);
    }

    public Transferencia salvaTransferencia(Transferencia transferencia) {
        return transferenciaRepository.save(transferencia);
    }

    public void removeTransferencia(Transferencia transferencia) {
        transferenciaRepository.delete(transferencia);
    }
}
