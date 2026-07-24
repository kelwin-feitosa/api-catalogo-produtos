# 🛒 API REST para Gerenciamento de Supermercado

API REST desenvolvida com **Java 21** e **Spring Boot 3** com o objetivo de simular um sistema de gerenciamento de supermercado.

O projeto aplica boas práticas de desenvolvimento backend utilizando arquitetura em camadas, Spring Data JPA, Jakarta Validation, DTOs, tratamento global de exceções e regras de negócio.

O sistema contempla o gerenciamento de **produtos, categorias, clientes, fornecedores, carrinhos de compras, compras e vendas**, sendo desenvolvido com foco em organização, escalabilidade e boas práticas utilizadas no mercado.

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

- **Controller** → responsável pela exposição dos endpoints REST.
- **Service** → contém as regras de negócio da aplicação.
- **Repository** → realiza a comunicação com o banco de dados utilizando Spring Data JPA.
- **Model** → entidades persistidas utilizando JPA/Hibernate.
- **DTO** → objetos utilizados para entrada e saída de dados.
- **Exception Handler** → tratamento centralizado de erros e respostas padronizadas.

---

# 📂 Modelagem do Sistema

O sistema possui as seguintes entidades:

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

Principais relacionamentos:

- Uma **Categoria** possui vários produtos.
- Um **Produto** pertence a uma categoria.
- Um **Cliente** possui um carrinho.
- Um **Carrinho** possui vários itens.
- Um **ItemCarrinho** representa um produto dentro de um carrinho.
- Uma **Venda** pertence a um cliente.
- Uma **Venda** possui vários itens vendidos.
- Uma **Compra** pertence a um fornecedor.
- Uma **Compra** possui vários itens comprados.

---

# 📋 Funcionalidades

## Implementadas

- ✅ Modelagem das entidades JPA
- ✅ Relacionamentos entre entidades
- ✅ DTOs de Request e Response
- ✅ Validação utilizando Jakarta Validation
- ✅ CRUD de produtos
- ✅ CRUD de categorias
- ✅ CRUD de clientes
- ✅ Gerenciamento de carrinho de compras
- ✅ Adição de produtos ao carrinho
- ✅ Alteração de quantidade dos itens
- ✅ Remoção de itens do carrinho
- ✅ Limpeza completa do carrinho
- ✅ Cálculo automático de subtotal dos itens
- ✅ Cálculo automático do valor total
- ✅ Registro de vendas
- ✅ Conversão de carrinho em venda
- ✅ Baixa automática de estoque após venda
- ✅ Validação de estoque disponível
- ✅ Tratamento global de exceções

---

# 🛡️ Validação

Os dados recebidos pela API são validados utilizando **Jakarta Validation**.

Validações implementadas:

- Campos obrigatórios
- Valores positivos
- E-mail válido
- CNPJ com formato correto
- Estoque não negativo
- Limitação de tamanho de campos
- Validação de quantidade de produtos

---

# 📦 Regras de Negócio

Algumas regras implementadas:

### Carrinho

- Um cliente pode possuir um carrinho.
- Produtos adicionados ao carrinho possuem quantidade e preço registrado.
- Caso o produto já exista no carrinho, sua quantidade é atualizada.
- Não é permitido adicionar quantidade superior ao estoque disponível.

### Venda

- Não é possível finalizar uma venda com carrinho vazio.
- Ao realizar uma venda:
  - Os itens do carrinho são transformados em itens da venda.
  - O estoque dos produtos é atualizado automaticamente.
  - O carrinho é limpo após a conclusão.

### Estoque

- O sistema verifica disponibilidade antes de adicionar ou vender produtos.
- A baixa do estoque ocorre automaticamente após uma venda.

---

# ❌ Tratamento de Erros

A API possui tratamento global de exceções utilizando `@ControllerAdvice`.

Exemplo de resposta:

```json
{
  "mensagem": "Dados enviados não passam nas regras de validação.",
  "detalhes": "O preço deve ser maior que zero.",
  "timestamp": "2026-07-09T20:05:32"
}

```

Exceções tratadas:

- Produto não encontrado
- Categoria não encontrada
- Cliente não encontrado
- Fornecedor não encontrado
- Carrinho não encontrado
- Item do carrinho não encontrado
- Venda não encontrada
- Produto já existente
- Categoria já existente
- Cliente já cadastrado
- CNPJ já cadastrado
- Estoque insuficiente
- Carrinho vazio
- Erros de validação
- JSON inválido

---

# 🌐 Endpoints

## Produtos

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | `/produtos` | Lista todos os produtos |
| GET | `/produtos/{id}` | Busca produto por ID |
| POST | `/produtos` | Cadastra um produto |
| PUT | `/produtos/{id}` | Atualiza um produto |
| DELETE | `/produtos/{id}` | Remove um produto |

---

## Carrinhos

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | `/carrinhos/{idCliente}` | Cria um carrinho para um cliente |
| POST | `/carrinhos/itens` | Adiciona produto ao carrinho |
| PUT | `/carrinhos/itens` | Altera quantidade de um item |
| DELETE | `/carrinhos/itens` | Remove item do carrinho |
| DELETE | `/carrinhos/{idCarrinho}` | Limpa todos os itens do carrinho |

---

## Vendas

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | `/vendas/{idCarrinho}` | Finaliza uma venda utilizando o carrinho |
| GET | `/vendas/{idVenda}` | Busca uma venda por ID |
| GET | `/vendas` | Lista todas as vendas |

---

# 📥 Exemplos de Requisição

## Cadastro de Produto

```json
{
  "nome": "Arroz 5kg",
  "preco": 29.90,
  "descricao": "Arroz branco tipo 1",
  "quantidadeEstoque": 50,
  "categoriaId": 1
}
```

---

## Adicionar Produto ao Carrinho

```json
{
  "carrinhoId": 1,
  "produtoId": 1,
  "quantidade": 2
}
```

---

# 📤 Exemplos de Respostas

## Produto

```json
{
  "id": 1,
  "nome": "Arroz 5kg",
  "preco": 29.90,
  "descricao": "Arroz branco tipo 1",
  "quantidadeEstoque": 50,
  "categoriaId": 1,
  "dataCadastro": "2026-07-15T14:30:52"
}
```

---

## Venda

```json
{
  "id": 1,
  "clienteId": 1,
  "dataVenda": "2026-07-23T15:30:00",
  "valorTotal": 59.80,
  "itens": [
    {
      "produtoId": 1,
      "nomeProduto": "Arroz 5kg",
      "quantidade": 2,
      "precoUnitario": 29.90,
      "subtotal": 59.80
    }
  ]
}
```

---

# 🎯 Objetivos do Projeto

Este projeto tem como objetivo aprofundar conhecimentos em:

- Desenvolvimento backend com Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Arquitetura em camadas
- Modelagem de banco de dados relacional
- Desenvolvimento de APIs REST
- DTOs
- Validação de dados
- Tratamento de exceções
- Regras de negócio
- Boas práticas de programação

---

# 🚀 Próximos Passos

- Implementar gerenciamento de fornecedores
- Implementar registro de compras
- Atualizar estoque através de compras
- Adicionar documentação com Swagger/OpenAPI
- Criar testes unitários
- Criar testes de integração
- Adicionar autenticação e autorização com Spring Security
- Migrar banco H2 para PostgreSQL
- Criar ambiente Docker
- Preparar deploy da aplicação

---

# 👨‍💻 Autor

Kelwin

Projeto desenvolvido para estudo e evolução profissional na área de desenvolvimento backend utilizando Java e Spring Boot.