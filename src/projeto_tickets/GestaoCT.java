package projeto_tickets;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class GestaoCT {
    private static Scanner tec = new Scanner(System.in);
    private static ArrayList<ClienteFinal> clientesFinais = new ArrayList<>();
    private static ArrayList<ClienteRevendedor> clientesRevendedores = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    // Método para apresentar o menu geral para os dois tipos de clientes e a escolha de opções
    public static void cadastrarClienteGeral() {
        int resposta;
        do {
            Menu.menu();
            System.out.print("Insira sua opção: ");
            resposta = tec.nextInt();
            tec.nextLine();

            switch (resposta) {
                case 31:
                    cadastrarClienteFinal();
                    break;
                case 32:
                    cadastrarClienteRevendedor();
                    break;
                case 33:
                    visualizarClientes();
                    break;
                case 34:
                    atualizarCliente();
                    break;
                case 35:
                    eliminarClienteID();
                    break;
                case 41:
                    registarTicket();
                    break;
                case 42:
                    alterarDadosTicket();
                    break;
                case 43:
                    consultarTicketID();
                    break;
                case 44:
                    eliminarTicketID();
                    break;
                case 45:
                    consultaParametrizada();
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
        System.out.println("\n----> Cliente final cadastrado com sucesso.\n");
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
        System.out.println("\n----> Cliente revendedor cadastrado com sucesso.\n");
        clientesRevendedores.add(new ClienteRevendedor(id, nome, nif, telefone, email, descontoPecas, descontoMaoObra));
    }

    // READ
    // Método para visualizar clientes cadastrados
    private static void visualizarClientes() {
        System.out.println("\nClientes Finais cadastrados: ");
        if (clientesFinais.isEmpty()) {
            System.out.println("Nenhum Cliente Final cadastrado.");
        } else {
            for (ClienteFinal clienteF : clientesFinais) {
                System.out.println(clienteF);
            }
        }

        System.out.println("\nClientes Revendedores cadastrados: ");
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
                    System.out.println("---> Dados atualizados com sucesso.");
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

    // DELETE
    // Método para eliminar clientes cadastrados por ID
    private static void eliminarClienteID() {
        System.out.print("Insira o ID do cliente a ser eliminado: ");
        int id = tec.nextInt();
        tec.nextLine();

        boolean clienteEncontrado = false;

        for (int i = 0; i < clientesFinais.size(); i++) {
            if (clientesFinais.get(i).getId() == id) {
                clientesFinais.remove(i);
                clienteEncontrado = true;
                System.out.println("Cliente final removido com sucesso.");
                break;
            }
        }

        if (!clienteEncontrado) {
            for (int i = 0; i < clientesRevendedores.size(); i++) {
                if (clientesRevendedores.get(i).getId() == id) {
                    clientesRevendedores.remove(i);
                    clienteEncontrado = true;
                    System.out.println("Cliente revendedor removido com sucesso.");
                    break;
                }
            }
        }

        if (!clienteEncontrado) {
            System.out.println("ID de cliente não encontrado.");
        }
    }

    // Métodos para gestão de tickets

    // Método para registrar um novo ticket
    private static void registarTicket() {
        System.out.print("Insira o ID do ticket: ");
        int id = tec.nextInt();
        tec.nextLine();

        // Verificar se o ID já existe
        for (Ticket ticket : tickets) {
            if (ticket.getIdReparacao() == id) {
                System.out.println("[Erro] ID do ticket já cadastrado. Tente novamente.");
                return;
            }
        }

        System.out.print("Insira a data de início (yyyy-mm-dd): ");
        String dataInicioStr = tec.next();
        Date dataInicio = Date.valueOf(dataInicioStr);
        System.out.print("Insira o ID do cliente: ");
        int idCliente = tec.nextInt();
        tec.nextLine();
        System.out.print("Insira o tipo de cliente (Final/Revendedor): ");
        String tipoCliente = tec.nextLine();
        System.out.print("Insira a descrição do histórico: ");
        String descHistorico = tec.nextLine();
        System.out.print("Insira a data de fim (yyyy-mm-dd): ");
        String dataFimStr = tec.next();
        Date dataFim = Date.valueOf(dataFimStr);
        System.out.print("Insira o valor dos serviços: ");
        double valorServicos = tec.nextDouble();
        tec.nextLine();
        System.out.print("Insira o valor das peças: ");
        double valorPecas = tec.nextDouble();
        tec.nextLine();

        tickets.add(new Ticket(id, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas));
        System.out.println("Ticket registrado com sucesso.");
    }

    // Método para alterar dados de um ticket existente
    private static void alterarDadosTicket() {
        System.out.print("Insira o ID do ticket a ser alterado: ");
        int id = tec.nextInt();
        tec.nextLine();
        boolean ticketEncontrado = false;

        for (Ticket ticket : tickets) {
            if (ticket.getIdReparacao() == id) {
                System.out.print("Insira a nova descrição do histórico: ");
                String novoHistorico = tec.nextLine();
                ticket.setDescHistorico(novoHistorico);
                ticketEncontrado = true;
                System.out.println("Dados do ticket alterados com sucesso.");
                break;
            }
        }

        if (!ticketEncontrado) {
            System.out.println("ID do ticket não encontrado.");
        }
    }

    // Método para consultar um ticket por ID
    private static void consultarTicketID() {
        System.out.print("Insira o ID do ticket a ser consultado: ");
        int id = tec.nextInt();
        tec.nextLine();
        boolean ticketEncontrado = false;

        for (Ticket ticket : tickets) {
            if (ticket.getIdReparacao() == id) {
                System.out.println(ticket);
                ticketEncontrado = true;
                break;
            }
        }

        if (!ticketEncontrado) {
            System.out.println("ID do ticket não encontrado.");
        }
    }

    // Método para eliminar um ticket por ID
    private static void eliminarTicketID() {
        System.out.print("Insira o ID do ticket a ser eliminado: ");
        int id = tec.nextInt();
        tec.nextLine();
        boolean ticketEncontrado = false;

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getIdReparacao() == id) {
                tickets.remove(i);
                ticketEncontrado = true;
                System.out.println("Ticket removido com sucesso.");
                break;
            }
        }

        if (!ticketEncontrado) {
            System.out.println("ID do ticket não encontrado.");
        }
    }

    // Método para consulta parametrizada (exemplo: consultar tickets por tipo de cliente)
    private static void consultaParametrizada() {
        System.out.print("Insira o tipo de cliente para consulta (Final/Revendedor): ");
        String tipoCliente = tec.nextLine();
        boolean ticketEncontrado = false;

        for (Ticket ticket : tickets) {
            if (ticket.getTipoCliente().equalsIgnoreCase(tipoCliente)) {
                System.out.println(ticket);
                ticketEncontrado = true;
            }
        }

        if (!ticketEncontrado) {
            System.out.println("Nenhum ticket encontrado para o tipo de cliente especificado.");
        }
    }
}
