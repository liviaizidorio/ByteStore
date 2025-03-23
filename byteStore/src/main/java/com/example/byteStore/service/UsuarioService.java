package main.java.com.example.byteStore.service;

import main.java.com.example.byteStore.dto.LoginDtoRequest;
import main.java.com.example.byteStore.dto.UsuarioDtoCreate;
import main.java.com.example.byteStore.dto.UsuarioDtoUpdate;
import main.java.com.example.byteStore.model.Usuario;
import main.java.com.example.byteStore.repository.UsuarioRepository;
import main.java.com.example.byteStore.util.PasswordUtil;
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
        BeanUtils.copyProperties(usuarioDtoCreate,usuario);
        usuario.setSenha(PasswordUtil.hashPassword(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario login(LoginDtoRequest loginDtoResquest){
        Usuario usuario= usuarioRepository.findByEmail(loginDtoResquest.email());

        if (usuario == null){
            return null;
        }
        if (!PasswordUtil.checkPassword(loginDtoResquest.senha(),usuario.getSenha())){
            return new Usuario();
        }
        return usuario;
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
        BeanUtils.copyProperties(usuarioDtoUpdate,usuarioEncontrado,"id","pedidos","cpf");
        usuarioEncontrado.setSenha(PasswordUtil.hashPassword(usuarioDtoUpdate.senha()));
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
