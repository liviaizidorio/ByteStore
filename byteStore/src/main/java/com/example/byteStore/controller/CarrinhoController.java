package main.java.com.example.byteStore.controller;

import main.java.com.example.byteStore.model.Carrinho;
import main.java.com.example.byteStore.service.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    private CarrinhoService carrinhoService;

    //iniciar
    //@PostMapping(value = "/")
    //public ResponseEntity<?> iniciarCarrinho(){
    //    Carrinho carrinhoCriado =
    //}

    //atualizar
    @PutMapping(value = "/")
    public ResponseEntity<?> atualizarItens(int idProduto, int idQuantidade){
        Carrinho carrinho = carrinhoService.atualizarItens(idProduto,idQuantidade);

        if (carrinho == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carrinho,HttpStatus.OK);
    }

    //listar itens
    //deletar carrinho

}
