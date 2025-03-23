package main.java.com.example.byteStore.service;

import main.java.com.example.byteStore.dto.ProdutoDtoCreate;
import main.java.com.example.byteStore.dto.ProdutoDtoUpdate;
import main.java.com.example.byteStore.model.Produto;
import main.java.com.example.byteStore.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrarProduto(ProdutoDtoCreate produtoDtoCreate) {
        Produto produtoExistente = produtoRepository.findByNome(produtoDtoCreate.nome());

        if (produtoExistente != null) {
            return produtoExistente;
        }

        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDtoCreate, produto);
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Integer id, ProdutoDtoUpdate produtoDtoUpdate) {
        Produto produtoEncontrado = produtoRepository.findById(id).orElse(null);

        if (produtoEncontrado == null) {
            return null;
        }

        Produto produtoExistente = produtoRepository.findByNome(produtoDtoUpdate.nome());
        if (produtoExistente != null) {
            return produtoExistente;
        }

        BeanUtils.copyProperties(produtoDtoUpdate, produtoEncontrado, "id");
        return produtoRepository.save(produtoEncontrado);
    }

    public Produto mostrarProduto(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Iterable<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Iterable<Produto> buscarProdutos(String nome, String categoria, String marca) {
        if (nome != null && !nome.isEmpty()) {
            return produtoRepository.findByNomeContaining(nome);
        }
        if (categoria != null && !categoria.isEmpty()) {
            return produtoRepository.findByCategoria(categoria);
        }
        if (marca != null && !marca.isEmpty()) {
            return produtoRepository.findByMarca(marca);
        }
        return produtoRepository.findAll();
    }

    public Produto deletarProduto(Integer id) {
        Produto produtoEncontrado = produtoRepository.findById(id).orElse(null);

        if (produtoEncontrado == null) {
            return null;
        }

        produtoRepository.delete(produtoEncontrado);
        return produtoEncontrado;
    }
}
