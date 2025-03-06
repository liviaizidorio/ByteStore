package main.java.com.example.byteStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Integer id;
    private String name;
    private double preco;
    private Integer estoque;
    private String categoria;
    private String marca;
    @Column(name = "url_imagem")
    private String urlImagem;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarrinhoProduto> itensCarrinho = new ArrayList<>();
    @Column(name = "status_carrinho")
    private String statusCarrinho;
}

