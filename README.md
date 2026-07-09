# 📦 API REST de Gerenciamento de Produtos

API REST desenvolvida com **Java 21** e **Spring Boot 3** para gerenciamento de um catálogo de produtos. O projeto foi criado com o objetivo de aplicar boas práticas de desenvolvimento backend, utilizando arquitetura em camadas, validação de dados, tratamento global de exceções e persistência com Spring Data JPA.

---

# 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Data JPA
- Jakarta Validation
- H2 Database
- Maven

---

# 🏗️ Arquitetura

A aplicação foi organizada seguindo o padrão em camadas:

- **Controller** → expõe os endpoints REST.
- **Service** → contém as regras de negócio.
- **Repository** → comunicação com o banco de dados.
- **Model** → entidades JPA.
- **DTO** → objetos utilizados para entrada e saída de dados.
- **Exception Handler** → tratamento centralizado de erros.

---

# 📋 Funcionalidades

- ✅ Cadastro de produtos
- ✅ Listagem de todos os produtos
- ✅ Busca de produto por ID
- ✅ Atualização de produtos
- ✅ Remoção de produtos
- ✅ Validação dos dados recebidos
- ✅ Tratamento global de exceções
- ✅ Respostas padronizadas para erros

---

# 📦 Estrutura da entidade Produto

| Campo | Tipo |
|-------|------|
| id | Long |
| nome | String |
| preco | BigDecimal |
| descricao | String |
| quantidadeEstoque | Integer |
| dataCadastro | LocalDateTime |

---

# 🛡️ Validação

Os dados enviados são validados utilizando Jakarta Validation.

Exemplos:

- Nome obrigatório
- Preço obrigatório
- Preço maior ou igual a zero
- Estoque obrigatório
- Estoque maior ou igual a zero

---

# ❌ Tratamento de erros

A API responde mensagens padronizadas para situações como:

- Produto inexistente
- Dados inválidos
- JSON malformado
- Erros internos

Exemplo:

```json
{
  "mensagem": "Dados enviados não passam nas regras de validação.",
  "detalhes": "O preço não pode ser negativo.",
  "timestamp": "2026-07-09T20:05:32"
}
```

---

# 🌐 Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| GET | /api/produtos | Lista todos os produtos |
| GET | /api/produtos/{id} | Busca um produto pelo ID |
| POST | /api/produtos | Cadastra um produto |
| PUT | /api/produtos/{id} | Atualiza um produto |
| DELETE | /api/produtos/{id} | Remove um produto |

---

# 📥 Exemplo de requisição

```json
{
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90,
  "descricao": "Teclado mecânico ABNT2 com iluminação RGB",
  "quantidadeEstoque": 15
}
```

---

# 📤 Exemplo de resposta

```json
{
  "id": 1,
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90,
  "descricao": "Teclado mecânico ABNT2 com iluminação RGB",
  "quantidadeEstoque": 15
}
```