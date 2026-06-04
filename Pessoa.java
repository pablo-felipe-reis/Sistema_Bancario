    /*
 * CLASSE BASE - Pessoa
 * 
 * TODOS os atributos comuns a qualquer pessoa ficam AQUI, UMA ÚNICA VEZ!
 * As classes filhas vão HERDAR tudo isso sem precisar repetir
 */

public class Pessoa {
    
    // ===== ATRIBUTOS==== 
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    
    // ===== CONSTRUTOR =====
    public Pessoa(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = "";
        this.email = "";
    }
    
    public Pessoa() {}
    
    // ===== GETTERS E SETTERS (Métodos acessores) =====
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
    
    // ===== MÉTODO QUE SERÁ SOBRESCRITO (Polimorfismo) =====
    public String obterIdentificacao() {
        return "Pessoa: " + nome + " (CPF: " + cpf + ")";
    }
    
    // ===== MÉTODO PARA EXIBIR DADOS BÁSICOS =====
    public String exibirDadosBasicos() {
        return String.format("""
            Nome: %s
            CPF: %s
            Endereço: %s
            Telefone: %s
            Email: %s
            """, nome, cpf, endereco, telefone, email);
    }
}

