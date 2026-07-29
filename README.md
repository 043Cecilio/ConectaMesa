<div align="center">

# ConectaMesa

### Plataforma Full Stack de Conexão entre Doadores de Alimentos e ONGs

*Combatendo o desperdício. Alimentando vidas. Construindo pontes.*

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![TypeScript](https://img.shields.io/badge/TypeScript-007ACC?style=for-the-badge&logo=typescript&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white)

</div>

---

## Sobre o Projeto

**ConectaMesa** é uma plataforma Full Stack com arquitetura desacoplada que atua como ponte entre **doadores de alimentos** — mercados, restaurantes e estabelecimentos comerciais — e **ONGs** cadastradas, otimizando a logística de doações e combatendo, simultaneamente, o desperdício alimentar e a insegurança alimentar.

O sistema oferece autenticação diferenciada por perfil, gestão de doações em tempo real e uma experiência de usuário construída com foco em clareza, performance e responsividade.

> **Impacto:** Segundo o IBGE, o Brasil desperdiça cerca de 30% dos alimentos produzidos, enquanto milhões de famílias enfrentam insegurança alimentar. O ConectaMesa nasce como resposta técnica a esse paradoxo social.

---

## Arquitetura e Estrutura de Pastas

O projeto adota uma **arquitetura multirepo** com os dois serviços organizados na mesma raiz, mantendo separação completa de responsabilidades entre backend e frontend.

```
conectamesa/
│
├── api/                          # 🔵 Back-end — Java 17 + Spring Boot 3
│   ├── src/
│   │   └── main/
│   │       ├── java/com/conectamesa/
│   │       │   ├── controller/       # DonationController, AuthController
│   │       │   ├── dto/              # RegisterDonorDTO, RegisterNgoDTO
│   │       │   ├── model/            # User, Donor, Ngo, Address, Donation
│   │       │   ├── repository/       # Interfaces JPA
│   │       │   └── service/          # Lógica de negócio e transações
│   │       └── resources/
│   │           └── application.properties   # Config de BD e CORS
│   └── pom.xml
│
└── web/                          # 🟠 Front-end — React + Vite + TypeScript
    ├── src/
    │   ├── components/           # Componentes reutilizáveis
    │   ├── pages/                # Login, Feed, Cadastro
    │   ├── services/             # fetch/axios para consumo da API
    │   ├── types/                # Tipagens TypeScript
    │   └── App.tsx
    ├── public/
    ├── index.html
    └── vite.config.ts
```

---

## Status de Desenvolvimento

### Back-end — Java 17 + Spring Boot 3 + PostgreSQL

| Funcionalidade | Status |
|---|---|
| Modelagem relacional (users, donors, ngos, addresses, donations) | ✅ Concluído |
| Cadastro composto transacional (User + Address + Perfil) | ✅ Concluído |
| DTOs com Jakarta Bean Validation (e-mail, senha, CNPJ) | ✅ Concluído |
| Endpoints RESTful (GET /donations) com CORS configurado | ✅ Concluído |
| Autenticação JWT + Spring Security | 🔄 Em desenvolvimento |
| Deploy em nuvem + CI/CD via GitHub Actions | 🔄 Em desenvolvimento |

### Front-end — React + Vite + TypeScript

| Funcionalidade | Status |
|---|---|
| Configuração do ambiente Vite + TypeScript | ✅ Concluído |
| Feed dinâmico consumindo API Java via fetch (useEffect + useState) | ✅ Concluído |
| Tela de Login com identidade visual dual (Doador / ONG) | ✅ Concluído |
| Inputs controlados com ícones via lucide-react | ✅ Concluído |
| Formulário de Cadastro em Etapas (Multi-step Form — 3 passos) | 🔄 Em desenvolvimento |
| Integração do formulário de cadastro com endpoints POST | 🔄 Em desenvolvimento |
| Tela de Criação de Doações (exclusiva para Doadores) | 🔄 Em desenvolvimento |

---

## Destaques Técnicos

### Cadastro Composto Transacional
O fluxo de registro executa, em uma única transação Spring Data JPA, a persistência simultânea das entidades `User` (credenciais), `Address` (endereço) e `Donor` ou `Ngo` (perfil específico). Em caso de falha em qualquer etapa, o rollback é automático, garantindo consistência total no banco de dados.

### Interface com Identidade Visual Dinâmica
A tela de login implementa um layout **split-screen 50/50** com troca de tema em tempo real. O clique no perfil "Sou Doador" aplica o tema verde (`#2d6a4f`) com imagem e slogan dedicados; o perfil "Sou ONG" aplica o tema laranja (`#e67e22`). Todas as imagens utilizadas são livres de direitos autorais (Unsplash), garantindo segurança jurídica para o projeto.

### Integração Full Stack Real
O frontend consome diretamente a API REST do backend Java, com CORS liberado especificamente para a porta de desenvolvimento do Vite (`http://localhost:5173`), simulando com fidelidade um ambiente de produção desacoplado.

---

## Roadmap

```
[✅] Modelagem de BD e arquitetura de cadastro composto
[✅] Endpoints RESTful + CORS + Feed dinâmico no Frontend
[✅] Tela de Login com identidade visual dual e inputs controlados
[ ] Multi-step Form de Cadastro (3 etapas — dados, CNPJ, endereço)
[ ] Integração POST: React → Spring Boot
[ ] Autenticação JWT + Spring Security + Rotas protegidas
[ ] Tela de Criação de Doações (painel do Doador)
[ ] CI/CD via GitHub Actions + Deploy (Render / AWS)
```

---

## Como Executar Localmente

Siga os passos abaixo para rodar o projeto completo em ambiente de desenvolvimento.

### Pré-requisitos

Certifique-se de ter instalado:

- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/) (ou use o wrapper `./mvnw` incluso)
- [Node.js 18+](https://nodejs.org/) e npm
- [PostgreSQL 14+](https://www.postgresql.org/)

---

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/conectamesa.git
cd conectamesa
```

---

### 2. Configure o Back-end

#### 2.1 — Crie o banco de dados no PostgreSQL

Acesse o console do PostgreSQL e execute:

```sql
CREATE DATABASE conectamesa;
```

#### 2.2 — Configure o `application.properties`

Abra o arquivo `api/src/main/resources/application.properties` e ajuste as credenciais:

```properties
# Datasource
spring.datasource.url=jdbc:postgresql://localhost:5432/conectamesa
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Porta da API
server.port=8080
```

#### 2.3 — Inicie o servidor Spring Boot

```bash
cd api
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

### 3. Configure o Front-end

#### 3.1 — Instale as dependências

```bash
cd ../web
npm install
```

#### 3.2 — Inicie o servidor de desenvolvimento Vite

```bash
npm run dev
```

A aplicação estará disponível em: `http://localhost:5173`

---

### 4. Verifique a integração

Com ambos os servidores rodando, acesse `http://localhost:5173`. O feed de doações será carregado dinamicamente consumindo os dados do PostgreSQL via API Java.

---

## Stack Tecnológica

| Camada | Tecnologia |
|---|---|
| Linguagem Back-end | Java 17 |
| Framework Back-end | Spring Boot 3 |
| Persistência | Spring Data JPA + Hibernate |
| Banco de Dados | PostgreSQL |
| Validação | Jakarta Bean Validation |
| Linguagem Front-end | TypeScript |
| Framework Front-end | React 18 |
| Bundler | Vite |
| Ícones | lucide-react |
| CI/CD (planejado) | GitHub Actions |
| Deploy (planejado) | Render / AWS |


<div align="center">

Desenvolvido por **Gabriel Cecilio Menezes**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](www.linkedin.com/in/gabriel-cecilio-bb938035b)

</div>
