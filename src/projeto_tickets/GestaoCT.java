package projeto_tickets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class GestaoCT {
    private static Scanner tec = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    // Método para apresentar o menu geral para os dois tipos de clientes e a escolha de opções
    public static void menuGerenciamento() {
        int resposta;
        do {
            Menu.mostraMenu();
            System.out.print("Insira sua opção: ");
            resposta = tec.nextInt();
            tec.nextLine();

            switch (resposta) {
                // CLIENTES
                case 11:
                    cadastrarCliente("final");
                    break;
                case 12:
                    cadastrarCliente("revendedor");
                    break;
                case 13:
                    alterarClientePorID();
                    break;
                case 14:
                    consultarClienteID();
                    break;
                case 15:
                    consultarClientesTodos();
                    break;
                case 16:
                    consultaParametrizada();
                    break;
                case 17:
                    consultarClientesTicketAberto();
                    break;
                case 18:
                    eliminarClientePorID();
                    break;

                // TICKETS
                case 31:
                    registarTicket();
                    break;
                case 32:
                    alterarTicketPorID();
                    break;
                case 33:
                    consultarTicketPorID();
                    break;
                case 34:
                    //consultarTicketsTodos();
                    break;
                case 35:
                    consultaParametrizada();
                    break;
                case 36:
                    //consultarPorData();
                    break;
                case 37:
                    //consultarTicketsAbertos();
                    break;
                case 38:
                    //consultarTicketsFinalizados();
                    break;
                case 39:
                    //transformarEstadoTicket(); // Ex: transformar em relatório, orçamento, reparação
                    break;
                case 40:
                    eliminarTicketPorID();
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


    /**************************************************
     ********* MÉTODOS PARA GESTÃO DE CLIENTES ********
     **************************************************/

    // 11 e 12 - Cadastrar Cliente Final ou Revendedor
    private static void cadastrarCliente(String tipo) {
        System.out.print("Insira o ID: ");
        int id = tec.nextInt();
        tec.nextLine();

        // Verifica se o ID já existe
        for (Cliente cliente : clientes) {
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

        if (tipo.equals("final")) {
            // Verifica se o cliente tem desconto
            char primeiraLetra;
            do {
                System.out.print("O cliente final tem desconto? [S/N]: ");
                String desconto = tec.nextLine().trim().toUpperCase();
                primeiraLetra = desconto.isEmpty() ? ' ' : desconto.charAt(0); // Verifica se a string não está vazia

                if (primeiraLetra != 'S' && primeiraLetra != 'N') {
                    System.out.println("[Erro] Insira uma opção válida: S/N.");
                }
            } while (primeiraLetra != 'S' && primeiraLetra != 'N');

            // Verifica qual é a porcentagem do desconto
            boolean temDesconto = false;
            double percentagemDesc = 0;
            if (primeiraLetra == 'S') {
                temDesconto = true;
                do {
                    System.out.print("Qual a porcentagem do desconto? (Maior que 0 e até 5): ");
                    percentagemDesc = tec.nextDouble();
                    tec.nextLine();

                    if (percentagemDesc > 5 || percentagemDesc <= 0) {
                        System.out.println("[Erro] Insira um valor maior que 0 e até 5.");
                    }
                } while (percentagemDesc > 5 || percentagemDesc <= 0);
            }

            // Adicionar novo cliente final ao ArrayList
            System.out.println("\n----> Cliente final cadastrado com sucesso.");
            clientes.add(new ClienteFinal(id, nome, nif, telefone, email, temDesconto, percentagemDesc));
        } else if (tipo.equals("revendedor")) {
            double descontoPecas = 0.20;
            double descontoMaoObra = 0.10;
            // Adicionar novo cliente revendedor ao ArrayList
            System.out.println("\n----> Cliente revendedor cadastrado com sucesso.");
            clientes.add(new ClienteRevendedor(id, nome, nif, telefone, email, descontoMaoObra, descontoPecas));
        }
    }


    // 13 - Alterar cliente cadastrado pelo ID
    private static void alterarClientePorID() {
        System.out.print("Insira o ID do cliente para atualizar os dados: ");
        int id = tec.nextInt();
        tec.nextLine();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.print("Insira o nome atualizado: ");
            String nome = tec.nextLine();
            clienteEncontrado.setNome(nome);
            System.out.print("Insira o NIF atualizado: ");
            String nif = tec.nextLine();
            clienteEncontrado.setNif(nif);
            System.out.print("Insira o telefone atualizado: ");
            String telefone = tec.nextLine();
            clienteEncontrado.setTelefone(telefone);
            System.out.print("Insira o email atualizado: ");
            String email = tec.nextLine();
            clienteEncontrado.setEmail(email);
            System.out.println("---> Dados atualizados com sucesso.");
        } else {
            System.out.println("ID de cliente não encontrado.");
        }
    }


    // 14 - Consultar cliente por ID
    private static void consultarClienteID() {
        System.out.print("Insira o ID do cliente para consultar: ");
        int id = tec.nextInt();
        tec.nextLine();

        boolean clienteEncontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                System.out.println(cliente);
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("Cliente com ID " + id + " não encontrado.");
        }
    }

    // 15 - Consultar todos os clientes cadastrados
    private static void consultarClientesTodos() {
        System.out.println("\nLista de Clientes");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            Functions.imprimeCabecalhoClientes();
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }


    // 16 - Consulta parametrizada
    // por ID inicial ao ID final, por tipo de cliente (F, R), por letra inicial a letra final
    private static void consultaParametrizada() {
        System.out.print("Do ID: ");
        int idInicial = tec.nextInt();
        tec.nextLine();
        System.out.print("Ao ID: ");
        int idFinal = tec.nextInt();
        tec.nextLine();

        char tipo;
        do {
            System.out.println("R - Revendedores \nF - Finais \nT - Todos");
            System.out.print("Tipo: ");
            tipo = tec.nextLine().trim().toUpperCase().charAt(0);
        } while (tipo != 'R' && tipo != 'F' && tipo != 'T');

        System.out.print("Da letra: ");
        char letraInicial = tec.nextLine().trim().toUpperCase().charAt(0);
        System.out.print("Até a letra: ");
        char letraFinal = tec.nextLine().trim().toUpperCase().charAt(0);

        Functions.imprimeCabecalhoClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getId() >= idInicial && cliente.getId() <= idFinal) {
                boolean deveImprimir = false;
                switch (tipo) {
                    case 'F':
                        if (cliente instanceof ClienteFinal) {
                            deveImprimir = true;
                        }
                        break;
                    case 'R':
                        if (cliente instanceof ClienteRevendedor) {
                            deveImprimir = true;
                        }
                        break;
                    case 'T':
                        deveImprimir = true;
                        break;
                }
            }

        }
    }


    // 17 - Consultar Clientes com Ticket em aberto
    private static void consultarClientesTicketAberto() {

    }


// 18 - Eliminar clientes cadastrados por ID
    //System.out.print("Insira o ID do cliente a ser eliminado: ");

    private static void eliminarClientePorID() {
        int id = tec.nextInt();
        tec.nextLine();

        boolean clienteEncontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                clienteEncontrado = true;
                System.out.println("Cliente removido com sucesso.");
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("ID de cliente não encontrado.");
        }
    }


    /**************************************************
     ********* MÉTODOS PARA GESTÃO DE TICKETS ********
     **************************************************/

