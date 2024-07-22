package projeto_tickets;

import java.util.Date;

public abstract class Ticket {
    private int idReparacao;
    private Date dataInicio;
    private int idCliente;
    private Boolean tipoCliente;
    private String descHistorico;
    private Date dataFim;
    private double valorServicos;
    private double valorPecas;


    // Construtor
    public Ticket(int idReparacao, Date dataInicio, int idCliente, Boolean tipoCliente, String descHistorico,
                  Date dataFim, double valorServicos, double valorPecas) {
        super();
        this.idReparacao = idReparacao;
        this.dataInicio = dataInicio;
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.descHistorico = descHistorico;
        this.dataFim = dataFim;
        this.valorServicos = valorServicos;
        this.valorPecas = valorPecas;
    }


    // Getters e Setters
    public int getIdReparacao() {
        return idReparacao;
    }

    public void setIdReparacao(int idReparacao) {
        this.idReparacao = idReparacao;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public Boolean getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(Boolean tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getDescHistorico() {
        return descHistorico;
    }
    public void setDescHistorico(String descHistorico) {
        this.descHistorico = descHistorico;
    }
    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public double getValorServicos() {
        return valorServicos;
    }
    public void setValorServicos(double valorServicos) {
        this.valorServicos = valorServicos;
    }
    public double getValorPecas() {
        return valorPecas;
    }
    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }

    // toString
    @Override
    public String toString() {
        return "projeto5413.Ticket [idReparacao=" + idReparacao + ", dataInicio=" + dataInicio + ", idCliente=" + idCliente
                + ", tipoCliente=" + tipoCliente + ", descHistorico=" + descHistorico + ", dataFim=" + dataFim
                + ", valorServicos=" + valorServicos + ", valorPecas=" + valorPecas + "]";
    }
}