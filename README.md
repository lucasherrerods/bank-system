# 🏦 Bank System – Sistema Bancário em Java

Projeto desenvolvido com o objetivo de praticar conceitos fundamentais de **Java** e **Programação Orientada a Objetos (POO)**, simulando um sistema bancário via **console**.

## 📌 Sobre o projeto

O **Bank System** permite o gerenciamento básico de clientes e contas bancárias, oferecendo operações comuns de um sistema financeiro, como abertura de contas, depósitos, saques, transferências e consulta de extrato.

O foco principal do projeto é a **organização do código**, aplicação correta de **POO** e **regras de negócio**, sem o uso de frameworks.


## 🚀 Funcionalidades

- Cadastro de clientes
- Abertura de contas bancárias
  - Conta Corrente
  - Conta Poupança
- Depósito em conta
- Saque
- Transferência entre contas
- Exibição de extrato
- Listagem de clientes
- Listagem de contas


## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
  - Encapsulamento
  - Herança
  - Polimorfismo
- Abstração com classes e métodos
- Separação de responsabilidades
  - `model`
  - `service`
  - `repository`
  - `application`
- Uso de listas (`ArrayList`)
- Métodos estáticos para gerenciamento
- Regras de negócio e validações
- Menu interativo via console


## 🗂️ Estrutura do projeto

```text
src/
 └── main/
      └── java/
           └── com/banksystem/
                 ├── model/
                 │     Cliente.java
                 │     Conta.java
                 │     ContaCorrente.java
                 │     ContaPoupanca.java
                 │     Transacao.java
                 │     TipoTransacao.java
                 │
                 ├── repository/
                 │     ClienteRepositorio.java
                 │     ContaRepositorio.java
                 │
                 ├── service/
                 │     ClienteService.java
                 │     ContaService.java
                 │
                 └── application/
                       Main.java
```

▶️ Como executar o projeto
🔹 Clonando o Repositório
   ```sh
   git clone https://github.com/lucasherrerods/bank-system
   ```
🔹 Abra o projeto em uma IDE Java (IntelliJ, Eclipse, VS Code)
🔹 Execute a classe:
   ```sh
   application/Main.java
   ```
🔹 Interaja com o menu pelo console
