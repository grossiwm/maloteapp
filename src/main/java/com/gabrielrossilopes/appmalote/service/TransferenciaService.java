package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Transferencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {


    public List<Transferencia> getAllTransferencia() {
//        if (usuarioLogadoSession.isAdmin())
//            return transferenciaRepository.findAll().stream().sorted(Comparator.comparing(Transferencia::getContaOrigem)).toList();
//
//        Usuario usuario = usuarioRepository.getById(usuarioLogadoSession.getId());
//        Empresa empresa = usuario.getEmpresa();
//        return transferenciaRepository.findAll().stream().filter(d -> d.getMalote().getEmpresa().equals(empresa))
//                .sorted(Comparator.comparing(Transferencia::getContaOrigem)).toList();

        return null;
    }

    public Transferencia buscaPorId(Long id) {
//        return transferenciaRepository.getById(id);
        return null;
    }

    public Transferencia salvaTransferencia(Transferencia transferencia) {
//        return transferenciaRepository.save(transferencia);
        return null;
    }

    public Transferencia alteraTransferencia(Transferencia transferenciaReq) {
//        Long id = transferenciaReq.getId();
//        transferenciaReq.setId(null);
//        Transferencia transferencia = transferenciaRepository.getById(id);
//        transferencia.setValor(transferenciaReq.getValor());
//        transferencia.setContaDestino(transferenciaReq.getContaDestino());
//        transferencia.setContaOrigem(transferenciaReq.getContaOrigem());
//        return transferenciaRepository.save(transferencia);
        return null;
    }

    public void removeTransferencia(Transferencia transferencia) {
//        transferenciaRepository.delete(transferencia);
    }
}
