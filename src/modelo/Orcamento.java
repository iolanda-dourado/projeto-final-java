package modelo;

import java.io.Serializable;
import java.util.Date;

public class Orcamento extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    public Orcamento(int idReparacao, Date dataInicio, int idCliente, String tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas) {
        super(idReparacao, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas);
    }
}
