package projeto_tickets;

import java.util.Date;

public class Reparacao extends Ticket {
    private int idOrcamento;
    private int idRelatorio;

    public Reparacao(int idReparacao, Date dataInicio, int idCliente, Boolean tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas, int idRelatorio, int idOrcamento) {
        super(idReparacao, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas);
        this.idRelatorio = idRelatorio;
        this.idOrcamento = idOrcamento;
    }

    // Getters e Setters
    public int getIdOrcamento() {
        return idOrcamento;
    }
    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }
    public int getIdRelatorio() {
        return idRelatorio;
    }
    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }
}
