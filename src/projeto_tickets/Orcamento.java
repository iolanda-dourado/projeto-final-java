package projeto_tickets;

import java.util.Date;

public class Orcamento extends Ticket {
    public Orcamento(int idReparacao, Date dataInicio, int idCliente, Boolean tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas) {
        super(idReparacao, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas);
    }
}
