package modelo;

import java.io.Serializable;

public class ClienteRevendedor extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private double descontoPecas;
    private double descontoMaoObra;

    public ClienteRevendedor(int id, String nome, String nif, String telefone, double descontoMaoObra, double descontoPecas) {
        super(id, nome, nif, telefone);
        this.descontoMaoObra = descontoMaoObra;
        this.descontoPecas = descontoPecas;
    }

    public double getDescontoPecas() {
        return descontoPecas;
    }

    public void setDescontoPecas(double descontoPecas) {
        this.descontoPecas = descontoPecas;
    }

    public double getDescontoMaoObra() {
        return descontoMaoObra;
    }

    public void setDescontoMaoObra(double descontoMaoObra) {
        this.descontoMaoObra = descontoMaoObra;
    }

    @Override
    public String toString() {
        return String.format("%-14s | %-5s | %-25s | %-11s | %-13s | %-10s | %-10s | %-10s",
                "| Revendedor", getId(), getNome(), getNif(), getTelefone(),
                getDescontoPecas() * 100, getDescontoMaoObra() * 100, "0.0");
    }
}
