package main.java.com.example.byteStore.repository;

import main.java.com.example.byteStore.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
