package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class GerenciarArray {
    private int[] array;
    private int size;

    // construtor p teste
    public GerenciarArray(int[] initial) {
        if (initial.length != 5) {
            throw new IllegalArgumentException("precisa ser 5 numeros iniciais");
        }
        this.array = new int[10];
        System.arraycopy(initial, 0, this.array, 0, initial.length);
        this.size = initial.length;
        validarUnico(initial);
        System.out.println("Array inicial: " + this);
    }


    public GerenciarArray() {
        this.array = new int[10];
        int[] userInput = obterEntradaDoUsuario();
        System.arraycopy(userInput, 0, this.array, 0, userInput.length);
        this.size = userInput.length;
        System.out.println("Array inicial: " + this);
    }

    public boolean isFull() {
        return size == 10;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int findIndex(int numero) {
        for (int i = 0; i < size; i++) {
            if (array[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    private int[] obterEntradaDoUsuario() {
        Scanner scanner = new Scanner(System.in);
        int[] userInput = new int[5];
        int count = 0;

        System.out.println("digite cinco numeros inteiros nao repetidos: ");
        while (count < 5) {
            int num = scanner.nextInt();
            if (isDuplicado(userInput, num, count)) {
                System.out.println("Numero repetido, digite outro");
            } else {
                userInput[count++] = num;
            }
        }
        return userInput;
    }

    private void validarUnico(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    throw new IllegalArgumentException("numeros nao podem ser repetidos");
                }
            }
        }
    }

    private boolean isDuplicado(int[] array, int num, int count) {
        for (int i = 0; i < count; i++) {
            if (array[i] == num) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.array.length && this.array[i] != 0; i++) {
            sb.append(this.array[i]).append(" ");
        }
        return sb.toString().trim();
    }
    public void executarPrograma() {
        Scanner scanner = new Scanner(System.in);
        while (!isFull() && !isEmpty()) {
            System.out.println("Digite um inteiro para adicionar ou remover:");
            int num = scanner.nextInt();
            if (!adicionarOuRemover(num)) {
                System.out.println("Ops! Algo deu errado, o array pode estar cheio ou vazio");
                break;
            }
            System.out.println("Estado atual do array: " + this);
        }
        scanner.close();
        System.out.println("O programa terminou, o array está " + (isFull() ? "cheio" : "vazio"));
    }

    public boolean adicionarOuRemover(int numero) {
        if (isFull() || isEmpty()) {
            System.out.println(this);
            return false;
        }

        int index = findIndex(numero);
        if (index != -1) {
            for (int j = index; j < size - 1; j++) {
                array[j] = array[j + 1];
            }
            array[--size] = 0;
        } else if (size < array.length) {
            array[size++] = numero;
        } else {
            return false;
        }
        System.out.println(this);
        return true;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, size);
    }
}
