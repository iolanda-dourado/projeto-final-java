package controle;

import modelo.Cliente;
import modelo.ClienteFinal;
import modelo.ClienteRevendedor;
import modelo.Ticket;
import modelo.Relatorio;
import modelo.Orcamento;
import modelo.Reparacao;
import visualizacao.Menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GestaoCT {
    private static Scanner tec = new Scanner(System.in);
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
                    consultarClientePorID();
                    break;
                case 15:
                    consultarClientesTodos();
                    break;
                case 16:
                    consultaParametrizadaCliente();
                    break;
                case 17:
                    consultarClientesTicketAberto();
                    break;
                case 18:
                    consultarClientesTicketFechado();
                    break;
                case 19:
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
                    consultarTicketsTodos();
                    break;
                case 35:
                    consultaParametrizadaTicket();
                    break;
                case 36:
                    consultarTicketsAbertos();
                    break;
                case 37:
                    consultarTicketsFinalizados();
                    break;
                case 38:
                    transformarEstadoTicket(); // Ex: transformar em relatório, orçamento, reparação
                    break;
                case 39:
                    eliminarTicketPorID();
                    break;
                case 0:
                    System.out.println("Obrigado por utilizar o serviço.");
                    System.out.println("BACKUP FEITO COM SUCESSO!");
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
        int id = Functions.recebeInteiro();

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
        System.out.print("Insira o ID do cliente: ");
        int id = Functions.recebeInteiro();

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
    private static void consultarClientePorID() {
        System.out.print("Insira o ID do cliente: ");
        int id = Functions.recebeInteiro();

        boolean clienteEncontrado = false;
        Menu.imprimeCabecalhoClientes();
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
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            Menu.imprimeCabecalhoClientes();
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }


    // 16 - Consulta parametrizada
    // por ID inicial ao ID final, por tipo de cliente (F, R), por letra inicial a letra final
    private static void consultaParametrizadaCliente() {
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

        Menu.imprimeCabecalhoClientes();

        // Processando e imprimindo os clientes que atendem aos critérios
        for (Cliente cliente : clientes) {
            if (cliente.getId() >= idInicial && cliente.getId() <= idFinal) {
                boolean deveImprimir = false;

                // Verificando o tipo de cliente
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

                // Verificando o intervalo de letras
                if (deveImprimir) {
                    char letraCliente = cliente.getNome().trim().toUpperCase().charAt(0);
                    if (letraCliente >= letraInicial && letraCliente <= letraFinal) {
                        System.out.println(cliente);
                        ;
                    }
                }
            }
        }
    }

    // 17 - Consultar Clientes com Ticket em aberto
    private static void consultarClientesTicketAberto() {
        ArrayList<Integer> clientesComTicketAberto = new ArrayList<>();

        // Verificar todos os tickets e coletar IDs de clientes com tickets abertos
        for (Ticket ticket : tickets) {
            if (ticket instanceof Relatorio || ticket instanceof Orcamento) {
                if (!clientesComTicketAberto.contains(ticket.getIdCliente())) {
                    clientesComTicketAberto.add(ticket.getIdCliente());
                }
            }
        }

        if (clientesComTicketAberto.isEmpty()) {
            System.out.println("Nenhum cliente com tickets em aberto encontrado.");
        } else {
            // Imprimir todos os clientes com tickets em aberto
            System.out.println("Clientes com tickets em aberto:");
            Menu.imprimeCabecalhoClientes();
            for (Cliente cliente : clientes) {
                if (clientesComTicketAberto.contains(cliente.getId())) {
                    System.out.println(cliente);
                }
            }
        }
    }

    // 18 - Consultar Clientes com Ticket fechado
    private static void consultarClientesTicketFechado() {
        ArrayList<Integer> clientesComTicketFechado = new ArrayList<>();

        // Verificar todos os tickets e coletar IDs de clientes com tickets fechados
        for (Ticket ticket : tickets) {
            if (ticket instanceof Reparacao) {
                if (!clientesComTicketFechado.contains(ticket.getIdCliente())) {
                    clientesComTicketFechado.add(ticket.getIdCliente());
                }
            }
        }

        if (clientesComTicketFechado.isEmpty()) {
            System.out.println("Nenhum cliente com tickets fechados encontrado.");
        } else {
            // Imprimir todos os clientes com tickets fechados
            System.out.println("Clientes com tickets fechados:");
            Menu.imprimeCabecalhoClientes();
            for (Cliente cliente : clientes) {
                if (clientesComTicketFechado.contains(cliente.getId())) {
                    System.out.println(cliente);
                }
            }
        }
    }


    // 19 - Eliminar cliente por ID
    private static void eliminarClientePorID() {
        System.out.print("Insira o ID do cliente: ");
        int id = Functions.recebeInteiro();

        boolean clienteEncontrado = false;
        boolean clienteTemTicket = false;

        // Verificar se o cliente tem algum ticket associado
        for (Ticket ticket : tickets) {
            if (ticket.getIdCliente() == id) {
                clienteTemTicket = true;
                break;
            }
        }

        if (clienteTemTicket) {
            System.out.println("[Erro] Não é possível remover o cliente. O cliente tem tickets associados.");
        } else {
            // Tentar encontrar e remover o cliente
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    clientes.remove(cliente);
                    clienteEncontrado = true;
                    System.out.println("Cliente removido com sucesso.");
                    break;
                }
            }

            if (!clienteEncontrado) {
                System.out.println("[Aviso] ID de cliente não encontrado.");
            }
        }
    }


    /**************************************************
     ********* MÉTODOS PARA GESTÃO DE TICKETS ********
     **************************************************/

    // 31 - Registar um novo ticket
    private static void registarTicket() {
        System.out.print("Insira o ID do ticket: ");
        int id = Functions.recebeInteiro();

        // Verificar se o ID já existe
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                System.out.println("[Erro] ID do ticket já cadastrado. Tente novamente.");
                return;
            }
        }

        // Leitura e conversão das datas
        System.out.print("Insira a data de início (yyyy-MM-dd): ");
        Date dataInicio = Functions.recebeData();
        System.out.print("Insira a data de fim (yyyy-MM-dd): ");
        Date dataFim = Functions.recebeData();
        //System.out.println("Data de Início: " + dataInicio);
        //System.out.println("Data de Fim: " + dataFim);

        System.out.print("Insira o ID do cliente: ");
        int idCliente = Functions.recebeInteiro();
        System.out.print("Insira o tipo de cliente (Final/Revendedor): ");
        String tipoCliente = Functions.recebeString();
        System.out.print("Insira a descrição do histórico: ");
        String descHistorico = Functions.recebeString();
        System.out.print("Insira o valor dos serviços: ");
        double valorServicos = Functions.recebeDouble();
        System.out.print("Insira o valor das peças: ");
        double valorPecas = Functions.recebeDouble();

        tickets.add(new Ticket(id, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas));
        System.out.println("Ticket registado com sucesso.");
    }


    // 32 - Alterar dados de um ticket por ID
    private static void alterarTicketPorID() {
        System.out.print("Insira o ID do ticket: ");
        int id = Functions.recebeInteiro();
        boolean ticketEncontrado = false;

        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
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


    // 33 - Consultar um ticket por ID
    private static void consultarTicketPorID() {
        System.out.print("Insira o ID do ticket: ");
        int id = Functions.recebeInteiro();

        boolean ticketEncontrado = false;

        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                System.out.println(ticket);
                ticketEncontrado = true;
                break;
            }
        }

        if (!ticketEncontrado) {
            System.out.println("ID do ticket não encontrado.");
        }
    }


    // 34 - Consultar todos os tickets
    private static void consultarTicketsTodos() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            Menu.imprimeCabecalhoTickets();
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
            }
        }
    }


    // 35 - Consulta parametrizada de tickets
    // por ID inicial ao ID final, por tipo de ticket (Orç, Rel, Rep), por letra inicial a letra final, por tipo de cliente (F, R)
    private static void consultaParametrizadaTickets() {
        // Recebendo o intervalo de IDs
        System.out.print("Do ID: ");
        int idInicial = Functions.recebeInteiro();
        System.out.print("Ao ID: ");
        int idFinal = Functions.recebeInteiro();

        // Recebendo o tipo de ticket
        char tipoTicket;
        do {
            System.out.println("R - Relatório \nO - Orçamento \nP - Reparação \nT - Todos");
            System.out.print("Tipo de Ticket: ");
            tipoTicket = tec.nextLine().trim().toUpperCase().charAt(0);
        } while (tipoTicket != 'R' && tipoTicket != 'O' && tipoTicket != 'P' && tipoTicket != 'T');

        // Recebendo o intervalo de letras do nome do cliente
        System.out.print("Da letra (nome do cliente): ");
        char letraInicial = tec.nextLine().trim().toUpperCase().charAt(0);
        System.out.print("Até a letra (nome do cliente): ");
        char letraFinal = tec.nextLine().trim().toUpperCase().charAt(0);

        // Recebendo o tipo de cliente
        char tipoCliente;
        do {
            System.out.println("F - Finais \nR - Revendedores \nT - Todos");
            System.out.print("Tipo de Cliente: ");
            tipoCliente = tec.nextLine().trim().toUpperCase().charAt(0);
        } while (tipoCliente != 'F' && tipoCliente != 'R' && tipoCliente != 'T');

        // Imprime os tickets que atendem aos critérios
        boolean ticketEncontrado = false;
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() >= idInicial && ticket.getIdTicket() <= idFinal) {
                boolean deveImprimir = false;

                // Veri o tipo de ticket
                switch (tipoTicket) {
                    case 'R':
                        if (ticket instanceof Relatorio) {
                            deveImprimir = true;
                        }
                        break;
                    case 'O':
                        if (ticket instanceof Orcamento) {
                            deveImprimir = true;
                        }
                        break;
                    case 'P':
                        if (ticket instanceof Reparacao) {
                            deveImprimir = true;
                        }
                        break;
                    case 'T':
                        deveImprimir = true;
                        break;
                }

                // Verificando o tipo de cliente
                if (deveImprimir) {
                    switch (tipoCliente) {
                        case 'F':
                            if (ticket.getTipoCliente().equalsIgnoreCase("Final")) {
                                deveImprimir = true;
                            } else {
                                deveImprimir = false;
                            }
                            break;
                        case 'R':
                            if (ticket.getTipoCliente().equalsIgnoreCase("Revendedor")) {
                                deveImprimir = true;
                            } else {
                                deveImprimir = false;
                            }
                            break;
                        case 'T':
                            deveImprimir = true;
                            break;
                    }
                }

                // Verificando o intervalo de letras no nome do cliente
                if (deveImprimir) {
                    for (Cliente cliente : clientes) {
                        if (cliente.getId() == ticket.getIdCliente()) {
                            char letraCliente = cliente.getNome().trim().toUpperCase().charAt(0);
                            if (letraCliente >= letraInicial && letraCliente <= letraFinal) {
                                System.out.println(ticket);
                                ticketEncontrado = true;
                            }
                        }
                    }
                }
            }
        }

        if (!ticketEncontrado) {
            System.out.println("Nenhum ticket encontrado com os parâmetros especificados.");
        }
    }



    // 36 - Consulta de tickets em aberto
    // São considerados tickets em aberto aqueles de tipo Relatório e Orçamento
    private static void consultarTicketsAbertos() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            Menu.imprimeCabecalhoTickets();
            for (Ticket ticket : tickets) {
                if (ticket instanceof Relatorio || ticket instanceof Orcamento) {
                    System.out.println(ticket);
                }
            }
        }
    }


    // 37 - Consulta de tickets finalizados ******************************************
    // São considerados tickets finalizados aqueles de tipo Reparação
    private static void consultarTicketsFinalizados() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            Menu.imprimeCabecalhoTickets();
            for (Ticket ticket : tickets) {
                if (ticket instanceof Relatorio || ticket instanceof Orcamento) {
                    System.out.println(ticket);
                }
            }
        }
    }

    // 38 - Alterar para Relatório, Orçamento ou Reparação
    private static void transformarEstadoTicket() {
        System.out.print("Insira o ID do ticket a ser alterado: ");
        int id = Functions.recebeInteiro();

        Ticket ticketParaAlterar = null;

        // Verificar se o ticket existe
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                ticketParaAlterar = ticket;
                break;
            }
        }

        if (ticketParaAlterar == null) {
            System.out.println("[Erro] Ticket não encontrado.");
            return;
        }

        if (ticketParaAlterar instanceof Relatorio) {
            // Se for um Relatório
            System.out.print("Deseja gerar uma Reparação? (S/N): ");
            char resposta = Functions.recebeChar();
            if (resposta == 'S') {
                System.out.print("Insira o responsável pela reparação: ");
                String responsavel = Functions.recebeString();
            } else if (resposta == 'N') {
                System.out.println("[Aviso] Alteração cancelada.");
            } else {
                System.out.println("[Erro] Resposta inválida.");
            }
        } else if (ticketParaAlterar instanceof Orcamento) {
            boolean temReparacaoAssociada = false;
            for (Ticket ticket : tickets) {
                if (ticket instanceof Reparacao && ticket.getIdTicket() == id) {
                    temReparacaoAssociada = true;
                    break;
                }
            }

            if (temReparacaoAssociada) {
                System.out.println("[Erro] Não é possível eliminar um Orçamento que tenha dado origem a uma Reparação.");
            } else {
                tickets.remove(ticketParaAlterar);
                System.out.println("Orçamento eliminado com sucesso.");
            }
        } else if (ticketParaAlterar instanceof Reparacao) {
            if (ticketParaAlterar.getDataFim() == null) {
                tickets.remove(ticketParaAlterar);
                System.out.println("Reparação eliminada com sucesso.");
            } else {
                System.out.println("[Erro] Não é possível eliminar uma Reparação que já está fechada.");
            }
        } else {
            System.out.println("[Erro] Tipo de ticket desconhecido.");
        }
    }



    // 39 - Eliminar um ticket por ID
    private static void eliminarTicketPorID() {
        System.out.print("Insira o ID do ticket: ");
        int id = Functions.recebeInteiro();

        boolean ticketEncontrado = false;

        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getIdTicket() == id) {
                    tickets.remove(i);
                    ticketEncontrado = true;
                    System.out.println("Ticket removido com sucesso.");
                    break;
                }
            }

        }

        if (!ticketEncontrado) {
            System.out.println("ID do ticket não encontrado.");
        }
    }


    // ******ACHO QUE ESSE DAQUI VAI VIRAR PARTE DA CONSULTA PARAMETRIZADA (opção 35)******
    // 47 Consultar tickets por tipo de cliente
    /*private static void consultarTicketsPorCliente() {
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
    }*/


    /*// Backup dos clientes
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
    }*/
}
