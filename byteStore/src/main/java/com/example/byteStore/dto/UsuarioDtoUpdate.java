package com.example.byteStore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record UsuarioDtoUpdate(
        String name,
        @Email(message = "E-mail inválido")
        String email,
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
                message = "A senha deve ter pelo menos 8 caracteres, incluindo letras e números")
        String senha,
        @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?(9\\d{4}-?\\d{4})$", message = "Telefone inválido")
        String telefone)
 {
}
