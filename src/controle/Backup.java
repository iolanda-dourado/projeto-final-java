package controle;

import modelo.Cliente;
import modelo.Ticket;

import java.io.*;
import java.util.ArrayList;

public class Backup {


    public static void realizarBackup(ArrayList<Cliente> clientes, ArrayList<Ticket> tickets, String nomeFicheiroBackup) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFicheiroBackup))) {
            oos.writeObject(clientes); // Salva a lista de clientes
            oos.writeObject(tickets); // Salva a lista de tickets
            System.out.println("Backup realizado com sucesso no arquivo: " + nomeFicheiroBackup);

            // Grava o histórico em um arquivo de texto
            gravarHistorico("backup_history.txt", "Backup realizado com sucesso. Dados salvos em: " + nomeFicheiroBackup);

        } catch (IOException e) {
            System.out.println("Erro ao realizar backup: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    public static ArrayList<Object> restaurarBackup(String nomeFicheiroBackup) {
        ArrayList<Object> dados = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFicheiroBackup))) {
            ArrayList<Cliente> clientes = (ArrayList<Cliente>) ois.readObject();
            ArrayList<Ticket> tickets = (ArrayList<Ticket>) ois.readObject();
            dados.add(clientes);
            dados.add(tickets);
            System.out.println("Restauração de dados realizada com sucesso.");

            // Grava o histórico em um arquivo de texto
            gravarHistorico("backup_history.txt", "Restauração de dados realizada com sucesso. Dados restaurados de: " + nomeFicheiroBackup);

        } catch (IOException e) {
            System.out.println("Erro ao restaurar dados: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de classe não encontrada: " + e.getMessage());
        }
        return dados;
    }


    private static void gravarHistorico(String nomeFicheiroHistorico, String mensagem) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiroHistorico, true))) {
            bw.write(new java.util.Date() + " - " + mensagem);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar histórico: " + e.getMessage());
        }
    }
}
