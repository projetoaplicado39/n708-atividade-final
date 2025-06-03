# MS-Course

## Visão Geral

O **MS-Course** é um microserviço para gerenciamento de cursos desenvolvido em Java com Spring Boot. O projeto utiliza MongoDB como banco de dados e expõe endpoints REST para cadastro, atualização, consulta e remoção de cursos. Também permite consultar cursos por etapa (step) e foi projetado para fácil integração com outros serviços da plataforma.

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
- Spring Boot 3.4.6
- Spring Data MongoDB
- Maven
- Docker

---

## Estrutura de Pastas

```
ms-course/
├── src/
│   ├── main/
│   │   ├── java/com/edupath/mscourse/
│   │   │   ├── config/           # Configurações (CORS, etc)
│   │   │   ├── controller/       # Controllers REST (Course)
│   │   │   ├── dto/              # DTOs de request e response
│   │   │   ├── exception/        # Tratamento global de exceções
│   │   │   ├── mapper/           # Conversão entre entidades e DTOs
│   │   │   ├── model/            # Modelos de domínio (Course, DifficultyLevel)
│   │   │   ├── repository/       # Repositórios MongoDB
│   │   │   └── service/          # Regras de negócio
│   │   └── resources/
│   │       └── application.properties # Configurações da aplicação
│   └── test/
│       └── java/com/edupath/mscourse/   # Testes automatizados
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
java -jar target/ms-course-0.0.1-SNAPSHOT.jar
```

---

## Execução com Docker

```sh
# Build da imagem
docker build -t ms-course .

# Execução do container
docker run -p 8080:8080 --env-file .env ms-course
```

> Crie um arquivo `.env` com as variáveis de ambiente necessárias.

---

## Endpoints Principais

### Curso

- `POST /api/v1/courses` — Cadastro de novo curso
- `GET /api/v1/courses` — Lista todos os cursos
- `GET /api/v1/courses/{id}` — Detalhes de um curso
- `DELETE /api/v1/courses/{id}` — Remove um curso
- `GET /api/v1/courses/step/{stepId}` — Lista cursos associados a uma etapa (step)

---

## Integração

O serviço permite consultar cursos por etapa (`stepId`), facilitando a integração com outros microserviços que trabalham com trilhas ou jornadas de aprendizado.

---

## Testes

Os testes automatizados estão em `src/test/java/com/edupath/mscourse/`.

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
