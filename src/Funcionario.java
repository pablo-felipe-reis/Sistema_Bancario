public class Funcionario extends Pessoa {
    
    private String matricula;
    private String cargo;
    private final String departamento;
    
    public Funcionario(String nome, String cpf, String endereco, 
                       String matricula, String cargo) {
        super(nome, cpf, endereco);
        this.matricula = matricula;
        this.cargo = cargo;
        this.departamento = "Geral";
    }
    
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    
    // Métodos de atendimento
    public void atenderCliente(ContaCliente cliente, String assunto) {
        System.out.println("\n=== ATENDIMENTO ===");
        System.out.println("Funcionário: " + this.getNome() + " (" + this.cargo + ")");
        System.out.println("Atendendo cliente: " + cliente.getNome());
        System.out.println("Assunto: " + assunto);
        System.out.println("Atendimento concluído!");
    }
    
    @Override
    public String obterIdentificacao() {
        // CORRIGIDO: 3 placeholders para 3 argumentos
        return String.format("Funcionário: %s | Matrícula: %s | Cargo: %s",
                           getNome(), matricula, cargo);
    }
    
    @Override
    public String exibirDadosBasicos() {
        return super.exibirDadosBasicos() + String.format("""
            Matrícula: %s
            Cargo: %s
            Departamento: %s
            """, matricula, cargo, departamento);
    }
}