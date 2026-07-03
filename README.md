# 📦 API REST de Gerenciamento de Produtos

Esta é uma API RESTful desenvolvida utilizando **Spring Boot 3** e **Java 21** para o gerenciamento básico de um catálogo de produtos. O objetivo deste projeto foi aplicar os conceitos essenciais do ecossistema Spring voltados para o desenvolvimento backend de alto desempenho.

---

## 🚀 Tecnologias Utilizadas

* **Java 21** (Linguagem de programação)
* **Spring Boot 3** (Framework)
* **Spring Data JPA** (Persistência de dados e ORM)
* **H2 Database** (Banco de dados em memória para testes rápidos)
* **Maven** (Gerenciador de dependências)

---

## 🏗️ Padrão de Arquitetura e Organização

O projeto adota os padrões de design de software recomendados pelo mercado, dividindo a aplicação em camadas bem definidas de responsabilidade:
* **Model:** Contém as entidades que representam as tabelas do banco de dados (mapeadas com JPA).
* **Repository:** Interfaces responsáveis pela comunicação e queries com o banco de dados.
* **Controller:** Controladores REST que expõem os endpoints da API e tratam as requisições HTTP.

---

## 🛣️ Endpoints da API (Padrão RESTful)

A API gerencia os produtos através das seguintes rotas sob o prefixo `/api/produtos`:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **`GET`** | `/api/produtos` | Retorna a lista de todos os produtos. |
| **`POST`** | `/api/produtos` | Cadastra um novo produto enviando um JSON no corpo. |
| **`PUT`** | `/api/produtos/{id}` | Atualiza todos os dados de um produto existente pelo ID. |
| **`DELETE`** | `/api/produtos/{id}` | Remove um produto do catálogo permanentemente pelo ID. |

### Exemplo de JSON para Cadastro/Atualização (`POST` / `PUT`)
```json
{
  "nome": "Teclado Mecânico RGB",
  "preco": 299.90
}