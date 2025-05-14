package br.com.fiap.cp.consumer.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import br.com.fiap.cp.consumer.model.Pedido;

@Configuration
@Slf4j
@Service
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;

    @Bean
    public Queue filaPedidos() {
        return new Queue(queueName, true); // true = fila durável
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @RabbitListener(queues = "fila.pedidos")
    public void consumirPedido(Pedido pedido) {
        log.info("Pedido recebido: {}", pedido);
    }
}
