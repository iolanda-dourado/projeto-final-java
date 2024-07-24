package modelo;

import java.io.Serializable;
import java.util.Date;

public class Reparacao extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idOrcamento;
    private int idRelatorio;

    public Reparacao(int idReparacao, Date dataInicio, int idCliente, String tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas, int idOrcamento, int idRelatorio) {
        super(idReparacao, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas);
        this.idOrcamento = idOrcamento;
        this.idRelatorio = idRelatorio;
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
