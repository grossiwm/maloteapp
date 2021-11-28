package com.gabrielrossilopes.appmalote.model.tests;

import java.util.List;

import com.gabrielrossilopes.appmalote.model.dominio.Deposito;
import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Malote;
import com.gabrielrossilopes.appmalote.model.dominio.Pagamento;
import com.gabrielrossilopes.appmalote.model.dominio.Transacao;
import com.gabrielrossilopes.appmalote.model.dominio.Transferencia;

public class MaloteTest {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		
		
		Malote malote = new Malote();
		malote.setEmpresa(empresa);
		
		System.out.println(malote);
		
		Transacao transacao1 = new Transferencia();
		Transacao transacao2 = new Pagamento();
		Transacao transacao3 = new Deposito();
		
		malote.addTransacoes(List.of(transacao1, transacao2, transacao3));
		
		malote.getTransacoes().stream().forEach(t->System.out.println(t.getClass().getName()));
	}

}
