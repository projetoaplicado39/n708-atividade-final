# MS-User

## Visão Geral

O **MS-User** é um microserviço responsável pelo gerenciamento de perfis e progresso de usuários na plataforma EduPath. Desenvolvido em Java com Spring Boot, utiliza MongoDB como banco de dados e integra-se com RabbitMQ para comunicação assíncrona de eventos de criação de usuário. Expõe endpoints REST para consulta e atualização de perfis e progresso dos usuários.

---

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Variáveis de Ambiente](#variáveis-de-ambiente)
- [Execução Local](#execução-local)
- [Execução com Docker](#execução-com-docker)
- [Endpoints Principais](#endpoints-principais)
- [Testes](#testes)
- [Licença](#licença)
- [Contato](#contato)

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Data MongoDB
- Spring AMQP (RabbitMQ)
- Maven
- Docker

---

## Estrutura de Pastas

```
ms-user/
├── src/
│   ├── main/
│   │   ├── java/com/edupath/msuser/
│   │   │   ├── config/           # Configurações globais (RabbitMQ)
│   │   │   ├── controller/       # Controllers REST (User)
│   │   │   ├── dto/              # DTOs de request e response
│   │   │   ├── event/            # Eventos e listeners do RabbitMQ
│   │   │   ├── exception/        # Tratamento de exceções
│   │   │   ├── model/            # Modelos de domínio (UserProfile, UserProgress)
│   │   │   ├── repository/       # Repositórios MongoDB
│   │   │   └── service/          # Regras de negócio
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação
│   └── test/
│       └── java/com/edupath/msuser/   # Testes automatizados
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
   - RabbitMQ
   - Docker (opcional)

2. **Configuração do MongoDB e RabbitMQ:**

   - Defina a URI do MongoDB e as configurações do RabbitMQ em `application.properties` ou via variáveis de ambiente.

---

## Variáveis de Ambiente

As principais configurações podem ser sobrescritas por variáveis de ambiente, especialmente ao rodar via Docker:

- `SERVER_PORT` (porta do serviço, padrão: 8080)
- `MONGODB_URI` (URI do MongoDB)
- `RABBITMQ_HOST` (host do RabbitMQ, padrão: localhost)
- `RABBITMQ_PORT` (porta do RabbitMQ, padrão: 5672)
- `RABBITMQ_USERNAME` (usuário do RabbitMQ, padrão: admin)
- `RABBITMQ_PASSWORD` (senha do RabbitMQ, padrão: admin)

---

## Execução Local

```sh
# Instale as dependências e gere o jar
./mvnw clean package

# Execute a aplicação
java -jar target/ms-user-0.0.1-SNAPSHOT.jar
```

---

## Execução com Docker

```sh
# Build da imagem
docker build -t ms-user .

# Execução do container
docker run -p 8080:8080 --env-file .env ms-user
```

> Crie um arquivo `.env` com as variáveis de ambiente necessárias.

---

## Endpoints Principais

### Usuário

- `GET /api/v1/users/{id}` — Consulta o perfil do usuário
- `PUT /api/v1/users/{id}` — Atualiza o perfil do usuário

### Progresso

- `GET /api/v1/users/{id}/progress` — Lista o progresso do usuário
- `POST /api/v1/users/{id}/progress` — Atualiza ou cria progresso do usuário

---

## Integração

O serviço consome eventos de criação de usuário via RabbitMQ (`user.created.queue`) e cria automaticamente um perfil de usuário no banco de dados. Permite integração com outros microserviços da plataforma EduPath.

---

## Testes

Os testes automatizados estão em `src/test/java/com/edupath/msuser/`.

Execute os testes com:

```sh
./mvnw test
```

---

## Licença

Este projeto segue a licença Apache 2.0. Consulte o arquivo `LICENSE` para mais detalhes.

---

## Contato

Dúvidas ou sugestões? Abra uma issue ou entre em contato com o mantenedor do projeto.
