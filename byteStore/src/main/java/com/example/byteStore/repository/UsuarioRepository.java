package main.java.com.example.byteStore.repository;

import main.java.com.example.byteStore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByEmailAndCpf(String email, String cpf);

    Usuario findById(int id);
    Usuario findByEmail(String email);

}
