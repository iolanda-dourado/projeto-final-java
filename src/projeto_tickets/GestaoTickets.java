package projeto_tickets;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class GestaoTickets {
    // Lista de tickets e clientes
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Construtor que inicializa as listas de tickets e clientes
    public GestaoTickets(ArrayList<Ticket> tickets, ArrayList<Cliente> clientes) {
        this.tickets = tickets;
        this.clientes = clientes;
    }

    // Método para gerir a criação de novos tickets
    public void gerirTickets(Scanner tec) {
        System.out.println("Insira o ID do ticket: ");
        int id = tec.nextInt();

        System.out.println("Insira a data de início (yyyy-mm-dd):");
        String dataInicioStr = tec.next();
        Date dataInicio = Date.valueOf(dataInicioStr);

        System.out.println("Insira o ID do cliente:");
        int idCliente = tec.nextInt();

        System.out.println("Insira o tipo de cliente:");
        String tipoCliente = tec.next();

        System.out.println("Insira a descrição do histórico:");
        String descHistorico = tec.next();

        System.out.println("Insira a data de fim (yyyy-mm-dd):");
        String dataFimStr = tec.next();
        Date dataFim = Date.valueOf(dataFimStr);

        System.out.println("Insira o valor dos serviços:");
        double valorServicos = tec.nextDouble();

        System.out.println("Insira o valor das peças:");
        double valorPecas = tec.nextDouble();

        // Adiciona um novo ticket à lista de tickets
        // tickets.add(new Ticket(id, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas));
    }

    // Método para alterar o estado de um ticket existente
    public void alterarEstado(Scanner tec) {
        System.out.println("Insira o ID do ticket que deseja alterar: ");
        int id = tec.nextInt();
        boolean ticketEncontrado = false;

        // Itera sobre a lista de tickets para encontrar o ticket com o ID especificado
        for (int i = 0; i < tickets.size(); i++) {
            Ticket ticket = tickets.get(i);
            if (ticket.getIdReparacao() == id) {
                System.out.println("Insira a nova descrição do estado:");
                String novoEstado = tec.next();
                ticket.setDescHistorico(novoEstado); // Atualiza a descrição histórica com o novo estado
                ticketEncontrado = true;
                System.out.println("Estado alterado com sucesso!");
                break; // Encerra o loop após encontrar e atualizar o ticket
            }
        }

        // Se o ticket não for encontrado, exibe uma mensagem de erro
        if (!ticketEncontrado) {
            System.out.println("Ticket com ID " + id + " não encontrado.");
        }
    }
}
