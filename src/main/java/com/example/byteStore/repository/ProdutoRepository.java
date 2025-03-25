package com.example.byteStore.repository;

import com.example.byteStore.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Produto findByNome(String nome);

    Iterable<Produto> findByNomeContaining(String name);

    Iterable<Produto> findByCategoria(String categoria);

    Iterable<Produto> findByMarca(String marca);

    Produto findById(int id);
}
