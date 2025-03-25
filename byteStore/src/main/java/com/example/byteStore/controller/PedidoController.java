package com.example.byteStore.controller;

import com.example.byteStore.dto.PedidoDtoUpdate;
import com.example.byteStore.model.Pedido;
import com.example.byteStore.service.PedidoService;
import com.example.byteStore.util.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public ResponseEntity<?> criarPedido(@RequestParam("idCarrinho") int idCarrinho, @RequestParam("idUsuario") int idUsuario) {
        Pedido pedidoCriado = pedidoService.criarPedido(idCarrinho, idUsuario);
        if (pedidoCriado.getId() == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pedidoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPedido(@PathVariable(value = "id") Integer id, @RequestBody PedidoDtoUpdate pedidoDtoUpdate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<String> errors = ErrorHandler.processValidationErrors(bindingResult);
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }
        Pedido pedidoAtualizado =pedidoService.atualizarPedido(id,pedidoDtoUpdate);
        if(pedidoAtualizado == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pedidoAtualizado,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarPedido(@PathVariable(value = "id") Integer id) {
        Pedido pedido = pedidoService.mostrarPedido(id);
        if (pedido == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable(value = "id") Integer id) {
        boolean deletado = pedidoService.deletarPedido(id);
        if (!deletado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
