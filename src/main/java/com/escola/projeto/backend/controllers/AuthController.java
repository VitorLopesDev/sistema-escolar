package com.escola.projeto.backend.controllers;

import com.escola.projeto.backend.domain.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import com.escola.projeto.backend.domain.models.Usuario;
import com.escola.projeto.backend.dtos.LoginRequestDTO;
import com.escola.projeto.backend.dtos.RegisterRequestDTO;
import com.escola.projeto.backend.dtos.ResponseTokenDTO;
import com.escola.projeto.backend.infra.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseTokenDTO(token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> user = this.repository.findByEmail(body.email());
        System.out.println(body);
        if(user.isEmpty()) {
            Usuario newUser = new Usuario();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setUsername(body.username());
            newUser.setRole(body.role());
            this.repository.save(newUser);

            return ResponseEntity.ok("Create user successfully!");
        }
        return ResponseEntity.badRequest().build();
    }
}

