package main.java.com.example.byteStore.repository;

import main.java.com.example.byteStore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findByName(String name);

    Iterable<Produto> findByNameContaining(String name);

    Iterable<Produto> findByCategoria(String categoria);

    Iterable<Produto> findByMarca(String marca);

    Produto findById(int id);
}
