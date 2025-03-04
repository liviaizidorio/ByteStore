package main.java.com.example.byteStore.controller;

import main.java.com.example.byteStore.dto.UsuarioDtoCreate;
import main.java.com.example.byteStore.dto.UsuarioDtoUpdate;
import main.java.com.example.byteStore.model.Usuario;
import main.java.com.example.byteStore.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    // @PostMapping -> criar ususario
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> cadastrarUsuario(UsuarioDtoCreate usuarioDtoCreate,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioCriado =usuarioService.cadastroUsuario(usuarioDtoCreate);
        if (usuarioCriado.getId() == null){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuarioCriado,HttpStatus.CREATED);
    }
    // @PutMapping -> atualizar usuario
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable(value = "id") int id, UsuarioDtoUpdate usuarioDtoUpdate,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioAtualizado =usuarioService.atualizarUsuario(id,usuarioDtoUpdate);
        if(usuarioAtualizado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (usuarioAtualizado.getId() == null){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuarioAtualizado,HttpStatus.CREATED);

    }
    //@GetMapping -> apenas um usuario
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> mostrarUsuario(@PathVariable(value = "id") int id, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioEncontrado =usuarioService.mostrarUsuario(id);
        if(usuarioEncontrado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioEncontrado,HttpStatus.FOUND);
    }

    //@GetMapping -> listar todos os usuarios
    //@GetMapping -> listar usuarios com parametros opcionais

    //@DeleteMapping -> excluir usuarios
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable(value = "id") int id, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioEncontrado =usuarioService.deletarUsuario(id);
        if(usuarioEncontrado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
