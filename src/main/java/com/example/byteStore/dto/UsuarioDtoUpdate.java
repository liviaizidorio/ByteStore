package com.example.byteStore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UsuarioDtoUpdate(
        String nome,
        @Email(message = "E-mail inválido")
        String email,
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
                message = "A senha deve ter pelo menos 8 caracteres, incluindo letras e números")
        String senha)
 {
}
