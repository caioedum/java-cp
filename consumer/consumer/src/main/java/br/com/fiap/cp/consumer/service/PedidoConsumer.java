package br.com.fiap.cp.consumer.service;

import br.com.fiap.cp.consumer.model.Pedido;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoConsumer {

    @RabbitListener(queues = "fila.pedidos")
    public void consumirPedido(Pedido pedido) {
        System.out.println("Pedido recebido:");
        System.out.println("ID: " + pedido.getId());
        System.out.println("Produto: " + pedido.getProduto());
        System.out.println("Quantidade: " + pedido.getQuantidade());
    }
}
