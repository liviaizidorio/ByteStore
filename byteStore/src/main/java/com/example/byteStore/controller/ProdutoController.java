package main.java.com.example.byteStore.controller;

import jakarta.validation.Valid;
import main.java.com.example.byteStore.dto.ProdutoDtoCreate;
import main.java.com.example.byteStore.dto.ProdutoDtoUpdate;
import main.java.com.example.byteStore.model.Produto;
import main.java.com.example.byteStore.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/")
    public ResponseEntity<?> cadastrarProduto(@Valid @RequestBody ProdutoDtoCreate produtoDtoCreate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Produto produtoCriado = produtoService.cadastrarProduto(produtoDtoCreate);
        if (produtoCriado == null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarProduto(@PathVariable(value = "id") Integer id, @Valid @RequestBody ProdutoDtoUpdate produtoDtoUpdate, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Produto produtoAtualizado = produtoService.atualizarProduto(id, produtoDtoUpdate);
        if (produtoAtualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarProduto(@PathVariable(value = "id") Integer id) {
        Produto produtoEncontrado = produtoService.mostrarProduto(id);
        if (produtoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(produtoEncontrado, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarProdutos(@RequestParam(required = false) String nome,
                                            @RequestParam(required = false) String categoria,
                                            @RequestParam(required = false) String marca) {
        Iterable<Produto> produtos = produtoService.buscarProdutos(nome, categoria, marca);
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto(@PathVariable(value = "id") Integer id) {
        Produto produtoDeletado = produtoService.deletarProduto(id);
        if (produtoDeletado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
