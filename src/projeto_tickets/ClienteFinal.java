package projeto_tickets;

public class ClienteFinal extends Cliente {
    private boolean temDesc;
    private double percentagemDesconto;


    public ClienteFinal(int id, String nome, String nif, String telefone, String email, boolean temDesc, double percentagemDesconto) {
        super(id, nome, nif, telefone, email);
        this.temDesc = temDesc;
        this.percentagemDesconto = percentagemDesconto;
    }

    public boolean isTemDesc() {
        return temDesc;
    }

    public void setTemDesc(boolean temDesc) {
        this.temDesc = temDesc;
    }

    public double getPercentagemDesconto() {
        return percentagemDesconto;
    }

    public void setPercentagemDesconto(double percentagemDesconto) {
        this.percentagemDesconto = percentagemDesconto;
    }

    @Override
    public String toString() {
        return String.format("%-13s | %-5s | %-25s | %-11s | %-13s | %-30s | %-15s | %-20s | %-20s",
                "Final", getId(), getNome(), getNif(), getTelefone(), getEmail(),
                "0", "0", percentagemDesconto);
    }
}
