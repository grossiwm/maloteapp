package com.gabrielrossilopes.appmalote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
}
