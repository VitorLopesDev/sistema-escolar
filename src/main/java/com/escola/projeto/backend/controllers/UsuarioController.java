package com.escola.projeto.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class UsuarioController {

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok().body("Sucesso!");
    }
}
