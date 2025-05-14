# Projeto Spring Boot RabbitMQ - Producer \& Consumer

Este projeto demonstra a comunicação assíncrona entre dois microsserviços (Producer e Consumer) utilizando Spring Boot e RabbitMQ.

## Visão Geral

- **Producer**: Expõe um endpoint REST `/api/pedido` para receber pedidos e enviá-los para a fila RabbitMQ `fila.pedidos`.
- **Consumer**: Escuta a fila `fila.pedidos` e exibe os dados do pedido recebido no console.


## Tecnologias

- Java 21
- Spring Boot
- RabbitMQ
- Maven
- Docker (opcional, para subir o RabbitMQ)


## Como executar

### 1. Suba o RabbitMQ (opcional)

Você pode usar Docker para subir o RabbitMQ rapidamente:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

A interface de administração estará disponível em [http://localhost:15672](http://localhost:15672)
Usuário/senha padrão: `user` / `secret`

### 2. Execute o Producer

No terminal, dentro da pasta do producer:

```bash
mvn clean install
mvn spring-boot:run
```


### 3. Execute o Consumer

No terminal, dentro da pasta do consumer:

```bash
mvn clean install
mvn spring-boot:run
```


### 4. Envie um pedido

Faça uma requisição POST para o endpoint do producer:

```
POST http://localhost:8081/api/pedido
Content-Type: application/json

{
  "id": 1,
  "produto": "Livro de Java",
  "quantidade": 3
}
```


### 5. Veja o resultado

O consumer exibirá no console os dados do pedido recebido.

---

## Observações

- Configure as propriedades do RabbitMQ em `application.properties` se necessário.
- Certifique-se de que as portas 5672 (RabbitMQ), 8080 (Consumer) e 8081 (Producer) estão livres.


