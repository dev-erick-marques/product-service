# Product Service
O **Product Service** é um microsserviço modular responsável pelo gerenciamento de produtos dentro da plataforma **Elevare Commerce**. Ele fornece endpoints para criação, listagem, atualização e remoção de produtos.

A aplicação utiliza **Consul** para service discovery e requer um **token JWT**, que deve ser obtido através do **Auth-Service**

[Ler em Inglês](README.md)

----
## Tecnologias utilizadas 
- Java 17+
- Spring Boot 3 
- Spring Security 
- Spring Data JPA 
- PostgreSQL 
- JWT (JSON Web Token)
- OAuth2 Resource Server 
- Maven

---
## JWT e Keys
Todos os microsserviços (incluindo o Product Service) devem usar a mesma chave pública que o Auth Service para validar tokens JWT.
- Certifique-se de que a chave pública esteja acessível a cada serviço, seja por meio de uma variável de ambiente ou de um arquivo de configuração.
- A chave privada permanece no Auth-Service apenas para assinar os tokens.
- Caso ainda não tenha um par de chaves, você pode gerar atraves deste [projeto](https://github.com/Dev-Erick-Marques/rsa256-key-pair-generator).
- Todos os endpoints são protegidos por token JWT. Obtenha um token em [Auth Service](https://github.com/Dev-Erick-Marques/auth-service).
----
## Pré-requisitos

- **Java 17+**
- **Consul** (em execução)
- **Auth-Service** (para geração de tokens JWT)
- **Postgres** (ou outro que preferir)

---
## Configuração do Consul

O projeto depende do **Consul** para registro e descoberta de serviços. 
1. Baixe o Consul através deste [link](https://developer.hashicorp.com/consul/install)
2. Execute em modo de desenvolvimento. `consul agent -dev`
3. O Consul web UI estará disponivel em ``localhost:8500``

---
## Funcionalidades Implementadas

- Domínios modulares: Cada domínio (Produto, Categoria) possui seus próprios controladores, serviços e DTOs.
- Tratamento de erros global compartilhado: Um GlobalExceptionHandler lida com exceções específicas de domínio e genéricas.

- Respostas de erro estruturadas:
- Suporta erros de validação em nível de campo com uma lista de erros.
- timestamps de data e hora UTC ISO 8601 truncados para milissegundos.
- Formato JSON consistente em todos os domínios.
- Princípio da Responsabilidade Única (SRP):
- O handler cria respostas de erro.
- Os DTOs armazenam detalhes do erro.
- Os módulos de domínio permanecem isolados.
- Suporte à validação: A Validação de Bean (@Valid, @NotNull, etc.) aciona automaticamente respostas estruturadas de 400.

---
## Endpoints Principais
### Produtos


| Método | Endpoint                   | Descrição                                   |
|--------|----------------------------|---------------------------------------------|
| GET    | ``/products``              | Lista todos os produtos                     |
| POST   | ``/products``              | Cadastra um novo produto                    |
| GET    | ``/products/{id}``         | Busca produto por ID                        |
| DELETE | ``/products/{id}``         | Realizar exclusão lógica de produtos por ID |
| PATCH  | ``/products/{id}/restore`` | Restaurar produto excluído logicamente      |

### Categorias

| Método | Endpoint             | Descrição                   |
|--------|----------------------|-----------------------------|
| GET    | ``/categories``      | Lista todas as categorias   |
| POST   | ``/categories``      | Cadastra uma nova categoria |
| GET    | ``/categories/{id}`` | Busca categoria por ID      |

---
## Próximos passos
- Adicionar uma validação para que, quando um item for excluído logicamente, ele não apareça na lista de produtos ou categorias.
- Adicionar Endpoint para atualizar produtos / categorias
- Adicionar Endpoint para deletar categorias
- Implementação de Roles nos Endpoints
---
## Observações
- Caso desejar escolher outro banco de dados, deverá atualizar as dependencias no ``pom.xml`` para que suporte o flyway
---
## Changelog
- Veja o [Changelog](CHANGELOG.md) para detalhes de todas as modificações.

