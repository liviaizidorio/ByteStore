package com.example.byteStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "carrinho")
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_carrinho")
    private Integer id;
    @Column(name = "valor_total")
    private double valorTotal;
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;
}
