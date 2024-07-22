package projeto_tickets;

public abstract class Cliente {
    private int id;
    private String nome;
    private String nif;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String nif, String telefone, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