// 41 - Registar um novo ticket
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

        // Leitura e conversão das datas
        Date dataInicio = null;
        Date dataFim = null;
        try {
            System.out.print("Insira a data de início (yyyy-MM-dd): ");
            String dataInicioStr = tec.nextLine();
            dataInicio = dateFormat.parse(dataInicioStr);

            System.out.print("Insira a data de fim (yyyy-MM-dd): ");
            String dataFimStr = tec.nextLine();
            dataFim = dateFormat.parse(dataFimStr);
        } catch (ParseException e) {
            System.out.println("[Erro] Formato de data inválido. Certifique-se de usar o formato yyyy-MM-dd.");
            return;
        }

        System.out.print("Insira o ID do cliente: ");
        int idCliente = tec.nextInt();
        tec.nextLine();
        System.out.print("Insira o tipo de cliente (Final/Revendedor): ");
        String tipoCliente = tec.nextLine();
        System.out.print("Insira a descrição do histórico: ");
        String descHistorico = tec.nextLine();
        System.out.print("Insira o valor dos serviços: ");
        double valorServicos = tec.nextDouble();
        tec.nextLine();
        System.out.print("Insira o valor das peças: ");
        double valorPecas = tec.nextDouble();
        tec.nextLine();

        tickets.add(new Ticket(id, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas));
        System.out.println("Ticket registrado com sucesso.");
    }


    // 42 - Alterar dados de um ticket por ID
    private static void alterarTicketPorID() {
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


    // 43 - Consultar um ticket por ID
    private static void consultarTicketPorID() {
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

    // 47 Consultar tickets por tipo de cliente
    private static void consultarTicketsPorCliente() {
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


    // 50 - Eliminar um ticket por ID
    private static void eliminarTicketPorID() {
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


    // Backup dos clientes
    public static void gravaClientes(ArrayList<Cliente> clientes, String nomeFicheiro) {
        File f = new File(nomeFicheiro);
        try {
            f.createNewFile();              //Criar novo ficheiro
            ObjectOutputStream ficheiro = new ObjectOutputStream(new FileOutputStream(nomeFicheiro));
            ficheiro.writeObject(clientes); // Escrever o arrayList no ficheiro
            System.out.println("Backup de clientes executado com sucesso ");
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
                System.out.println("Restaudo de dados realizado com sucesso.");
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
}




