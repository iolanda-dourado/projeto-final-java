package projeto_tickets;

import java.io.Serializable;

public class Relatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idApolice;
    private String companhiaSeguro;
    private String cobertura;
    private double contato;
    private String email;


    // Construtor
    public Relatorio(int idApolice, String companhiaSeguro, String cobertura, double contato, String email) {
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
