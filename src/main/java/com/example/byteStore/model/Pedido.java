package com.example.byteStore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_carrinho", nullable = false)
    @JsonBackReference
    private Carrinho carrinho;
    @Column(name = "data_pedido")
    private Date dataPedido;
    private String status;

    public Pedido(Date date, String status, Usuario usuario, Carrinho carrinho) {
        this.dataPedido = date;
        this.status=status;
        this.usuario = usuario;
        this.carrinho = carrinho;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
