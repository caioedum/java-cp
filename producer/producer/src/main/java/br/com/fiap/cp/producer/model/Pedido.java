package br.com.fiap.cp.producer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pedido {
    private Long id;
    private String produto;
    private int quantidade;
}
