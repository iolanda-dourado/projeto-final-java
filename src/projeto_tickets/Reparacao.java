package projeto_tickets;

public class Reparacao {
    private int idOrcamento;
    private int idRelatorio;


    public Reparacao(int idOrcamento, int idRelatorio) {
        super();
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
