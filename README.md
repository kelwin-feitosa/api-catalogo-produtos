# 🛒 API REST para Gerenciamento de Supermercado

API REST desenvolvida com **Java 21** e **Spring Boot 3** com o objetivo de simular o gerenciamento de um supermercado. O projeto está sendo desenvolvido para aplicar boas práticas de desenvolvimento backend utilizando arquitetura em camadas, Spring Data JPA, Jakarta Validation e persistência de dados.

O sistema contempla o gerenciamento de **produtos, categorias, clientes, fornecedores, carrinhos de compras, compras e vendas**, sendo implementado de forma incremental.

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Jakarta Validation
- H2 Database
- Maven
- Git

---

# 🏗️ Arquitetura

A aplicação segue uma arquitetura em camadas:

- **Controller** → expõe os endpoints REST.
- **Service** → contém as regras de negócio.
- **Repository** → comunicação com o banco de dados.
- **Model** → entidades JPA.
- **DTO** → objetos utilizados para entrada e saída de dados.
- **Exception Handler** → tratamento centralizado de erros.

---

# 📂 Modelagem do Sistema

O sistema é composto pelas seguintes entidades:

- Categoria
- Produto
- Cliente
- Fornecedor
- Carrinho
- ItemCarrinho
- Compra
- ItemCompra
- Venda
- ItemVenda

Relacionamentos principais:

- Uma categoria possui vários produtos.
- Um cliente possui um carrinho.
- Um carrinho possui vários itens.
- Uma compra pertence a um fornecedor.
- Uma compra possui vários itens.
- Uma venda pertence a um cliente.
- Uma venda possui vários itens.

---

# 📋 Funcionalidades

## Implementadas

- ✅ Modelagem das entidades JPA
- ✅ Relacionamentos entre entidades
- ✅ DTOs de Request e Response
- ✅ Validação utilizando Jakarta Validation
- ✅ CRUD de produtos
- ✅ Tratamento global de exceções

## Em desenvolvimento

- 🚧 CRUD de categorias
- 🚧 CRUD de clientes
- 🚧 CRUD de fornecedores
- 🚧 Gerenciamento de carrinhos
- 🚧 Registro de compras
- 🚧 Registro de vendas
- 🚧 Atualização automática do estoque

---

# 🛡️ Validação

Os dados recebidos pela API são validados utilizando **Jakarta Validation**.

Exemplos de validações implementadas:

- Campos obrigatórios
- E-mail válido
- CNPJ com formato correto
- Valores positivos
- Estoque não negativo
- Tamanho máximo para textos

---

# ❌ Tratamento de Erros

A API possui tratamento global de exceções para retornar respostas padronizadas.

Exemplo:

```json
{
  "mensagem": "Dados enviados não passam nas regras de validação.",
  "detalhes": "O preço deve ser maior que zero.",
  "timestamp": "2026-07-09T20:05:32"
}
```

---

# 🌐 Endpoints

Atualmente a API possui endpoints para gerenciamento de produtos.

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | /api/produtos | Lista todos os produtos |
| GET | /api/produtos/{id} | Busca um produto por ID |
| POST | /api/produtos | Cadastra um produto |
| PUT | /api/produtos/{id} | Atualiza um produto |
| DELETE | /api/produtos/{id} | Remove um produto |

Novos endpoints serão adicionados conforme o desenvolvimento das demais funcionalidades.

---

# 📥 Exemplo de Requisição

```json
{
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90,
  "descricao": "Teclado mecânico ABNT2 com iluminação RGB",
  "quantidadeEstoque": 15,
  "categoriaId": 1
}
```

---

# 📤 Exemplo de Resposta

```json
{
  "id": 1,
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90,
  "descricao": "Teclado mecânico ABNT2 com iluminação RGB",
  "quantidadeEstoque": 15,
  "categoriaId": 1,
  "dataCadastro": "2026-07-15T14:30:52"
}
```

---

# 🎯 Objetivos do Projeto

Este projeto tem como objetivo aprofundar conhecimentos em:

- Spring Boot
- Spring Data JPA
- Arquitetura em camadas
- Modelagem de banco de dados relacional
- DTOs
- Validação de dados
- Tratamento de exceções
- Boas práticas no desenvolvimento de APIs REST

---

# 🚀 Próximos Passos

- Implementar Services
- Implementar Controllers
- Implementar CRUD completo de todas as entidades
- Atualizar estoque automaticamente em compras e vendas
- Adicionar documentação com Swagger/OpenAPI
- Criar testes unitários
- Migrar do H2 para PostgreSQL