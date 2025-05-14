package br.com.fiap.cp.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pedido {
    private Long id;
    private String produto;
    private int quantidade;
}
