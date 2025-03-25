package com.example.byteStore.service;

import com.example.byteStore.dto.LoginDtoRequest;
import com.example.byteStore.dto.UsuarioDtoCreate;
import com.example.byteStore.dto.UsuarioDtoUpdate;
import com.example.byteStore.model.Usuario;
import com.example.byteStore.repository.UsuarioRepository;
import com.example.byteStore.util.PasswordUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastroUsuario(UsuarioDtoCreate usuarioDtoCreate){
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuarioDtoCreate.email());

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
        if (usuarioExistente != null && !Objects.equals(usuarioExistente.getEmail(), usuarioEncontrado.getEmail())){
            return usuario;
        }
        BeanUtils.copyProperties(usuarioDtoUpdate,usuarioEncontrado,"id","pedidos");
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
