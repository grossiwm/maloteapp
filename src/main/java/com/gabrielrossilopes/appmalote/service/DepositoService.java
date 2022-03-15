package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Deposito;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositoService {


    public List<Deposito> getAllDepositos() {
//        if (usuarioLogadoSession.isAdmin())
//            return depositoRepository.findAll().stream().sorted(Comparator.comparing(Deposito::getNomeBeneficiario)).toList();
//
//        Usuario usuario = usuarioRepository.getById(usuarioLogadoSession.getId());
//        Empresa empresa = usuario.getEmpresa();
//        return depositoRepository.findAll().stream().filter(d -> d.getMalote().getEmpresa().equals(empresa))
//                .sorted(Comparator.comparing(Deposito::getNomeBeneficiario)).toList();
        return null;
    }

    public Deposito salvaDeposito(Deposito deposito) {
//        return depositoRepository.save(deposito);
        return null;
    }

    public Deposito alteraDeposito(Deposito depositoReq) {
//        Long id = depositoReq.getId();
//        depositoReq.setId(null);
//        Deposito deposito = depositoRepository.getById(id);
//        deposito.setNomeBeneficiario(depositoReq.getNomeBeneficiario());
//        deposito.setCpfBeneficiario(depositoReq.getCpfBeneficiario());
//        deposito.setValor(depositoReq.getValor());
//        depositoRepository.save(deposito);
//        return deposito;
        return null;
    }

    public Deposito buscaPorId(Long id) {
//        return depositoRepository.getById(id);
        return null;
    }


    public void removeDeposito(Deposito deposito) {
//        depositoRepository.delete(deposito);
    }
}
