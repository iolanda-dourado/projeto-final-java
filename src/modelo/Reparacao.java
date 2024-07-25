package modelo;

import java.io.Serializable;
import java.util.Date;

public class Reparacao extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean finalizada;

    // Construtor

    public Reparacao(int idTicket, int idCliente, Date dataInicio, Date dataFim, String descHistorico, double valorServicos, double valorPecas, boolean aberto) {
        super(idTicket, idCliente, dataInicio, dataFim, descHistorico, valorServicos, valorPecas, aberto);
    }

    // Getters e Setters
    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public String toString() {
        return super.toString() + String.format("| %-12s | %-9s |", "Reparação", finalizada ? "Sim" : "Não");
    }
}
