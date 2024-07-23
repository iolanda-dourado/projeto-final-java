package projeto_tickets;

public class ClienteRevendedor extends Cliente {
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
        return "ID: " + getId() + " | Nome: '" + getNome() + " | NIF: '" + "Telefone: '" + getTelefone() + " | Email: '" + getEmail() + " | Desconto em Peças: " + descontoPecas * 100 + "%" + " | Desconto em Mão de Obra: " + descontoMaoObra * 100 + "%\n";
    }
}
