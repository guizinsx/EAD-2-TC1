# EAD-2-TC1

Programa de console em **Java** que gerencia um array de números inteiros, com testes automatizados em **JUnit 5**.

> Trabalho desenvolvido na faculdade, em 2024.

## Como funciona

1. O usuário informa 5 números inteiros diferentes, que formam o array inicial (com capacidade para 10).
2. Depois, a cada número digitado:
   - se ele **já está** no array, é removido;
   - se **não está**, é adicionado.
3. O programa termina quando o array fica **cheio** (10 números) ou **vazio**.

O programa valida entradas que não são números inteiros e números repetidos na lista inicial.

## Testes

Os testes em `src/test/java/GerenciarArrayTest.java` cobrem a criação do array, a rejeição de números repetidos, a adição e a remoção, e os casos de array cheio e vazio.

## Tecnologias

- Java 21
- Maven
- JUnit 5

## Como rodar

```bash
mvn compile exec:java -Dexec.mainClass="org.example.Main"
```

Para rodar os testes:

```bash
mvn test
```
