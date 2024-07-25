package modelo;

import java.io.Serializable;

public class ClienteFinal extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private double percentagemDesconto;


    public ClienteFinal(int id, String nome, String nif, String telefone, double percentagemDesconto) {
        super(id, nome, nif, telefone);
        this.percentagemDesconto = percentagemDesconto;
    }

    public double getPercentagemDesconto() {
        return percentagemDesconto;
    }

    public void setPercentagemDesconto(double percentagemDesconto) {
        this.percentagemDesconto = percentagemDesconto;
    }

    @Override
    public String toString() {
        return String.format("%-14s | %-5s | %-25s | %-11s | %-13s | %-10s | %-10s | %-10s |",
                "| Final", getId(), getNome(), getNif(), getTelefone(),
                "0.0", "0.0", percentagemDesconto);
    }
}
