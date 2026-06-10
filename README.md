# Task Manager API

Projeto desenvolvido durante os estudos de Java e Spring Boot na DIO.

A aplicação consiste em uma API REST para gerenciamento de tarefas, implementando operações de criação, consulta, atualização e remoção de tarefas.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Web
- Bean Validation
- Lombok
- Gradle

## Arquitetura

O projeto foi organizado seguindo conceitos de Domain-Driven Design (DDD), separando as responsabilidades em três camadas principais:

### Domain

Contém as regras de negócio e os elementos centrais da aplicação.

- Task
- TaskId
- TaskRepository
- TaskStatus
- Exceptions

### Application

Responsável pelos casos de uso da aplicação.

- CreateTaskUseCase
- GetTasksUseCase
- GetTaskByIdUseCase
- UpdateTaskUseCase
- DeleteTaskUseCase

### Infrastructure

Responsável pela comunicação com o mundo externo.

- Controllers
- DTOs
- Repository
- Exception Handlers

## Funcionalidades

- Criar tarefa
- Buscar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Remover tarefa
- Validação de dados
- Tratamento global de exceções

## Endpoints

### Criar tarefa

```http
POST /tasks
```

### Listar tarefas

```http
GET /tasks
```

### Buscar tarefa por ID

```http
GET /tasks/{id}
```

### Atualizar tarefa

```http
PATCH /tasks/{id}
```

### Remover tarefa

```http
DELETE /tasks/{id}
```

## Exemplo de resposta

```json
{
  "id": "9c5c1d0c-efaa-4d5f-bc1e-2b0cbb4b18a",
  "title": "Estudar Spring Boot",
  "description": "Praticar DDD e arquitetura em camadas",
  "status": "PENDING"
}
```

## Aprendizados

Durante o desenvolvimento deste projeto, pratiquei:

- Organização de projetos com DDD
- Repository Pattern
- Value Objects
- Casos de uso (Use Cases)
- Desenvolvimento de APIs REST
- Validação de requisições
- Tratamento de exceções
- Boas práticas de arquitetura em Java

## Autor

Keven Godinho Pereira
