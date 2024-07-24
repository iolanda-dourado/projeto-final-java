package visualizacao;

import modelo.Cliente;
import modelo.ClienteFinal;
import modelo.Ticket;
import controle.Backup;
import controle.GestaoCT;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //criar lis
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        //add clientes e bilhetes
        clientes.add(new ClienteFinal(21, "Manuel Micas", "1234", "123456","manuel@iefp.pt", true,5 ));
        clientes.add(new ClienteFinal(22, "Iolanda Dourado", "4321", "654321","iolanda@iefp.pt", false,10 ));

        tickets.add(new Ticket(1, new Date(), 21,"Final","Um Ticket bem feito 1", new Date(), 100, 50));

        // Nome do ficheiro de backup
        String nomeFicheiroBackup = "Iolanda_Manuel_Backup.txt";

        Backup.realizarBackup(clientes, tickets, nomeFicheiroBackup);

        // Restaurar dados
        ArrayList<Object> dadosRestaurados = Backup.restaurarBackup(nomeFicheiroBackup);
        if (dadosRestaurados.size() == 2) {
            ArrayList<Cliente> clientesRestaurados = (ArrayList<Cliente>) dadosRestaurados.get(0);
            ArrayList<Ticket> ticketsRestaurados = (ArrayList<Ticket>) dadosRestaurados.get(1);

            // Mostrar dados restaurados
            System.out.println("Clientes restaurados:");
            for (Cliente cliente : clientesRestaurados) {
                System.out.println(cliente);
            }

            System.out.println("\nTickets restaurados:");
            for (Ticket ticket : ticketsRestaurados) {
                System.out.println(ticket);
            }
        } else
            System.out.println("Erro ao restaurar dados.");


        GestaoCT.menuGerenciamento();

    }

}