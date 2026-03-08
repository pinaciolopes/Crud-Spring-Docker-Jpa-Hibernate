# API CRUD - Spring Boot

API REST desenvolvida com **Spring Boot** utilizando **JPA e Hibernate** para persistência de dados.  
O projeto permite executar operações CRUD e pode ser executado com **PostgreSQL via Docker** ou utilizando **H2 Database** para testes locais.

---

## 🚀 Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Docker
- PostgreSQL
- H2 Database
- Maven
- Postman

---

## 📦 Ferramentas Necessárias

Para executar o projeto você precisa ter instalado:

- Java JDK
- Maven
- Docker (opcional)
- PostgreSQL (opcional se usar Docker)
- Postman (para testar a API)

---

## 🐳 Executando com Docker + PostgreSQL

Essa é a forma recomendada para executar o projeto.

### 1 - Clonar o projeto


```bash
git clone <url-do-repositorio>
cd nome-do-projeto

```
2 - Gerar o JAR da aplicação
```
mvn clean package

```
3 - Subir os containers
```
docker compose up --build
```

Isso irá iniciar:

API Spring Boot

Banco PostgreSQL

4 - Acessar a API

💻 Executando sem Docker (usando H2)

Também é possível rodar o projeto apenas com o banco H2 em memória.

1 - Executar a aplicação
```
mvn spring-boot:run
```
2 - Console do H2
```
http://localhost:8080/h2-console

```
Configuração padrão:

```
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password:

```
🔍 Testando a API

Para testar os endpoints utilize o Postman.

Exemplo de requisição:

Criar registro
```
POST /usuarios, /padaria, /compra
```

📁 Estrutura do Projeto

```
src
 └─ main
     ├─ java
     │   └─ controllers
     │   └─ services
     │   └─ repositories
     │   └─ entities
     └─ resources
         └─ application.properties

```
📚 Conceitos Utilizados

API REST

Persistência com JPA

ORM com Hibernate

Containerização com Docker

Banco relacional PostgreSQL

Banco em memória H2

👨‍💻 Autor

Projeto desenvolvido para estudo de Spring Boot, Docker e persistência com JPA/Hibernate.

