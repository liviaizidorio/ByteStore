package main.java.com.example.byteStore.service;

import main.java.com.example.byteStore.model.Carrinho;
import main.java.com.example.byteStore.model.CarrinhoProduto;
import main.java.com.example.byteStore.model.Produto;
import main.java.com.example.byteStore.repository.CarrinhoRepository;
import main.java.com.example.byteStore.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarrinhoService {
    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoRepository produtoRepository;


    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoRepository produtoService) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoRepository = produtoService;
    }

    public Carrinho atualizarItens(int idProduto, int quantidade){
        Produto produtoEncontrado = produtoRepository.findById(idProduto);

        if (produtoEncontrado == null){
            return null;
        }
        double valor = produtoEncontrado.getPreco()*quantidade;

        var carrinho = new Carrinho();
        carrinho.adicionarProduto(produtoEncontrado);
        carrinho.setValorTotal(carrinho.getValorTotal()+valor);

        return carrinhoRepository.save(carrinho);
    }
    public List<Produto> listarItens(int idCarrinhoProduto){
        return carrinhoRepository.findById(idCarrinhoProduto).getItens()
                .stream().map(CarrinhoProduto::getProduto).toList();
    }
}
