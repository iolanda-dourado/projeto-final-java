package projeto_tickets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    private static Scanner tec = new Scanner(System.in);

    // Método para imprimir o cabeçalho dos clientes
    public static void imprimeCabecalhoClientes() {
        System.out.printf("%-13s | %-5s | %-25s | %-11s | %-13s | %-30s | %-15s | %-20s | %-20s%n",
                "Tipo Cliente", "ID", "Nome", "NIF", "Telefone", "Email", "% Desc. Peças", "% Desc. Mão Obra", "% Desc. Pronto Pgto");
    }

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