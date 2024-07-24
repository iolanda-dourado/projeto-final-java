package controle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    private static Scanner tec = new Scanner(System.in);

    public static int lerInteiro() {
        while (true) {
            // Tenta ler um número inteiro
            try {
                return tec.nextInt();
            // Se não for introduzido um número inteiro, dispara o erro por ter recebido um tipo de dado diferente de int
            } catch (InputMismatchException e) {
                System.out.print("[Erro] Entrada inválida. Por favor, insira um número: ");
                tec.next(); // Limpa o buffer de entrada
            }
        }
    }
}