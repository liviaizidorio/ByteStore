package main.java.com.example.byteStore.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoDtoUpdate(
        String name,
        double preco,
        int estoque,
        String urlImagem)
 {
}
