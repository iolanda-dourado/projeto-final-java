package modelo;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Ticket implements Serializable {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final long serialVersionUID = 1L; // Indentificador da versão para serialização
    private int idTicket;
    private int idCliente;
    private Date dataInicio;
    private Date dataFim;
    private String descHistorico;
    private double valorServicos;
    private double valorPecas;
    private boolean aberto;


    // Construtor
    public Ticket(int idTicket, int idCliente, Date dataInicio, Date dataFim, String descHistorico, double valorServicos, double valorPecas, boolean aberto) {
        this.idTicket = idTicket;
        this.idCliente = idCliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descHistorico = descHistorico;
        this.valorServicos = valorServicos;
        this.valorPecas = valorPecas;
        this.aberto = aberto;
    }

    // Getters e Setters


    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescHistorico() {
        return descHistorico;
    }

    public void setDescHistorico(String descHistorico) {
        this.descHistorico = descHistorico;
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

    public boolean isAberto() {
        return aberto;
    }

    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-6d | %-11s | %-11s | %-30s | %-11.2f | %-11.2f | %-8s ",
                idTicket, idCliente, dateFormat.format(dataInicio), dateFormat.format(dataFim), descHistorico, valorServicos, valorPecas, aberto ? "Aberto" : "Fechado");
    }
}