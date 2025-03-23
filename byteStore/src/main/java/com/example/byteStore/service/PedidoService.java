package main.java.com.example.byteStore.service;

import main.java.com.example.byteStore.dto.PedidoDtoUpdate;
import main.java.com.example.byteStore.model.Carrinho;
import main.java.com.example.byteStore.model.Pedido;
import main.java.com.example.byteStore.model.Usuario;
import main.java.com.example.byteStore.repository.CarrinhoRepository;
import main.java.com.example.byteStore.repository.PedidoRepository;
import main.java.com.example.byteStore.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, CarrinhoRepository carrinhoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.carrinhoRepository = carrinhoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Pedido criarPedido(int idCarrinho, int idUsuario) {
        Pedido pedido = new Pedido();

        Carrinho carrinhoExistente = carrinhoRepository.findById(idCarrinho);
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario);


        if(carrinhoExistente == null || usuarioExistente == null){
            return pedido;
        }

        pedido = new Pedido(new Date(),"APROVADO",usuarioExistente,carrinhoExistente);
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Integer id, PedidoDtoUpdate pedidoDtoUpdate) {
        Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
        if (pedidoExistente.isEmpty()) {
            return null;
        }

        Pedido pedido = pedidoExistente.get();
        pedido.setStatus(pedidoDtoUpdate.status());
        return pedidoRepository.save(pedido);
    }

    public Pedido mostrarPedido(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public boolean deletarPedido(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
