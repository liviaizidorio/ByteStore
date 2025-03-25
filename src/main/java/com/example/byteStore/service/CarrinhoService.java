package com.example.byteStore.service;

import com.example.byteStore.model.Carrinho;
import com.example.byteStore.model.CarrinhoProduto;
import com.example.byteStore.model.Produto;
import com.example.byteStore.model.Usuario;
import com.example.byteStore.repository.CarrinhoRepository;
import com.example.byteStore.repository.ProdutoRepository;
import com.example.byteStore.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;

    private final UsuarioRepository usuarioRepository;


    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoService, UsuarioRepository usuarioRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoService;
        this.usuarioRepository = usuarioRepository;
    }

    public Carrinho inicializarCarrinho(int idUsuario){
        Usuario usuario = usuarioRepository.findById(idUsuario);
        if (usuario == null){
            return null;
        }
        Carrinho carrinho =carrinhoRepository.findByUsuario(usuario);
        if (carrinho == null){
            Carrinho novoCarrinho = new Carrinho();
            novoCarrinho.setUsuario(usuario);
            novoCarrinho.setValorTotal(0);
            novoCarrinho.setItens(new ArrayList<>());
            return carrinhoRepository.save(novoCarrinho);
        }
        return carrinho;

    }

    public Carrinho atualizarItens(int idUsuario, int idProduto, int quantidade) {
        Produto produtoEncontrado = produtoRepository.findById(idProduto);

        if (produtoEncontrado == null) {
            return null;
        }

        Carrinho carrinhoExistente = inicializarCarrinho(idUsuario);

        Optional<CarrinhoProduto> itemExistente = carrinhoExistente.getItens()
                .stream()
                .filter(item -> item.getProduto().getId().equals(idProduto))
                .findFirst();

        if (itemExistente.isPresent()) {
            itemExistente.get().setQuantidade(quantidade);
        } else {
            CarrinhoProduto novoItem = new CarrinhoProduto();
            novoItem.setCarrinho(carrinhoExistente);
            novoItem.setProduto(produtoEncontrado);
            novoItem.setQuantidade(quantidade);

            carrinhoExistente.getItens().add(novoItem);
        }

        double valor = produtoEncontrado.getPreco() * quantidade;
        carrinhoExistente.setValorTotal(valor);

        return carrinhoRepository.save(carrinhoExistente);
    }
    public List<Produto> listarItens(int idCarrinhoProduto){
        return carrinhoRepository.findById(idCarrinhoProduto).getItens()
                .stream().map(CarrinhoProduto::getProduto).toList();
    }
}
