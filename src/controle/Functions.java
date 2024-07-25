package controle;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    private static Scanner tec = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String recebeString() {
        while (true) {
            String input = tec.nextLine().trim();

            // Verifica se a string tem algo
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.print("[Erro] A resposta não pode estar vazia. \nPor favor, insira novamente: ");
            }
        }
    }

    public static char recebeChar() {
        while (true) {
            String input = tec.nextLine().trim().toUpperCase();

            // Verifica se a string tem pelo menos um caractere
            if (!input.isEmpty()) {
                return input.charAt(0);
            } else {
                System.out.print("[Erro] A resposta não pode estar vazia. \nPor favor, insira novamente: ");
            }
        }
    }


    public static int recebeInteiro() {
        while (true) {
            // Tenta ler um número inteiro
            try {
                int number = tec.nextInt();
                tec.nextLine();
                return number;
                // Se não for introduzido um número inteiro, dispara o erro por ter recebido um tipo de dado diferente de int
            } catch (InputMismatchException e) {
                System.out.print("[Erro] Entrada inválida. \nPor favor, insira um número: ");
                tec.nextLine();
            }
        }
    }

    public static double recebeDouble() {
        while (true) {
            try {
                double number = tec.nextDouble();
                tec.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.print("[Erro] Entrada inválida. \nPor favor, insira um número: ");
                tec.nextLine();
            }
        }
    }

    public static Date recebeData() {
        while (true) {
            try {
                String input = tec.nextLine();
                return dateFormat.parse(input);
            } catch (Exception e) {
                System.out.print("[Erro] Formato de data esperado: yyyy-MM-dd. \nPor favor, insira novamente: ");
            }
        }
    }

}