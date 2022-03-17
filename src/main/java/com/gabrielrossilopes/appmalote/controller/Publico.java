package com.gabrielrossilopes.appmalote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Publico {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
