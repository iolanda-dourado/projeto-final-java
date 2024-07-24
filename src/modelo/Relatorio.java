package modelo;

import java.io.Serializable;
import java.util.Date;

public class Relatorio extends Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idApolice;
    private String companhiaSeguro;
    private String cobertura;
    private double contato;
    private String email;


    // Construtor


    public Relatorio(int idReparacao, Date dataInicio, int idCliente, String tipoCliente, String descHistorico, Date dataFim, double valorServicos, double valorPecas, String email, double contato, String cobertura, String companhiaSeguro, int idApolice) {
        super(idReparacao, dataInicio, idCliente, tipoCliente, descHistorico, dataFim, valorServicos, valorPecas);
        this.email = email;
        this.contato = contato;
        this.cobertura = cobertura;
        this.companhiaSeguro = companhiaSeguro;
        this.idApolice = idApolice;
    }

    // Getters e Setters
    public int getIdApolice() {
        return idApolice;
    }
    public void setIdApolice(int idApolice) {
        this.idApolice = idApolice;
    }
    public String getCobertura() {
        return cobertura;
    }
    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }
    public double getContato() {
        return contato;
    }
    public void setContato(double contato) {
        this.contato = contato;
    }
    public String getCompanhiaSeguro() {
        return companhiaSeguro;
    }
    public void setCompanhiaSeguro(String companhiaSeguro) {
        this.companhiaSeguro = companhiaSeguro;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
