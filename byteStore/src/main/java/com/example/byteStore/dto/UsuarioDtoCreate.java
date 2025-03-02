package com.example.byteStore.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioDtoCreate(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @Email(message = "E-mail inválido")
        @NotBlank(message = "O e-mail é obrigatório")
        String email,
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
                message = "A senha deve ter pelo menos 8 caracteres, incluindo letras e números")
        String senha,
        @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?(9\\d{4}-?\\d{4})$", message = "Telefone inválido")
        String telefone,
        @Pattern(regexp = "^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2})$", message = "CPF inválido")
        String cpf) {
}
