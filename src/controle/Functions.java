package controle;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    private static Scanner tec = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static int recebeInteiro() {
        while (true) {
            // Tenta ler um número inteiro
            try {
                int number = tec.nextInt();
                tec.nextLine();
                return number;
                // Se não for introduzido um número inteiro, dispara o erro por ter recebido um tipo de dado diferente de int
            } catch (Exception e) {
                System.out.print("[Erro] Entrada inválida. Por favor, insira um número: ");
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
                System.out.print("[Erro] Entrada inválida. Por favor, insira um número: ");
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