package main.java.com.example.byteStore.controller;

import main.java.com.example.byteStore.model.Carrinho;
import main.java.com.example.byteStore.model.Produto;
import main.java.com.example.byteStore.service.CarrinhoService;
import main.java.com.example.byteStore.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    //iniciar
    //@PostMapping(value = "/")
    //public ResponseEntity<?> iniciarCarrinho(){
    //    Carrinho carrinhoCriado =
    //}

    //atualizar
    @PutMapping(value = "{idUsuario}/{idProduto}/{idQuantidade}")
    public ResponseEntity<?> atualizarItens(@PathVariable(value = "idUsuario") int idUsuario,@PathVariable(value = "idProduto") int idProduto, @PathVariable(value = "idQuantidade") int idQuantidade){
        Carrinho carrinho = carrinhoService.atualizarItens(idUsuario,idProduto,idQuantidade);

        if (carrinho == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carrinho,HttpStatus.OK);
    }
    @GetMapping(value = "/{idCarrinho}")
    public ResponseEntity<?> listarItens(@PathVariable(value ="idCarrinho") int idCarrinho){
        List<Produto> produtos = carrinhoService.listarItens(idCarrinho);

        if (produtos == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produtos,HttpStatus.OK);
    }

    //deletar carrinho

}
