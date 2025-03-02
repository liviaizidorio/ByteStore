package com.example.byteStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Long id;
    private String name;
    private double preco;
    private int estoque;
    private String categoria;
    private String marca;
    @Column(name = "url_imagem")
    private String urlImagem;
    @Column(name = "status_carrinho")
    private String statusCarrinho;
}

