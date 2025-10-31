package com.escola.projeto.backend.dtos;

import com.escola.projeto.backend.enums.Role;

public record RegisterRequestDTO (String username, String email, String password, Role role) {
}
