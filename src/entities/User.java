package entities;

public class User {
    private int id;
    private int idade;
    private String nome;
    private String email;

    public User() {}

    public User(int id, int idade, String nome, String email) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", idade=" + idade + ", nome=" + nome + ", email=" + email + "]";
    }

    
}
