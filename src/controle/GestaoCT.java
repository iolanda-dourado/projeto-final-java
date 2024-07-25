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

public class GestaoCT {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Ticket> tickets = new ArrayList<>();

    // Método para apresentar o menu geral para os dois tipos de clientes e a escolha de opções
    public static void menuGerenciamento() {
        // Restaura os dados ao chamar o método menuGerenciamento()
        clientes = Backup.lerClientes("clientes.bk");
        if (clientes == null || clientes.isEmpty())
            clientes = new ArrayList<>();

        tickets = Backup.lerTickets("tickets.bk");
        if (tickets == null || tickets.isEmpty())
            tickets = new ArrayList<>();

        int resposta;
        do {
            Menu.mostraMenu();
            System.out.print("Insira sua opção: ");
            resposta = Functions.recebeInteiro();

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
                    consultarTicketsFechados();
                    break;
                case 38:
                    transformarEstadoTicket(); // Ex: transformar em relatório, orçamento, reparação
                    break;
                case 39:
                    eliminarTicketPorID();
                    break;
                case 40:
                    /*clientes = Backup.lerClientes("clientes.bk");
                    if (clientes == null || clientes.isEmpty())
                        clientes = new ArrayList<>();

                    tickets = Backup.lerTickets("tickets.bk");
                    if (tickets == null || tickets.isEmpty())
                        tickets = new ArrayList<>();*/
                case 0:
                    System.out.println("[Sucesso] Obrigado por utilizar o serviço!");
                    Backup.gravaClientes(clientes, "clientes.bk");
                    Backup.gravaTickets(tickets, "tickets.bk");
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
        String nome = Functions.recebeString();
        System.out.print("Insira o NIF: ");
        String nif = Functions.recebeString();
        System.out.print("Insira o telefone: ");
        String telefone = Functions.recebeString();
        /*System.out.print("Insira o email: ");
        String email = Functions.recebeString();*/

        double percentagemDesc = 0;
        if (tipo.equals("final")) {
            System.out.print("O cliente final tem desconto? [S/N]: ");
            boolean desconto = Functions.validaSeN();

            // Verifica qual é a porcentagem do desconto
            percentagemDesc = 0;
            if (desconto) {
                do {
                    System.out.print("Qual a percentagem do desconto? (Maior que 0 e até 5): ");
                    percentagemDesc = Functions.recebeDouble();

                    if (percentagemDesc > 5 || percentagemDesc <= 0) {
                        System.out.println("[Erro] Insira um valor maior que 0 e até 5.");
                    }
                } while (percentagemDesc > 5 || percentagemDesc <= 0);
            }

            // Adicionar novo cliente final ao ArrayList
            System.out.println("\n[Sucesso] Cliente final cadastrado com sucesso.");
            clientes.add(new ClienteFinal(id, nome, nif, telefone, percentagemDesc));
        } else if (tipo.equals("revendedor")) {
            double descontoPecas = 0.20;
            double descontoMaoObra = 0.10;
            // Adicionar novo cliente revendedor ao ArrayList
            System.out.println("\n[Sucesso] Cliente revendedor cadastrado com sucesso.");
            clientes.add(new ClienteRevendedor(id, nome, nif, telefone, descontoMaoObra, descontoPecas));
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
            String nome = Functions.recebeString();
            clienteEncontrado.setNome(nome);
            System.out.print("Insira o NIF atualizado: ");
            String nif = Functions.recebeString();
            clienteEncontrado.setNif(nif);
            System.out.print("Insira o telefone atualizado: ");
            String telefone = Functions.recebeString();
            clienteEncontrado.setTelefone(telefone);
        /*System.out.print("Insira o email atualizado: ");
        String email = Functions.recebeString();
        clienteEncontrado.setEmail(email);*/
            System.out.println("\n[Sucesso] Dados atualizados com sucesso.");
        } else {
            System.out.println("[Erro] ID de cliente não encontrado.");
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
            Menu.imprimeFimClientes();
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
            Menu.imprimeFimClientes();
        }
    }


    // 16 - Consulta parametrizada
// por ID inicial ao ID final, por tipo de cliente (F, R), por letra inicial a letra final
    private static void consultaParametrizadaCliente() {
        System.out.print("Do ID: ");
        int idInicial = Functions.recebeInteiro();
        System.out.print("Ao ID: ");
        int idFinal = Functions.recebeInteiro();

        char tipo;
        do {
            System.out.println("R - Revendedores \nF - Finais \nT - Todos");
            System.out.print("Tipo: ");
            tipo = Functions.recebeChar();
        } while (tipo != 'R' && tipo != 'F' && tipo != 'T');

        System.out.print("Da letra: ");
        char letraInicial = Functions.recebeChar();
        System.out.print("Até a letra: ");
        char letraFinal = Functions.recebeChar();

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
                    }
                }
            }
        }
        Menu.imprimeFimClientes();
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
            System.out.println("[Aviso] Nenhum cliente com tickets em aberto encontrado.");
        } else {
            // Imprimir todos os clientes com tickets em aberto
            System.out.println("Clientes com tickets em aberto:");
            Menu.imprimeCabecalhoClientes();
            for (Cliente cliente : clientes) {
                if (clientesComTicketAberto.contains(cliente.getId())) {
                    System.out.println(cliente);
                }
            }
            Menu.imprimeFimClientes();
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
            Menu.imprimeFimClientes();
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
                    System.out.println("\n[Sucesso] Cliente removido com sucesso.");
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
        int idTicket = Functions.recebeInteiro();

        // Verificar se o ID do ticket já existe
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == idTicket) {
                System.out.println("[Erro] ID já cadastrado. Tente novamente.");
                return; // Interrompe o método se o ID já estiver cadastrado
            }
        }

        // Verificar se o cliente existe
        System.out.print("Insira o ID do cliente: ");
        int idCliente = Functions.recebeInteiro();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                cliente = c;
                break;
            }
        }
        if (cliente == null) {
            System.out.println("[Erro] Cliente não encontrado.");
            return; // Interrompe o método se o cliente não for encontrado
        }

        // Receber os dados do ticket
        System.out.print("Data de início (dd-MM-yyyy): ");
        Date dataInicio = Functions.recebeData();
        System.out.print("Data de fim (dd-MM-yyyy): ");
        Date dataFim = Functions.recebeData();
        System.out.print("Insira a descrição do histórico: ");
        String descHistorico = Functions.recebeString();
        System.out.print("Insira o valor dos serviços: ");
        double valorServicos = Functions.recebeDouble();
        System.out.print("Insira o valor das peças: ");
        double valorPecas = Functions.recebeDouble();

        // Criar e adicionar o novo ticket
        Ticket novoTicket = new Ticket(idTicket, cliente.getId(), dataInicio, dataFim, descHistorico, valorServicos, valorPecas, true);
        tickets.add(novoTicket);
        System.out.println("\n[Sucesso] Ticket registado com sucesso.");

    }


    // 32 - Alterar dados de um ticket por ID
    private static void alterarTicketPorID() {
        System.out.print("Insira o ID do ticket: ");
        int id = Functions.recebeInteiro();
        boolean ticketEncontrado = false;
        boolean resposta;

        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                ticketEncontrado = true;
                Menu.imprimeCabecalhoTickets();
                System.out.println(ticket);
                System.out.println("Deseja alterar o ticket? (S/N)");
                resposta = Functions.validaSeN();

                if (resposta) {
                    System.out.print("Insira a nova data de início (yyyy-MM-dd): ");
                    Date novaDataIni = Functions.recebeData();
                    ticket.setDataInicio(novaDataIni);

                    System.out.println("Insira a nova descrição histórica: ");
                    String novaDesc = Functions.recebeString();
                    ticket.setDescHistorico(novaDesc);

                    System.out.println("Insira a nova data de fim (yyyy-MM-dd): ");
                    Date novaDataFim = Functions.recebeData();
                    ticket.setDataFim(novaDataFim);

                    System.out.println("Insira o novo valor dos serviços: ");
                    double novoValorSer = Functions.recebeDouble();
                    ticket.setValorServicos(novoValorSer);

                    System.out.println("Insira o novo valor das peças: ");
                    double novoValorPec = Functions.recebeDouble();
                    ticket.setValorPecas(novoValorPec);

                    System.out.println("Ticket está aberto? ");
                    boolean aberto = Functions.validaSeN();
                    if (!aberto) {
                        ticket.setAberto(false);
                    }

                    System.out.println("\n[Sucesso] Dados do ticket alterados com sucesso.");
                    break;
                } else {
                    System.out.println("[Aviso] Alteração cancelada.");
                    return;
                }
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

        Menu.imprimeCabecalhoTickets();
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                System.out.println(ticket);
                ticketEncontrado = true;
                break;
            }
        }
        Menu.imprimeFimTickets();

        if (!ticketEncontrado) {
            System.out.println("Ticket com ID " + id + " não encontrado.");
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
            Menu.imprimeFimTickets();
        }
    }


    // 35 - Consulta parametrizada de tickets
    // por ID inicial ao ID final, por tipo de ticket (Orç, Rel, Rep), por letra inicial a letra final, por tipo de cliente (F, R)
    private static void consultaParametrizadaTicket() {
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
            tipoTicket = Functions.recebeChar();
        } while (tipoTicket != 'R' && tipoTicket != 'O' && tipoTicket != 'P' && tipoTicket != 'T');

        // Recebendo o intervalo de letras do nome do cliente
        System.out.print("Da letra (nome do cliente): ");
        char letraInicial = Functions.recebeChar();
        System.out.print("Até a letra (nome do cliente): ");
        char letraFinal = Functions.recebeChar();

        // Recebendo o tipo de cliente
        char tipoCliente;
        do {
            System.out.println("F - Finais \nR - Revendedores \nT - Todos");
            System.out.print("Tipo de Cliente: ");
            tipoCliente = Functions.recebeChar();
        } while (tipoCliente != 'F' && tipoCliente != 'R' && tipoCliente != 'T');

        // Imprime os tickets que atendem aos critérios
        boolean ticketEncontrado = false;
        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() >= idInicial && ticket.getIdTicket() <= idFinal) {
                boolean deveImprimir = false;

                // Verifica o tipo de ticket
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

                if (deveImprimir) {
                    // Verifica o tipo de cliente
                    Cliente cliente = null;
                    for (Cliente c : clientes) {
                        if (c.getId() == ticket.getIdCliente()) {
                            cliente = c;
                            break;
                        }
                    }

                    if (cliente != null) {
                        switch (tipoCliente) {
                            case 'F':
                                if (cliente instanceof ClienteFinal) {
                                    deveImprimir = true;
                                } else {
                                    deveImprimir = false;
                                }
                                break;
                            case 'R':
                                if (cliente instanceof ClienteRevendedor) {
                                    deveImprimir = true;
                                } else {
                                    deveImprimir = false;
                                }
                                break;
                            case 'T':
                                deveImprimir = true;
                                break;
                        }

                        // Verifica o intervalo de letras no nome do cliente
                        if (deveImprimir) {
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
    private static void consultarTicketsAbertos() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            Menu.imprimeCabecalhoTickets();
            for (Ticket ticket : tickets) {
                if (ticket.isAberto()) {
                    System.out.println(ticket);
                }
            }
            Menu.imprimeFimTickets();
        }
    }


    // 37 - Consulta de tickets fechados
    private static void consultarTicketsFechados() {
        if (tickets.isEmpty()) {
            System.out.println("Nenhum ticket registado.");
        } else {
            Menu.imprimeCabecalhoTickets();
            for (Ticket ticket : tickets) {
                if (!ticket.isAberto()) {
                    System.out.println(ticket);
                }
            }
            Menu.imprimeFimTickets();
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

        // Verifica em que tipo de subticket quer transformar
        int resposta;
        do {
            System.out.print("Transformar ticket em: \n1 - Orçamento | 2 - Relatório | 3 - Reparação \nInsira sua resposta: ");
            resposta = Functions.recebeInteiro();

            switch (resposta) {
                case 1:
                    Menu.imprimeCabecalhoTickets();
                    System.out.println(ticketParaAlterar);
                    Menu.imprimeFimTickets();
                    // Transformar em Orcamento
                    System.out.print("O orçamento está aprovado? (S/N): ");
                    boolean aprovado = Functions.validaSeN();

                    tickets.add(new Orcamento(ticketParaAlterar.getIdTicket(), ticketParaAlterar.getIdCliente(), ticketParaAlterar.getDataInicio(), ticketParaAlterar.getDataFim(), ticketParaAlterar.getDescHistorico(), ticketParaAlterar.getValorServicos(), ticketParaAlterar.getValorPecas(), ticketParaAlterar.isAberto(), aprovado));
                    System.out.println("\n[Sucesso] Ticket transformado em Orçamento com sucesso.");
                    tickets.remove(ticketParaAlterar);
                    break;

                case 2:
                    // Transformar em Relatório
                    System.out.print("Insira o ID da apólice: ");
                    int idApolice = Functions.recebeInteiro();
                    System.out.print("Insira a companhia de seguro: ");
                    String companhia = Functions.recebeString();
                    System.out.print("Insira a cobertura: ");
                    String cobertura = Functions.recebeString();
                    System.out.print("Insira o contato do técnico: ");
                    String contato = Functions.recebeString();
                    System.out.print("Insira o email do técnico: ");
                    String email = Functions.recebeString();

                    tickets.add(new Relatorio(ticketParaAlterar.getIdTicket(), ticketParaAlterar.getIdCliente(), ticketParaAlterar.getDataInicio(), ticketParaAlterar.getDataFim(), ticketParaAlterar.getDescHistorico(), ticketParaAlterar.getValorServicos(), ticketParaAlterar.getValorPecas(), ticketParaAlterar.isAberto(), idApolice, companhia, cobertura, contato, email));
                    System.out.println("\n[Sucesso] Ticket transformado em Relatório com sucesso.");
                    break;

                case 3:
                    // Transformar em Reparação -> Orçamento ou Relatório podem dar origem a uma Reparação
                    if (ticketParaAlterar instanceof Orcamento) {
                        Orcamento orcamento = (Orcamento) ticketParaAlterar;

                        if (!orcamento.isAprovado()) {
                            System.out.print("[Aviso] É preciso aprovar o Orçamento antes de dar origem a uma Reparação. \nDeseja aprovar agora? (S/N): ");
                            boolean respostaAprovacao = Functions.validaSeN();

                            if (respostaAprovacao) {
                                orcamento.setAprovado(true);
                                orcamento.setAberto(false);
                            } else {
                                System.out.println("[Aviso] Operação cancelada.");
                                return;
                            }
                        }

                        tickets.add(new Reparacao(orcamento.getIdTicket(), orcamento.getIdCliente(), orcamento.getDataInicio(), orcamento.getDataFim(), orcamento.getDescHistorico(), orcamento.getValorServicos(), orcamento.getValorPecas(), orcamento.isAberto()));
                        System.out.println("\n[Sucesso] Orçamento transformado em Reparação com sucesso.");
                        tickets.remove(ticketParaAlterar);

                    } else if (ticketParaAlterar instanceof Relatorio) {
                        tickets.add(new Reparacao(ticketParaAlterar.getIdTicket(), ticketParaAlterar.getIdCliente(), ticketParaAlterar.getDataInicio(), ticketParaAlterar.getDataFim(), ticketParaAlterar.getDescHistorico(), ticketParaAlterar.getValorServicos(), ticketParaAlterar.getValorPecas(), ticketParaAlterar.isAberto()));
                        System.out.println("\n[Sucesso] Relatório transformado em Reparação com sucesso.");

                    } else
                        System.out.println("[Erro] Apenas Orçamentos e Relatórios podem ser transformados em Reparações.");
                    break;

                default:
                    System.out.println("[Erro] Opção inválida.");
                    break;
            }
        } while (resposta != 1 && resposta != 2 && resposta != 3);
    }


    // 39 - Eliminar ticket por ID
    private static void eliminarTicketPorID() {
        System.out.print("Insira o id do ticket a ser eliminado: ");
        int id = Functions.recebeInteiro();
        Ticket ticketParaEliminar = null;

        if (tickets.isEmpty()) {
            System.out.println("[Aviso] Não há tickets registados.");
            return;
        }

        for (Ticket ticket : tickets) {
            if (ticket.getIdTicket() == id) {
                ticketParaEliminar = ticket;
                break;
            }
        }

        if (ticketParaEliminar == null) {
            System.out.println("[Aviso] Ticket com ID " + id + " não encontrado.");
            return;
        }

        // Só é possível eliminar um registo de reparação se não estiver fechado.
        if (ticketParaEliminar instanceof Reparacao) {
            if (ticketParaEliminar.isAberto()) {
                System.out.println("[Aviso] Impossível excluir Ticket de Reparação enquanto aberto.");
            } else {
                tickets.remove(ticketParaEliminar);
                System.out.println("[Sucesso] Reparação eliminada com sucesso.");
            }
        } else {
            tickets.remove(ticketParaEliminar);
            System.out.println("[Sucesso] Ticket eliminado com sucesso.");
        }


        //Só é possível eliminar um relatório se não tiver dado origem a outro registo.
        // Faltou tempo para implementar



        //Só é possível eliminar um orçamento se não tiver dado origem a uma reparação.
        // Faltou tempo para implementar

    }
}
