package projeto_tickets;

import java.io.Serializable;

public abstract class Cliente implements Serializable {
    private static final long serialVersionUID = 1L; // Indentificador da versão para serialização
    private int id;
    private String nome;
    private String nif;
    private String telefone;
    private String email;

    // Construtor para a classe Cliente
    public Cliente(int id, String nome, String nif, String telefone, String email) {
        super();
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
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

    @Override
    public String toString(){
        return String.format("ID %d | Nome: %s | NIF: %s | Telefone: %s | Email: %s", id, nome, nif, telefone, email);
    }


}
