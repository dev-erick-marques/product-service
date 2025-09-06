# Product Service
O **Product Service** é um microsserviço responsável pelo gerenciamento de produtos dentro da plataforma de e-commerce.  
Ele fornece endpoints para **criação, listagem, atualização e remoção de produtos**, faz parte do ecossistema de microsserviços do projeto Elevare Commerce.

## Tecnologias 
- Java 17+
- Spring Boot 3
- Maven
- Docker (opcional para deploy)
- Consul

## Endpoints Principais
| Método | Endpoint             | Descrição                |
| ------ | -------------------- | ------------------------ |
| POST   | `/api/products`      | Cadastrar novo produto   |
| GET    | `/api/products`      | Listar todos os produtos |
| GET    | `/api/products/{id}` | Buscar produto por ID    |
| DELETE | `/api/products/{id}` | Remover produto          |

## Próximos passos
- Implementação do Spring Security para autenticação por JWT
- Adicionar Endpoint para atualizar produtos
- Implementação de Roles nos Endpoints
- Integração com outros microsserviços
