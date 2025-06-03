# EduPath - Back-End

## Visão Geral

O back-end da plataforma **EduPath** é composto por quatro microserviços independentes, desenvolvidos em Java com Spring Boot, cada um responsável por uma parte fundamental da solução. Os serviços utilizam MongoDB como banco de dados principal, RabbitMQ para mensageria (quando necessário) e expõem APIs REST para integração. O objetivo é oferecer autenticação, gerenciamento de usuários, controle de roadmaps de aprendizado e administração de cursos, de forma escalável e desacoplada.

---

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura dos Microserviços](#arquitetura-dos-microserviços)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Execução Local](#execução-local)
- [Execução com Docker](#execução-com-docker)
- [Testes](#testes)
- [Licença](#licença)
- [Contato](#contato)

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.x
- Spring Data MongoDB
- Spring Security (MS-Auth)
- JWT (MS-Auth)
- RabbitMQ (MS-Auth, MS-User)
- Maven
- Docker
- Swagger/OpenAPI (MS-Auth)

---

## Arquitetura dos Microserviços

```
back-end/
├── ms-auth/      # Autenticação e registro de usuários, JWT, integração com RabbitMQ
├── ms-user/      # Gerenciamento de perfis e progresso de usuários, integração com RabbitMQ
├── ms-roadmap/   # Gerenciamento de roadmaps de aprendizado
├── ms-course/    # Gerenciamento de cursos e integração com roadmaps
```

### MS-Auth

- Autenticação e registro de usuários
- Geração e validação de JWT e refresh tokens
- Atualização de perfil do usuário autenticado
- Integração com RabbitMQ para eventos de criação de usuário
- Documentação via Swagger/OpenAPI

### MS-User

- Gerenciamento de perfis de usuário e progresso em roadmaps/cursos
- Consome eventos de criação de usuário via RabbitMQ
- Endpoints para consulta e atualização de perfil e progresso

### MS-Roadmap

- Cadastro, atualização, consulta e remoção de roadmaps de aprendizado
- Consulta de roadmaps por usuário
- Integração com outros serviços para trilhas de aprendizado

### MS-Course

- Cadastro, atualização, consulta e remoção de cursos
- Consulta de cursos por etapa (step) de roadmap
- Integração com outros microserviços para jornadas de aprendizado

---

## Configuração do Ambiente

1. **Pré-requisitos:**

   - Java 21+
   - Maven 3.9+
   - MongoDB (local ou Atlas)
   - RabbitMQ (para MS-Auth e MS-User)
   - Docker (opcional)

2. **Configuração dos Serviços:**
   - Cada microserviço possui seu próprio arquivo `application.properties` e aceita variáveis de ambiente para configuração de portas, URIs do MongoDB, credenciais do RabbitMQ, JWT, etc.

---

## Execução Local

Acesse a pasta de cada microserviço e execute:

```sh
./mvnw clean package
java -jar target/<nome-do-serviço>-0.0.1-SNAPSHOT.jar
```

---

## Execução com Docker

Cada microserviço possui um `Dockerfile`. Para rodar com Docker:

```sh
docker build -t <nome-do-serviço> .
docker run -p 8080:8080 --env-file .env <nome-do-serviço>
```

> Crie um arquivo `.env` com as variáveis de ambiente necessárias para cada serviço.

---

## Testes

Os testes automatizados estão localizados em `src/test/java/` dentro de cada microserviço.

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
