package main.java.com.example.byteStore.repository;

import main.java.com.example.byteStore.model.Carrinho;
import main.java.com.example.byteStore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Integer> {
    Carrinho findById(int id);

    Carrinho findByUsuario(Usuario usuario);
}
