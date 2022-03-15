package com.gabrielrossilopes.appmalote.service;

import com.gabrielrossilopes.appmalote.model.dominio.Pagamento;
import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {


    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    public List<Pagamento> getAllPagamentos() {
//        if (usuarioLogadoSession.isAdmin())
//            return pagamentoRepository.findAll().stream().sorted(Comparator.comparing(Pagamento::getCnpjRecebedor)).toList();
//
//        Usuario usuario = usuarioRepository.getById(usuarioLogadoSession.getId());
//        Empresa empresa = usuario.getEmpresa();
//        return pagamentoRepository.findAll().stream().filter(d -> d.getMalote().getEmpresa().equals(empresa))
//                .sorted(Comparator.comparing(Pagamento::getCnpjRecebedor)).toList();
        return null;
    }

    public Pagamento salvarPagamento(Pagamento pagamento) {
//        return pagamentoRepository.save(pagamento);
        return null;
    }

    public Pagamento alterarPagamento(Pagamento pagamentoReq)
    {
        return null;
//        Long id = pagamentoReq.getId();
//        pagamentoReq.setId(null);
//        Pagamento pagamento = pagamentoRepository.getById(id);
//        pagamento.setCnpjRecebedor(pagamentoReq.getCnpjRecebedor());
//        pagamento.setValor(pagamentoReq.getValor());
//        return pagamentoRepository.save(pagamento);
    }

    public Pagamento buscarPorId(Long id) {
//        return pagamentoRepository.getById(id);
        return null;
    }

    public void removerPagamento(Pagamento pagamento) {
//        pagamentoRepository.delete(pagamento);
    }
}
