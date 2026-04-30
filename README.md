# 🏥 Sistema Hospitalar

API RESTful desenvolvida com **Java** e **Spring Boot** para gerenciamento hospitalar. Permite o controle de pacientes, médicos, especialidades, consultas e receitas médicas.

---

## 🛠️ Tecnologias Utilizadas

<p>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white"/>
</p>

- **Java 17**
- **Spring Boot 4.0.3**
- **Spring Data JPA** — persistência e mapeamento objeto-relacional
- **Spring Validation** — validação dos dados de entrada
- **PostgreSQL** — banco de dados relacional
- **SpringDoc OpenAPI 2.2.0** — documentação automática via Swagger UI

---

## 📋 Funcionalidades

- 🧑‍⚕️ Cadastro e gerenciamento de **médicos**
- 🏷️ Gerenciamento de **especialidades** médicas
- 🛏️ Cadastro e controle de **pacientes**
- 📅 Agendamento e gerenciamento de **consultas**
- 💊 Emissão e controle de **receitas médicas**

---

## 🔗 Endpoints Principais

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/pacientes` | Cadastrar paciente |
| `GET` | `/pacientes` | Listar pacientes |
| `PUT` | `/pacientes/{id}` | Atualizar paciente |
| `DELETE` | `/pacientes/{id}` | Remover paciente |
| `POST` | `/medicos` | Cadastrar médico |
| `GET` | `/medicos` | Listar médicos |
| `POST` | `/especialidades` | Cadastrar especialidade |
| `GET` | `/especialidades` | Listar especialidades |
| `POST` | `/consultas` | Cadastrar consulta |
| `GET` | `/consultas` | Listar consultas |
| `POST` | `/receitas` | Emitir receita |
| `GET` | `/receitas` | Listar receitas |

> Documentação completa disponível via **Swagger UI** após rodar o projeto.

---

## 📁 Estrutura do Projeto

```
sistema-hospitalar/
│
├── src/main/java/br/com/senai/sistema_hospitalar/
│   ├── config/          # Configuração do Swagger
│   ├── controller/      # Controllers REST (Consulta, Especialidade, Medico, Paciente, Receita)
│   ├── entity/          # Entidades JPA (Consulta, Especialidade, Medico, Paciente, Receita)
│   ├── exception/       # Classe de resposta padronizada
│   └── repository/      # Interfaces JPA Repository
│
├── src/main/resources/
│   └── application.properties  # Configurações do banco e Swagger
│
├── sistemaHospitalar.drawio         # Diagrama do sistema
├── sistemaHospitalarDbeaver.png     # Diagrama do banco de dados
└── pom.xml
```

---

## ⚙️ Como Rodar Localmente

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL rodando localmente

### 1. Clone o repositório
```bash
git clone https://github.com/TaianeAlbuquerqueDev/sistema-hospitalar.git
cd sistema-hospitalar
```

### 2. Configure o banco de dados

No arquivo `src/main/resources/application.properties`, ajuste as credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

### 3. Execute o projeto
```bash
./mvnw spring-boot:run
```

### 4. Acesse a documentação Swagger
```
http://localhost:8080/sistema_hospitalar/swagger-ui.html
```

---

## 📊 Diagrama do Banco de Dados

![Diagrama do Banco](./sistemaHospitalarDbeaver.png)

---

## 📚 Aprendizados

- Construção de API RESTful com Spring Boot
- Mapeamento de entidades com Spring Data JPA
- Validação de dados com Bean Validation
- Modelagem de banco de dados relacional com PostgreSQL
- Documentação automática com SpringDoc OpenAPI / Swagger UI
- Respostas padronizadas com códigos HTTP corretos (200, 201, 204, 404)
- Modelagem de domínio hospitalar com múltiplos relacionamentos entre entidades

---

## 👩‍💻 Autora

<table>
  <tr>
    <td align="center">
      <b>Taiane Albuquerque</b><br/>
      Desenvolvedora Full Stack<br/>
      <a href="https://www.linkedin.com/in/taiane-albuquerque-78b029175/">LinkedIn</a> •
      <a href="https://github.com/TaianeAlbuquerqueDev">GitHub</a> •
      <a href="mailto:taiane.albuquerque.1994@gmail.com">Email</a>
    </td>
  </tr>
</table>
