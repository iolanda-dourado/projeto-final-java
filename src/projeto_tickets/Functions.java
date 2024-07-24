package projeto_tickets;

import java.util.Scanner;

public class Functions {
    // recebeInt();
    // recebeStr();
    // recebeDou();

    // Método para imprimir o cabeçalho dos clientes
    public static void imprimeCabecalhoClientes() {
        System.out.printf("%-13s | %-5s | %-25s | %-11s | %-13s | %-30s | %-15s | %-20s | %-20s%n",
                "Tipo Cliente", "ID", "Nome", "NIF", "Telefone", "Email", "% Desc. Peças", "% Desc. Mão Obra", "% Desc. Pronto Pgto");
    }
}