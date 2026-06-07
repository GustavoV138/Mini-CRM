# Mini CRM API

Uma API REST simples para gerenciamento de clientes e seus respectivos contatos, desenvolvida com Spring Boot e persistência de dados em banco de dados em memória (H2).

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3.x (Spring Web, Spring Data JPA)
* **Banco de Dados:** H2 Database (Banco de dados em memória de fácil configuração)
* **Gerenciador de Dependências:** Maven

---

## 📁 Estrutura do Projeto

* `src/main/java/.../controller/ClienteController.java`: Endpoints da API para gerenciar clientes e contatos.
* `src/main/java/.../model/Cliente.java`: Entidade Cliente contendo nome, e-mail e relacionamento um-para-muitos com contatos.
* `src/main/java/.../model/Contato.java`: Entidade Contato contendo tipo (e-mail, telefone, etc.), valor e referência ao cliente dono do contato.
* `src/main/java/.../repository`: Interfaces de persistência de dados (`ClienteRepository` e `ContatoRepository`).

---

## ⚙️ Pré-requisitos

Para rodar este projeto, você precisará de:
* **Java JDK 21** ou superior
* **Maven** (opcional, o wrapper `./mvnw` está incluso)

---

## 🚀 Como Executar

### 1. Iniciar a Aplicação
Abra o terminal no diretório raiz do projeto e execute:

**No Windows (PowerShell/CMD):**
```bash
.\mvnw.cmd spring-boot:run
```

**No Linux/macOS:**
```bash
chmod +x ./mvnw
./mvnw spring-boot:run
```

A aplicação iniciará na porta **8080** por padrão.

---

## 🔌 API Endpoints

A API possui os seguintes endpoints sob a rota `/clientes`:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/clientes` | Cadastra um novo cliente |
| `GET` | `/clientes` | Lista todos os clientes cadastrados |
| `POST` | `/clientes/{id}/contatos` | Cria um novo contato vinculado ao cliente de ID correspondente |
| `GET` | `/clientes/{id}/contatos` | Lista todos os contatos vinculados ao cliente de ID correspondente |

---

## 📝 Exemplos de Requisições (Payloads)

### 1. Cadastrar Cliente (`POST /clientes`)
**Corpo da Requisição (JSON):**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com"
}
```

### 2. Cadastrar Contato para um Cliente (`POST /clientes/{id}/contatos`)
**Corpo da Requisição (JSON):**
```json
{
  "tipo": "Telefone",
  "valor": "+55 (11) 99999-9999"
}
```
