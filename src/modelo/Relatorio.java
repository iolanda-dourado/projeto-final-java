package modelo;

import java.io.Serializable;
import java.util.Date;

public class Relatorio extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idApolice;
    private String companhiaSeguro;
    private String cobertura;
    private String contato;
    private String email;


    // Construtor

    public Relatorio(int idTicket, int idCliente, Date dataInicio, Date dataFim, String descHistorico, double valorServicos, double valorPecas, boolean aberto, int idApolice, String companhiaSeguro, String cobertura, String contato, String email) {
        super(idTicket, idCliente, dataInicio, dataFim, descHistorico, valorServicos, valorPecas, aberto);
        this.idApolice = idApolice;
        this.companhiaSeguro = companhiaSeguro;
        this.cobertura = cobertura;
        this.contato = contato;
        this.email = email;
    }


    // Getters e Setters

    public int getIdApolice() {
        return idApolice;
    }

    public void setIdApolice(int idApolice) {
        this.idApolice = idApolice;
    }

    public String getCompanhiaSeguro() {
        return companhiaSeguro;
    }

    public void setCompanhiaSeguro(String companhiaSeguro) {
        this.companhiaSeguro = companhiaSeguro;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String  getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-12s | %-11d | %-20s | %-10s | %-10s | %-20s |",
                "Relatório", idApolice, companhiaSeguro, cobertura, contato, email);
    }
}
