package main.java.com.example.byteStore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carrinho_produto")
public class CarrinhoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho_produto")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_carrinho")
    private Carrinho carrinho;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private int quantidade;

    public CarrinhoProduto( Carrinho carrinho, Produto produto) {
        this.carrinho = carrinho;
        this.produto = produto;
    }

    public CarrinhoProduto(Carrinho carrinho, Produto produto, int quantidade) {
        this.carrinho = carrinho;
        this.produto =produto;
        this.quantidade =quantidade;
    }

    public Long getId() {
        return id;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
