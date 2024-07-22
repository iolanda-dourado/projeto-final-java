package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoCliente {
    private static Scanner tec = new Scanner(System.in);
    private static ArrayList<ClienteFinal> clientesFinais = new ArrayList<>();
    private static ArrayList <ClienteRevendedor> clientesRevendedores = new ArrayList<>();


    // Método para apresentar o menu geral para os dois tipos de clientes e a escolha de opções
    public static void cadastrarClienteGeral() {
        int resposta;
        do {
            Menu.menuCadastroCliente();
            System.out.println("Insira sua resposta: ");
            resposta = tec.nextInt();
            tec.nextLine();

            switch (resposta) {
                case 1:
                    cadastrarClienteFinal();
                    break;
                case 2:
                    cadastrarClienteRevendedor();
                    break;
                case 3:
                    visualizarClientes();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o serviço.");
                    break;
                default:
                    System.out.println("[Erro] Insira uma opção válida.");
                    break;
            }
        } while (resposta != 3);

    }


    // Método para cadastrar Cliente Final
    private static void cadastrarClienteFinal() {
        char primeiraLetra;
        do {
            System.out.println("Insira o ID: ");
            int id = tec.nextInt();
            tec.nextLine();

            System.out.print("Insira o nome completo: ");
            String nome = tec.nextLine();

            System.out.print("Insira o NIF: ");
            String nif = tec.nextLine();

            System.out.print("Insira o telefone: ");
            String telefone = tec.nextLine();

            System.out.print("Insira o email: ");
            String email = tec.nextLine();

            System.out.print("O cliente final tem desconto? [S/N]: ");
            do {
                String desconto = tec.nextLine().trim().toUpperCase();
                primeiraLetra = desconto.isEmpty() ? ' ' : desconto.charAt(0); // Verifica se a string não está vazia

                if (primeiraLetra != 'S' && primeiraLetra != 'N') {
                    System.out.println("[Erro] Insira uma opção válida: S para Sim ou N para Não.");
                }
            } while(primeiraLetra != 'S' && primeiraLetra != 'N');

            boolean temDesconto = false;
            double percentagemDesc = 0;
            if (primeiraLetra == 'S') {
                temDesconto = true;
                do {
                    System.out.print("Qual a porcentagem do desconto? (Máximo 5%): ");
                    percentagemDesc = tec.nextInt();
                    tec.nextLine();
                } while (percentagemDesc > 5 || percentagemDesc < 0);
            }

            clientesFinais.add(new ClienteFinal(id, nome, nif, telefone, email, temDesconto, percentagemDesc));
        } while (primeiraLetra != 'S' && primeiraLetra != 'N');
    }


    // Método para cadastrar Cliente Revendedor
    private static void cadastrarClienteRevendedor() {
        double descontoPecas = 0.20;
        double descontoMaoObra = 0.10;
        System.out.println("Insira o ID: ");
        int id = tec.nextInt();
        tec.nextLine();

        System.out.print("Insira o nome completo: ");
        String nome = tec.nextLine();

        System.out.print("Insira o NIF: ");
        String nif = tec.nextLine();

        System.out.print("Insira o telefone: ");
        String telefone = tec.nextLine();

        System.out.print("Insira o email: ");
        String email = tec.nextLine();

        clientesRevendedores.add(new ClienteRevendedor(id, nome, nif, telefone, email, descontoPecas, descontoMaoObra));
    }


    // Método para visualizar clientes cadastrados
    private static void visualizarClientes() {
        System.out.println("Clientes Finais cadastrados: ");
        if (clientesFinais.isEmpty()) {
            System.out.println("Nenhum Cliente Final cadastrado.");
        } else {
            for (ClienteFinal clienteF : clientesFinais) {
                System.out.println(clienteF);
            }
        }


        System.out.println("Clientes Revendedores cadastrados: ");
        if (clientesRevendedores.isEmpty()) {
            System.out.println("Nenhum Cliente Revendedor Cadastrado.");
        } else {
            for (ClienteRevendedor clienteR : clientesRevendedores) {
                System.out.println(clienteR);
            }
        }
    }

}
