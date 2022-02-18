package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Deposito;
import com.gabrielrossilopes.appmalote.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepositoService {

    @Autowired
    private DepositoRepository depositoRepository;

    public List<Deposito> getAllDepositos() {
        return depositoRepository.findAll();
    }

    public Deposito salvaDeposito(Deposito deposito) {
        return depositoRepository.save(deposito);
    }

    public Deposito buscaPorId(Long id) {
        return depositoRepository.getById(id);
    }


    public void removeDeposito(Deposito deposito) {
        depositoRepository.delete(deposito);
    }
}
