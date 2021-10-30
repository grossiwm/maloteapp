package com.gabrielrossilopes.appmalote.model.tests;

import com.gabrielrossilopes.appmalote.model.dominio.Empresa;
import com.gabrielrossilopes.appmalote.model.dominio.Malote;

public class MaloteTest {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		
		
		Malote malote = new Malote();
		malote.setEmpresa(empresa);
	}

}
