package projeto_tickets;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoCliente {
    private static Scanner tec = new Scanner(System.in);
    private static ArrayList<ClienteFinal> clientesFinais = new ArrayList<>();
    private static ArrayList<ClienteRevendedor> clientesRevendedores = new ArrayList<>();

    // Método para apresentar o menu geral para os dois tipos de clientes e a escolha de opções
    public static void cadastrarClienteGeral() {
        int resposta;
        do {
            Menu.menuCadastroCliente();
            System.out.print("Insira sua resposta: ");
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
                case 4:
                    atualizarCliente();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o serviço.");
                    break;
                default:
                    System.out.println("[Erro] Insira uma opção válida.");
                    break;
            }
        } while (resposta != 0);
    }

    // CREATE
    // Método para cadastrar Cliente Final
    private static void cadastrarClienteFinal() {
        System.out.print("Insira o ID: ");
        int id = tec.nextInt();
        tec.nextLine();

        // Verificar se o ID já existe
        for (ClienteFinal cliente : clientesFinais) {
            if (cliente.getId() == id) {
                System.out.println("[Erro] ID já cadastrado. Tente novamente.");
                return;
            }
        }

        // Pede os dados ao utilizador
        System.out.print("Insira o nome completo: ");
        String nome = tec.nextLine();
        System.out.print("Insira o NIF: ");
        String nif = tec.nextLine();
        System.out.print("Insira o telefone: ");
        String telefone = tec.nextLine();
        System.out.print("Insira o email: ");
        String email = tec.nextLine();

        // Verifica se o cliente tem desconto
        char primeiraLetra;
        do {
            System.out.print("O cliente final tem desconto? [S/N]: ");
            String desconto = tec.nextLine().trim().toUpperCase();
            primeiraLetra = desconto.isEmpty() ? ' ' : desconto.charAt(0); // Verifica se a string não está vazia

            if (primeiraLetra != 'S' && primeiraLetra != 'N') {
                System.out.print("[Erro] Insira uma opção válida: S/N.");
            }
        } while (primeiraLetra != 'S' && primeiraLetra != 'N');

        // Verifica qual é a porcentagem do desconto
        boolean temDesconto = false;
        double percentagemDesc = 0;
        if (primeiraLetra == 'S') {
            temDesconto = true;
            do {
                System.out.print("Qual a porcentagem do desconto? (Máximo 5%): ");
                percentagemDesc = tec.nextDouble();
                tec.nextLine();
            } while (percentagemDesc > 5 || percentagemDesc < 0);
        }

        // Adicionar novo cliente final ao ArrayList
        System.out.println("Cliente cadastrado com sucesso.");
        clientesFinais.add(new ClienteFinal(id, nome, nif, telefone, email, temDesconto, percentagemDesc));
    }

    // Método para cadastrar Cliente Revendedor
    private static void cadastrarClienteRevendedor() {
        double descontoPecas = 0.20;
        double descontoMaoObra = 0.10;
        System.out.print("Insira o ID: ");
        int id = tec.nextInt();
        tec.nextLine();

        // Verificar se o ID já existe
        for (ClienteRevendedor cliente : clientesRevendedores) {
            if (cliente.getId() == id) {
                System.out.println("[Erro] ID já cadastrado. Tente novamente.");
                return;
            }
        }

        // Pedir os dados ao utilizador
        System.out.print("Insira o nome completo: ");
        String nome = tec.nextLine();
        System.out.print("Insira o NIF: ");
        String nif = tec.nextLine();
        System.out.print("Insira o telefone: ");
        String telefone = tec.nextLine();
        System.out.print("Insira o email: ");
        String email = tec.nextLine();

        // Adicionar novo cliente revendedor ao ArrayList
        System.out.println("Cliente cadastrado com sucesso.");
        clientesRevendedores.add(new ClienteRevendedor(id, nome, nif, telefone, email, descontoPecas, descontoMaoObra));
    }

    // READ
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

    // UPDATE
    // Método para atualizar os clientes cadastrados
    private static void atualizarCliente() {
        int tipoCliente;
        do {
            System.out.print("Qual o tipo de cliente a ser atualizado? (1-Cliente Final ou 2-Cliente Revendedor): ");
            tipoCliente = tec.nextInt();
            tec.nextLine();
        } while (tipoCliente != 1 && tipoCliente != 2);

        if (tipoCliente == 1) {
            boolean clienteEncontrado = false;
            System.out.print("Insira o ID do cliente para atualizar os dados: ");
            int id = tec.nextInt();
            tec.nextLine();

            for (ClienteFinal clienteF : clientesFinais) {
                if (clienteF.getId() == id) {
                    clienteEncontrado = true;
                    System.out.print("Insira o nome atualizado: ");
                    String nome = tec.nextLine();
                    clienteF.setNome(nome);
                    System.out.print("Insira o NIF atualizado: ");
                    String nif = tec.nextLine();
                    clienteF.setNif(nif);
                    System.out.print("Insira o telefone atualizado: ");
                    String telefone = tec.nextLine();
                    clienteF.setTelefone(telefone);
                    System.out.print("Insira o email atualizado: ");
                    String email = tec.nextLine();
                    clienteF.setEmail(email);
                    System.out.println("Dados atualizados com sucesso.");
                }
            }
            if (!clienteEncontrado) {
                System.out.println("ID de cliente não encontrado.");
            }
        } else {
            boolean clienteEncontrado = false;
            System.out.print("Insira o ID do cliente para atualizar os dados: ");
            int id = tec.nextInt();
            tec.nextLine();

            for (ClienteRevendedor clienteR : clientesRevendedores) {
                if (clienteR.getId() == id) {
                    clienteEncontrado = true;
                    System.out.print("Insira o nome atualizado: ");
                    String nome = tec.nextLine();
                    clienteR.setNome(nome);
                    System.out.print("Insira o NIF atualizado: ");
                    String nif = tec.nextLine();
                    clienteR.setNif(nif);
                    System.out.print("Insira o telefone atualizado: ");
                    String telefone = tec.nextLine();
                    clienteR.setTelefone(telefone);
                    System.out.print("Insira o email atualizado: ");
                    String email = tec.nextLine();
                    clienteR.setEmail(email);
                    System.out.println("Dados atualizados com sucesso.");
                }
            }
            if (!clienteEncontrado) {
                System.out.println("ID de cliente não encontrado.");
            }
        }
    }
}
