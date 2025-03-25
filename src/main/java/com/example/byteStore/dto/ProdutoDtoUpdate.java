package com.example.byteStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record ProdutoDtoUpdate(
        String nome,
        @Positive(message = "O preço deve ser um valor positivo") double preco,
        @Pattern(regexp = "^(https?://.*\\.(?:png|jpg|jpeg|gif|bmp|svg))$", message = "A URL da imagem deve ser uma URL válida de um arquivo de imagem")
        String urlImagem
)
 {
}
