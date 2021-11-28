package com.gabrielrossilopes.appmalote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaloteController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
