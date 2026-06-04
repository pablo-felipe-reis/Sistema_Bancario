public class ContaCliente extends Pessoa implements IOperacoesBancarias, IValidarDocumentos {
    
    private int agenciaBancaria;
    private int numConta;
    private double saldo;
    private final String tipoConta;  // ← Adicionado final
    private final double limiteCredito;  // ← Adicionado final
    
    // Construtores
     public ContaCliente(String nome, String cpf, String endereco, 
                        int agenciaBancaria, int numConta) {
        super(nome, cpf, endereco);
        this.agenciaBancaria = agenciaBancaria;
        this.numConta = numConta;
        this.saldo = 0.0;
        this.tipoConta = "Corrente";
        this.limiteCredito = 500.0;
    }
    
      public ContaCliente(String nome, String cpf, String endereco, 
                        int agenciaBancaria, int numConta, 
                        String tipoConta, double saldoInicial) {
        super(nome, cpf, endereco);
        this.agenciaBancaria = agenciaBancaria;
        this.numConta = numConta;
        this.tipoConta = tipoConta;
        this.saldo = saldoInicial;
        this.limiteCredito = tipoConta.equals("Especial") ? 2000.0 : 500.0;
    }
    
    // Getters e Setters
    public int getAgenciaBancaria() {
         return agenciaBancaria; 
        }

    public void setAgenciaBancaria(int agenciaBancaria) {
         this.agenciaBancaria = agenciaBancaria;
         }

    public int getNumConta() { 
        return numConta; 
    }

    public void setNumConta(int numConta) { 
        this.numConta = numConta; 
    }

    public double getSaldo() { 
        return saldo; 
    }

@Override

    public String getTipoConta(){
        return tipoConta;
    }
    
    public double getLimiteCredito() { 
        return limiteCredito; 
    }
    
    // ===== IMPLEMENTAÇÃO DA INTERFACE OperacoesBancarias =====
    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado. Saldo: R$ %.2f\n", valor, saldo);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }
    
    @Override
    public boolean sacar(double valor) {
        double disponivel = saldo + limiteCredito;
        if (valor > 0 && valor <= disponivel) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado. Saldo: R$ %.2f\n", valor, saldo);
            return true;
        }
        System.out.printf("Saldo insuficiente! Disponível: R$ %.2f\n", disponivel);
        return false;
    }
    
    @Override
    public double consultarSaldo() {
        System.out.printf("Saldo: R$ %.2f | Limite: R$ %.2f | Total: R$ %.2f\n", 
                         saldo, limiteCredito, saldo + limiteCredito);
        return saldo;
    }
    
    @Override
    public void transferir(ContaCliente destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada para conta %d\n", 
                            valor, destino.getNumConta());
        }
    }
    
    // ===== IMPLEMENTAÇÃO DA INTERFACE ValidarDocumentos =====
    @Override
    public boolean validarDocumento(String documento) {
        String cpfLimpo = getCpf().replaceAll("[^0-9]", "");
        String docLimpo = documento.replaceAll("[^0-9]", "");
        return cpfLimpo.equals(docLimpo) && cpfLimpo.length() == 11;
    }
    
    @Override
    public String getDocumentoFormatado() {
        String cpfLimpo = getCpf().replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11) return getCpf();
        return String.format("%s.%s.%s-%s", 
            cpfLimpo.substring(0, 3),
            cpfLimpo.substring(3, 6),
            cpfLimpo.substring(6, 9),
            cpfLimpo.substring(9, 11));
    }
    
    @Override
    public boolean isDocumentoObrigatorio() {
        return true;
    }
    
    // ===== SOBRESCRITA =====
    @Override
    public String obterIdentificacao() {
        return String.format("Cliente: %s | Conta: %d-%d | Saldo: R$ %.2f",
                           getNome(), agenciaBancaria, numConta, saldo);
    }
    
    @Override
    public String exibirDadosBasicos() {
        return super.exibirDadosBasicos() + String.format("""
            Agência: %d
            Conta: %d
            Tipo: %s
            Saldo: R$ %.2f
            Limite: R$ %.2f
            """, agenciaBancaria, numConta, tipoConta, saldo, limiteCredito);
    }
}