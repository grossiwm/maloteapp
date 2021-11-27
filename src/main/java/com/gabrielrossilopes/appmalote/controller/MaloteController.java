package com.gabrielrossilopes.appmalote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaloteController {

	@GetMapping("/")
	public String hello(Model model) {
		System.out.println("oi");
		return "hello";
	}

}
