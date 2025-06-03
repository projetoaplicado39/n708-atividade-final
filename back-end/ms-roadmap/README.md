# MS-Roadmap

## Visão Geral

O **MS-Roadmap** é um microserviço para gerenciamento de roadmaps de aprendizado, desenvolvido em Java com Spring Boot. Utiliza MongoDB como banco de dados e expõe endpoints REST para cadastro, atualização, consulta e remoção de roadmaps, além de permitir a consulta por usuário e integração com outros serviços da plataforma.

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
- Spring Boot 3.4.1
- Spring Data MongoDB
- Maven
- Docker

---

## Estrutura de Pastas

```
ms-roadmap/
├── src/
│   ├── main/
│   │   ├── java/com/edupath/msroadmap/
│   │   │   ├── client/           # Integração com outros serviços
│   │   │   ├── config/           # Configurações globais
│   │   │   ├── controller/       # Controllers REST (Roadmap)
│   │   │   ├── dto/              # DTOs de request e response
│   │   │   ├── exceptions/       # Tratamento global de exceções
│   │   │   ├── model/            # Modelos de domínio (Roadmap, Step, etc)
│   │   │   ├── repository/       # Repositórios MongoDB
│   │   │   └── service/          # Regras de negócio
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação
│   └── test/
│       └── java/com/edupath/msroadmap/   # Testes automatizados
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
   - Docker (opcional)

2. **Configuração do MongoDB:**

   - Defina a URI do MongoDB em `application.properties` ou via variável de ambiente.

---

## Variáveis de Ambiente

As principais configurações podem ser sobrescritas por variáveis de ambiente, especialmente ao rodar via Docker:

- `SERVER_PORT` (porta do serviço, padrão: 8080)
- `MONGODB_URI` (URI do MongoDB)

---

## Execução Local

```sh
# Instale as dependências e gere o jar
./mvnw clean package

# Execute a aplicação
java -jar target/ms-roadmap-0.0.1-SNAPSHOT.jar
```

---

## Execução com Docker

```sh
# Build da imagem
docker build -t ms-roadmap .

# Execução do container
docker run -p 8080:8080 --env-file .env ms-roadmap
```

> Crie um arquivo `.env` com as variáveis de ambiente necessárias.

---

## Endpoints Principais

### Roadmap

- `POST /api/v1/roadmaps` — Cadastro de novo roadmap
- `GET /api/v1/roadmaps` — Lista todos os roadmaps
- `GET /api/v1/roadmaps/{id}` — Detalhes de um roadmap
- `PUT /api/v1/roadmaps/{id}` — Atualiza um roadmap
- `DELETE /api/v1/roadmaps/{id}` — Remove um roadmap
- `GET /api/v1/roadmaps/user/{userId}` — Lista roadmaps de um usuário

---

## Integração

O serviço permite consultar roadmaps por usuário (`userId`), facilitando a integração com outros microserviços que trabalham com perfis, trilhas ou jornadas de aprendizado.

---

## Testes

Os testes automatizados estão em `src/test/java/com/edupath/msroadmap/`.

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
