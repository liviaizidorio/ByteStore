package com.example.byteStore.repository;

import com.example.byteStore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    Usuario findById(int id);
    Usuario findByEmail(String email);

}
