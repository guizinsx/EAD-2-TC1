package org.example;

import java.util.Scanner;

public class GerenciarArray {
    private int[] array;

    // construtor p teste
    public GerenciarArray(int[] initial) {
        if (initial.length != 5) {
            throw new IllegalArgumentException("precisa ser 5 numeros iniciais");
        }
        this.array = new int[10];
        System.arraycopy(initial, 0, this.array, 0, initial.length);
        validarUnico(initial);
    }


    public GerenciarArray() {
        this.array = new int[10];
        int[] userInput = obterEntradaDoUsuario();
        System.arraycopy(userInput, 0, this.array, 0, userInput.length);
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
}
