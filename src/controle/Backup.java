package controle;

import java.io.*;
import java.util.ArrayList;
import modelo.*;

public class Backup {
    public static void gravaClientes(ArrayList<Cliente> clientes, String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            f.createNewFile();              //Criar novo ficheiro
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            ficheiro.writeObject(clientes); // Escrever o arrayList no ficheiro
            System.out.println("Backup de clientes executado com sucesso.");
            System.out.println("no ficheiro: " + f.getAbsolutePath());
            ficheiro.flush();
            ficheiro.close();
        } catch (IOException e) {
            e.printStackTrace();            // Se a operação der erro mostra o erro...
        }
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Cliente> lerClientes(String nomeFicheiro) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        File ficheiro = new File(nomeFicheiro);
        if (!ficheiro.exists())
            ficheiro = new File(nomeFicheiro);
        else {
            ObjectInputStream f;
            try {
                f = new ObjectInputStream(new FileInputStream(nomeFicheiro));
                clientes = (ArrayList<Cliente>) f.readObject();
                System.out.println("Restauro de dados realizado com sucesso.");
            } catch (IOException e) {
                System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
                e.printStackTrace();            // Se a operação der erro mostra o erro...
            } catch (ClassNotFoundException e) {
                System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
                e.printStackTrace();            // Se a operação der erro mostra o erro...
            }

        }
        return clientes;
    }



    public static void gravaTickets(ArrayList<Ticket> tickets, String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            f.createNewFile();              //Criar novo ficheiro
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            ficheiro.writeObject(tickets); // Escrever o arrayList no ficheiro
            System.out.println("Backup de tickets executado com sucesso.");
            System.out.println("no ficheiro: " + f.getAbsolutePath());
            ficheiro.flush();
            ficheiro.close();
        } catch (IOException e) {
            e.printStackTrace();            // Se a operação der erro mostra o erro...
        }
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Ticket> lerTickets(String nomeFicheiro) {
        ArrayList<Ticket> tickets = new ArrayList<>();
        File ficheiro = new File(nomeFicheiro);
        if (!ficheiro.exists())
            ficheiro = new File(nomeFicheiro);
        else {
            ObjectInputStream f;
            try {
                f = new ObjectInputStream(new FileInputStream(nomeFicheiro));
                tickets = (ArrayList<Ticket>) f.readObject();
                System.out.println("Restaudo de dados realizado com sucesso.");
            } catch (IOException e) {
                System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
                e.printStackTrace();            // Se a operação der erro mostra o erro...
            } catch (ClassNotFoundException e) {
                System.out.println("Ficheiro: " + ficheiro.getAbsolutePath());
                e.printStackTrace();            // Se a operação der erro mostra o erro...
            }

        }
        return tickets;
    }
}
