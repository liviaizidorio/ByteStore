package com.example.byteStore.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrinho")
    private Integer id;
    @Column(name = "valor_total")
    private double valorTotal;
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CarrinhoProduto> itens = new ArrayList<>();
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pedido> pedidos;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<CarrinhoProduto> getItens() {
        return itens;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setItens(List<CarrinhoProduto> itens) {
        this.itens = itens;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
