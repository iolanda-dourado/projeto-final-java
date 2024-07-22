package projeto_tickets;

public class Orcamento {
    private double desconto;
    private double valorServico;
    private double valorPecas;


    public Orcamento(double desconto, double valorServico, double valorPecas) {
        super();
        this.desconto = desconto;
        this.valorServico = valorServico;
        this.valorPecas = valorPecas;
    }
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
    public double getValorServico() {
        return valorServico;
    }
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }
    public double getValorPecas() {
        return valorPecas;
    }
    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }
}
