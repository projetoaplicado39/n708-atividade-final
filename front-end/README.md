# EduPath - Front-End

## Visão Geral

O front-end da plataforma **EduPath** é uma aplicação web desenvolvida com React, TypeScript e Vite, que oferece uma experiência moderna e responsiva para usuários gerenciarem sua jornada de aprendizado. A interface consome APIs REST dos microserviços do back-end, permitindo autenticação, gerenciamento de perfil, visualização de roadmaps e acesso a cursos recomendados.

---

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura do Projeto](#arquitetura-do-projeto)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Execução Local](#execução-local)
- [Build de Produção](#build-de-produção)
- [Testes](#testes)
- [Licença](#licença)
- [Contato](#contato)

---

## Tecnologias Utilizadas

- React 19
- TypeScript 5
- Vite 6
- TailwindCSS 4
- Axios
- React Router DOM
- React Hook Form
- ESLint

---

## Arquitetura do Projeto

```
edu-path-front-end/
├── public/                  # Arquivos estáticos
├── src/
│   ├── assets/              # Imagens e fontes
│   ├── components/          # Componentes reutilizáveis (Header, Footer, Auth, Course, Profile, Roadmap)
│   ├── config/              # Configurações globais (ex: axios)
│   ├── layouts/             # Layouts de página
│   ├── pages/               # Páginas principais (Courses, Profile, Roadmaps)
│   ├── services/            # Serviços para consumo das APIs
│   ├── types/               # Tipos TypeScript compartilhados
│   ├── App.tsx              # Componente principal
│   ├── main.tsx             # Ponto de entrada da aplicação
│   └── tailwind.css         # Estilos globais
├── index.html
├── package.json
├── tailwind.config.ts
├── tsconfig.json
├── tsconfig.app.json
├── tsconfig.node.json
├── vite.config.ts
└── README.md
```

---

## Configuração do Ambiente

1. **Pré-requisitos:**

   - Node.js 18+
   - npm 9+ ou yarn

2. **Instalação das Dependências:**

   ```sh
   npm install
   # ou
   yarn install
   ```

3. **Configuração de Variáveis de Ambiente:**

   - As URLs das APIs dos microserviços estão configuradas nos arquivos de serviço em `src/services/`. Para ambientes diferentes, ajuste conforme necessário.

---

## Execução Local

Para iniciar o servidor de desenvolvimento com hot reload:

```sh
npm run dev
# ou
yarn dev
```

Acesse [http://localhost:5173](http://localhost:5173) no navegador.

---

## Build de Produção

Para gerar os arquivos otimizados para produção:

```sh
npm run build
# ou
yarn build
```

Os arquivos finais estarão na pasta `dist/`.

Para pré-visualizar o build:

```sh
npm run preview
# ou
yarn preview
```

---

## Testes

> No momento, a aplicação não possui testes automatizados. Recomenda-se utilizar ferramentas como React Testing Library e Jest para implementar testes de componentes e integração.

---

## Licença

Este projeto segue a licença Apache 2.0. Consulte o arquivo `LICENSE` para mais detalhes.

---

## Contato

Dúvidas ou sugestões? Abra uma issue ou entre em contato com o mantenedor do projeto.
