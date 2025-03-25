package com.example.byteStore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record ProdutoDtoCreate(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @Positive(message = "O preço deve ser um valor positivo")
        double preco,
        @Positive(message = "O estoque deve ser um valor positivo")
        int estoque,
        @NotBlank(message = "A categoria é obrigatória")
        String categoria,
        @NotBlank(message = "A marca é obrigatória")
        String marca,
        @Pattern(regexp = "^(https?://.*\\.(?:png|jpg|jpeg|gif|bmp|svg))$", message = "A URL da imagem deve ser uma URL válida de um arquivo de imagem")
        String urlImagem) {
}