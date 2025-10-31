package com.escola.projeto.backend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers= {@Server(url="/", description = "defult server URL")})
public class SistemaEscolarApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaEscolarApplication.class, args);

    }
}
