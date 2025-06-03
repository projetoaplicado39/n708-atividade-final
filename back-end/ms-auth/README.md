# MS-Auth

## Visão Geral

O **MS-Auth** é um microserviço de autenticação desenvolvido em Java com Spring Boot, utilizando MongoDB como banco de dados e JWT para autenticação. O projeto suporta autenticação, registro, atualização de perfil, refresh de tokens, integração com RabbitMQ para eventos e documentação via OpenAPI/Swagger.

---

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Variáveis de Ambiente](#variáveis-de-ambiente)
- [Execução Local](#execução-local)
- [Execução com Docker](#execução-com-docker)
- [Endpoints Principais](#endpoints-principais)
- [Fluxo de Autenticação](#fluxo-de-autenticação)
- [Mensageria com RabbitMQ](#mensageria-com-rabbitmq)
- [Testes](#testes)
- [Documentação da API](#documentação-da-api)
- [Licença](#licença)

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Security
- Spring Data MongoDB
- Spring Cloud OpenFeign
- JWT (JSON Web Token)
- RabbitMQ (mensageria)
- Maven
- Docker
- Swagger/OpenAPI

---

## Estrutura de Pastas

```
ms-auth/
├── src/
│   ├── main/
│   │   ├── java/com/edupath/msauth/
│   │   │   ├── config/           # Configurações (CORS, RabbitMQ, OpenAPI)
│   │   │   ├── controller/       # Controllers REST (Auth, User)
│   │   │   ├── event/            # Eventos e publishers RabbitMQ
│   │   │   ├── exception/        # Tratamento global de exceções
│   │   │   ├── model/            # Modelos de domínio (User, Role, RefreshToken)
│   │   │   ├── payload/          # DTOs de request e response
│   │   │   ├── repository/       # Repositórios MongoDB
│   │   │   └── security/         # Configurações e serviços de segurança/JWT
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação
│   └── test/
│       └── java/com/edupath/msauth/   # Testes automatizados
├── Dockerfile
├── pom.xml
└── README.md
```

---

## Configuração do Ambiente

1. **Pré-requisitos:**

   - Java 21+
   - Maven 3.9+
   - MongoDB (local ou Atlas)
   - RabbitMQ (local ou cloud)
   - Docker (opcional)

2. **Configuração do MongoDB:**

   - Defina a URI do MongoDB em `application.properties` ou via variável de ambiente.

3. **Configuração do RabbitMQ:**
   - Configure host, porta, usuário e senha em `application.properties` ou variáveis de ambiente.

---

## Variáveis de Ambiente

As principais configurações podem ser sobrescritas por variáveis de ambiente, especialmente ao rodar via Docker:

- `SERVER_PORT` (porta do serviço, padrão: 8080)
- `MONGODB_URI` (URI do MongoDB)
- `JWT_SECRET` (chave secreta do JWT)
- `JWT_EXPIRATION` (expiração do JWT em ms)
- `JWT_REFRESH_EXPIRATION` (expiração do refresh token em ms)
- `RABBITMQ_HOST`, `RABBITMQ_PORT`, `RABBITMQ_USERNAME`, `RABBITMQ_PASSWORD`

---

## Execução Local

```sh
# Instale as dependências e gere o jar
./mvnw clean package

# Execute a aplicação
java -jar target/ms-auth-0.0.1-SNAPSHOT.jar
```

---

## Execução com Docker

```sh
# Build da imagem
docker build -t ms-auth .

# Execução do container
docker run -p 8080:8080 --env-file .env ms-auth
```

> Crie um arquivo `.env` com as variáveis de ambiente necessárias.

---

## Endpoints Principais

### Autenticação

- `POST /api/auth/signin` — Login do usuário (retorna JWT e refresh token)
- `POST /api/auth/signup` — Registro de novo usuário
- `POST /api/auth/refreshtoken` — Gera novo JWT a partir do refresh token
- `POST /api/auth/signout` — Logout (invalida refresh tokens)

### Usuário

- `GET /api/user/profile` — Retorna dados do usuário autenticado
- `PUT /api/user/profile` — Atualiza email e/ou senha do usuário autenticado

### Teste

- `GET /api/auth/ping` — Verifica se o serviço está online

---

## Fluxo de Autenticação

1. **Registro:** Usuário se cadastra via `/api/auth/signup`.
2. **Login:** Usuário faz login via `/api/auth/signin` e recebe JWT + refresh token.
3. **Acesso:** Usuário utiliza JWT no header `Authorization: Bearer <token>` para acessar endpoints protegidos.
4. **Refresh:** Quando o JWT expira, o usuário pode obter um novo via `/api/auth/refreshtoken` usando o refresh token.
5. **Logout:** O refresh token é invalidado via `/api/auth/signout`.

---

## Mensageria com RabbitMQ

Ao criar um usuário, um evento `UserCreatedEvent` é publicado no RabbitMQ, permitindo integração com outros serviços.

- Configuração dos nomes de fila, exchange e routing key em `application.properties`:
  - `queue.name`
  - `exchange.name`
  - `routing.key`

---

## Testes

Os testes automatizados estão em `src/test/java/com/edupath/msauth/`.

Execute os testes com:

```sh
./mvnw test
```

---

## Documentação da API

A documentação interativa está disponível via Swagger/OpenAPI:

- Acesse: `http://localhost:8080/swagger-ui/index.html`
- Esquema de autenticação: Bearer Token (JWT)

---

## Licença

Este projeto segue a licença Apache 2.0. Consulte o arquivo `LICENSE` para mais detalhes.

---

## Contato

Dúvidas ou sugestões? Abra uma issue ou entre em contato com o mantenedor do projeto.
