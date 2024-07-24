package projeto_tickets;

import java.io.Serializable;

public class ClienteRevendedor extends Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    private double descontoPecas;
    private double descontoMaoObra;

    public ClienteRevendedor(int id, String nome, String nif, String telefone, String email, double descontoMaoObra, double descontoPecas) {
        super(id, nome, nif, telefone, email);
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
        return String.format("%-13s | %-5s | %-25s | %-11s | %-13s | %-30s | %-15.2f | %-20s | %-20s",
                "Revendedor", getId(), getNome(), getNif(), getTelefone(), getEmail(),
                getDescontoPecas() * 100, getDescontoMaoObra() * 100, "0");
    }
}
