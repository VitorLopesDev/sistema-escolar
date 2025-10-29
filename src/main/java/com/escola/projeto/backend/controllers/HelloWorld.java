package com.escola.projeto.backend.controllers; // mesmo pacote da aplicação

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
