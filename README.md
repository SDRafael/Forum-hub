# Forum Hub API

O **Forum Hub** é uma API desenvolvida como parte do desafio da formação **Oracle One - Next Education**.  
Ela permite o gerenciamento de tópicos e autenticação de usuários com segurança, utilizando **JWT**.

---

## Funcionalidades

- **Tópicos**:
  - Cadastro de tópicos
  - Listagem de tópicos
  - Detalhamento de um tópico específico
  - Atualização de tópicos
  - Exclusão de tópicos
- **Autenticação**:
  - Sistema de login com autenticação via **JWT**
  - Todas as requisições protegidas exigem o envio de um token válido no cabeçalho de autorização
- **Banco de Dados**:
  - Duas tabelas: 
    - **tópicos**
    - **usuários**
  - Senhas dos usuários armazenadas com **Bcrypt**

---

## Estrutura do Banco de Dados

### Tabela `topicos`
Cada tópico possui os seguintes campos:

  - id
  - titulo
  - mensagem
  - status
  - autor
  - curso
  - dataCriacao


---

## Fluxo da Aplicação

1. **Cadastro de Usuário**: O usuário se cadastra, caso ainda não exista.
2. **Login**: O usuário realiza o login e obtém o token JWT.
3. **Gestão de Tópicos**:
   - Criar, listar, modificar ou excluir tópicos.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **PostgreSQL** para persistência de dados
- **Maven** como gerenciador de dependências
- **Flyway** para migração do banco de dados
- **JWT** para autenticação e autorização

---

## Dependências do Projeto

- spring-boot-starter-web
- flyway-core
- flyway-database-postgresql
- spring-boot-starter-data-jpa
- spring-boot-starter-validation
- postgresql
- lombok
- spring-boot-starter-security
- spring-boot-starter-test
- spring-security-test
- java-jwt

---

