package modelo;

import java.io.Serializable;
import java.util.Date;

public class Orcamento extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean aprovado;

    public Orcamento(int idTicket, int idCliente, Date dataInicio, Date dataFim, String descHistorico, double valorServicos, double valorPecas, boolean aberto, boolean aprovado) {
        super(idTicket, idCliente, dataInicio, dataFim, descHistorico, valorServicos, valorPecas, aberto);
        this.aprovado = aprovado;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-12s | %-10s |", "Orçamento", aprovado ? "Sim" : "Não");
    }
}