package com.gabrielrossilopes.appmalote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gabrielrossilopes.appmalote.session.UsuarioLogadoSession;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioLogadoSession usuarioLogado;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		model.addAttribute("usuario", usuarioLogado);
		return "perfil";
	}

	@GetMapping("/403")
	@ResponseBody
	public String forbidden() {
		return "<html><body><h1> 403 - Forbidden </h2></body></html>";
	}
	
}
