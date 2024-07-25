package modelo;

import java.io.Serializable;
import java.util.Date;

public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L; // Indentificador da versão para serialização
    private int idTicket;
    private Date dataInicio;
    private int idCliente;
    private String tipoCliente;
    private String descHistorico;
    private Date dataFim;
    private double valorServicos;
    private double valorPecas;


    // Construtor
    public Ticket(int idReparacao, Date dataInicio, int idCliente, String tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas) {
        super();
        this.idTicket = idReparacao;
        this.dataInicio = dataInicio;
        this.idCliente = idCliente;
        this.tipoCliente = tipoCliente;
        this.descHistorico = descHistorico;
        this.dataFim = dataFim;
        this.valorServicos = valorServicos;
        this.valorPecas = valorPecas;
    }


    // Getters e Setters
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
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


    @Override
    public String toString() {
        return String.format("%-5s | %-14s | %-29s | %-29s | %-11s | %-11s | %-10s%n",
                idTicket, tipoCliente, dataInicio, dataFim, descHistorico, valorServicos, valorPecas);
    }
}