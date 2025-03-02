package com.example.byteStore.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDtoCreate(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotBlank(message = "O preco é obrigatório")
        double preco,
        @NotBlank(message = "O estoque é obrigatório")
        int estoque,
        @NotBlank(message = "O categoria é obrigatório")
        String categoria,
        @NotBlank(message = "O marca é obrigatório")
        String marca,
        @NotBlank(message = "O url da imagem é obrigatório")
        String urlImagem) {
}