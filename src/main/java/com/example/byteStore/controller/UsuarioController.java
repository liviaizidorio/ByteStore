package com.example.byteStore.controller;

import jakarta.validation.Valid;
import com.example.byteStore.dto.LoginDtoRequest;
import com.example.byteStore.dto.UsuarioDtoCreate;
import com.example.byteStore.dto.UsuarioDtoUpdate;
import com.example.byteStore.model.Usuario;
import com.example.byteStore.service.UsuarioService;
import com.example.byteStore.util.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://127.0.0.1:5500")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value = "/post", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "http://127.0.0.1:5500")
                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .build();
    }
    @PostMapping(value = "/post")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody UsuarioDtoCreate usuarioDtoCreate, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> errors = ErrorHandler.processValidationErrors(bindingResult);
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioCriado =usuarioService.cadastroUsuario(usuarioDtoCreate);
        if (usuarioCriado.getId() == null){
            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(usuarioCriado,HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUsuario(@Valid @RequestBody LoginDtoRequest loginDtoResquest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> errors = ErrorHandler.processValidationErrors(bindingResult);
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioAutenticado = usuarioService.login(loginDtoResquest);
        if (usuarioAutenticado == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (usuarioAutenticado.getEmail() == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable(value = "id") int id,@Valid @RequestBody UsuarioDtoUpdate usuarioDtoUpdate,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<String> errors = ErrorHandler.processValidationErrors(bindingResult);
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> mostrarUsuario(@PathVariable(value = "id") int id){
        Usuario usuarioEncontrado =usuarioService.mostrarUsuario(id);
        if(usuarioEncontrado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(usuarioEncontrado,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable(value = "id") int id){
        Usuario usuarioEncontrado =usuarioService.deletarUsuario(id);
        if(usuarioEncontrado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
