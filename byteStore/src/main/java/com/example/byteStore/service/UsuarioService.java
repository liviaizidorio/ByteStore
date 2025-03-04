package main.java.com.example.byteStore.service;

import main.java.com.example.byteStore.dto.UsuarioDtoCreate;
import main.java.com.example.byteStore.dto.UsuarioDtoUpdate;
import main.java.com.example.byteStore.model.Usuario;
import main.java.com.example.byteStore.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastroUsuario(UsuarioDtoCreate usuarioDtoCreate){
        Usuario usuarioExistente = usuarioRepository.findByEmailAndCpf(usuarioDtoCreate.email(), usuarioDtoCreate.cpf());

        var usuario = new Usuario();

        if (usuarioExistente != null){
            return usuario;
        }
        //criptografar senha
        BeanUtils.copyProperties(usuarioDtoCreate,usuario);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(int id, UsuarioDtoUpdate usuarioDtoUpdate){
        Usuario usuarioEncontrado = usuarioRepository.findById(id);

        if(usuarioEncontrado == null){
            return null;
        }
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioDtoUpdate.email());

        var usuario = new Usuario();
        if (usuarioExistente != null){
            return usuario;
        }
        //criptografar senha
        BeanUtils.copyProperties(usuarioDtoUpdate,usuarioEncontrado,"id","pedidos","cpf");
        return usuarioRepository.save(usuarioEncontrado);
    }
    public Usuario mostrarUsuario(int id){
        Usuario usuarioEncontrado = usuarioRepository.findById(id);

        if(usuarioEncontrado == null){
            return null;
        }
        return usuarioEncontrado;
    }
    public Usuario deletarUsuario(int id){
        Usuario usuarioEncontrado = usuarioRepository.findById(id);

        if(usuarioEncontrado == null){
            return null;
        }
        usuarioRepository.delete(usuarioEncontrado);
        return new Usuario();
    }
}
