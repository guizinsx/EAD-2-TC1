package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] NumerosIniciais = new int[5];
        System.out.println("Insira 5 numeros inteiros diferentes: ");

        for (int i = 0; i < NumerosIniciais.length; i++) {
            while (true) {
                System.out.printf("Entre com o numero %d: ", i + 1);
                if (scanner.hasNextInt()) {
                    int num = scanner.nextInt();
                    boolean isDuplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (NumerosIniciais[j] == num) {
                            isDuplicate = true;
                            System.out.println("Este numero ja foi inserido, escolha outro");
                            break;
                        }
                    }
                    if (!isDuplicate) {
                        NumerosIniciais[i] = num;
                        break;
                    }
                } else {
                    System.out.println("Valor invalido, precisa ser um inteiro");
                    scanner.next();
                }
            }
        }

        GerenciarArray ga = new GerenciarArray(NumerosIniciais);

        ga.executarPrograma();

        scanner.close();
    }
}
