# Sistema de Cadastro de Usuários

Projeto desenvolvido em Java com o objetivo de aplicar conceitos fundamentais de Programação Orientada a Objetos (POO), organização em camadas e separação de responsabilidades.

---

# Funcionalidades

O sistema permite:

- Cadastrar usuários;
- Listar usuários;
- Buscar usuários;
- Remover usuários.

---

# Estrutura do Projeto

```text
src/
│
├── application/
│   └── App.java
│
├── entities/
│   └── User.java
│
├── interfaces/
│   └── UserRepository.java
│
├── services/
│   └── UserService.java
│
└── util/
    └── Menu.java
```

---

# Responsabilidade de Cada Pacote

## application

Contém o ponto de entrada do sistema.

### Classe:
```java
App.java
```

Responsável por iniciar a aplicação.

---

## entities

Contém os objetos que representam as entidades do sistema.

### Classe:
```java
User.java
```

Representa um usuário cadastrado no sistema.

---

## interfaces

Contém os contratos do sistema.

Interfaces definem o que uma classe deve fazer, mas não como deve ser feito.

### Classe:
```java
UserRepository.java
```

Define os métodos que devem ser implementados pelas classes responsáveis pelo gerenciamento dos usuários.

---

## services

Contém as regras de negócio e a lógica da aplicação.

### Classe:
```java
UserService.java
```

Responsável pelas operações:

- Cadastrar;
- Listar;
- Buscar;
- Remover;
- Atualizar.

---

## util

Contém classes utilitárias do sistema.

### Classe:
```java
Menu.java
```

Responsável pela interação com o usuário através do terminal.

---

# Fluxo do Sistema

O programa inicia na classe principal:

```java
public static void main(String[] args)
```

O Java executa:

```java
Menu menu = new Menu();
menu.executar();
```

## Fluxo de execução

```text
App
 ↓
Menu
 ↓
UserService
 ↓
Lista de usuários
```

---

# UML do Projeto

```text
+-------------------+
|       App         |
+-------------------+
| + main()          |
+-------------------+
          |
          v

+-------------------+
|       Menu        |
+-------------------+
| - scanner         |
| - userService     |
+-------------------+
| + executar()      |
| - mostrarMenu()   |
| - cadastrar()     |
| - listar()        |
| - remover()       |
+-------------------+
          |
          v

+--------------------------+
|      UserService         |
+--------------------------+
| - usuarios : List<User>  |
+--------------------------+
| + cadastrar()            |
| + listar()               |
| + remover()              |
| + buscar()               |
+--------------------------+
          |
          v

+-------------------+
|       User        |
+-------------------+
| - nome            |
| - email           |
+-------------------+
| + getters/setters |
| + toString()      |
+-------------------+

+-----------------------------+
|      UserRepository         |
|        <<interface>>        |
+-----------------------------+
| + cadastrar()               |
| + listar()                  |
| + remover()                 |
| + buscar()                  |
+-----------------------------+
```

---

# Explicando a UML

## App → Menu

A classe `App` apenas inicia o sistema.

Ela delega o controle da aplicação para a classe `Menu`, evitando colocar toda a lógica dentro da `main`.

---

## Menu → UserService

O `Menu` é responsável pela interação com o usuário.

Ele:

- Recebe dados;
- Exibe opções;
- Controla o fluxo do sistema.

As regras de negócio ficam na classe `UserService`.

---

## UserService → User

A classe `UserService` manipula objetos da classe `User`.

Exemplo:

```java
User user = new User();
```

---

## UserService → Interface

A classe `UserService` implementa a interface:

```java
UserRepository
```

Isso significa que ela é obrigada a implementar todos os métodos definidos pela interface.

---

# Conceitos de Programação Orientada a Objetos Utilizados

## Encapsulamento

Os atributos da classe são privados:

```java
private String nome;
private String email;
```

Isso protege os dados e impede acesso direto aos atributos.

O acesso é feito através de métodos getters e setters.

---

## Abstração

Cada classe possui uma responsabilidade específica.

Exemplo:

- `Menu` → interação com usuário;
- `UserService` → regras de negócio;
- `User` → representação do usuário.

---

## Polimorfismo

O projeto utiliza polimorfismo através de interfaces.

Exemplo:

```java
UserRepository repository = new UserService();
```

---

# Estruturas Utilizadas no Projeto

## List

O sistema utiliza listas para armazenar usuários.

Exemplo:

```java
List<User> usuarios = new ArrayList<>();
```

A lista permite armazenar múltiplos objetos dinamicamente.

---

## Scanner

Utilizado para ler dados digitados pelo usuário no terminal.

Exemplo:

```java
Scanner sc = new Scanner(System.in);
```

---

## Estrutura de Repetição

O sistema utiliza estruturas de repetição para manter o menu em execução.

Exemplo:

```java
while(opcao != 0)
```

---

## Estrutura Condicional

O sistema utiliza estruturas condicionais para controlar as opções escolhidas pelo usuário.

Exemplo:

```java
switch(opcao)
```

---

# Método toString()

O método `toString()` é utilizado para transformar objetos em texto legível.

Sem `toString()`:

```text
User@4f023edb
```

Com `toString()`:

```text
Nome: Matheus
Email: matheus@email.com
```
