package main.java.com.example.byteStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    private String nome;
    private double preco;
    private Integer estoque;
    private String categoria;
    private String marca;
    @Column(name = "url_imagem")
    private String urlImagem;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<CarrinhoProduto> itensCarrinho = new ArrayList<>();
    //@Column(name = "status_carrinho")
    //private String statusCarrinho;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public List<CarrinhoProduto> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public void setItensCarrinho(List<CarrinhoProduto> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }
}

