public class Cliente {
    
    private Pessoa dadosPessoais;
    private Conta conta;

    public Cliente(Pessoa dadosPessoais, Conta conta) {
        this.dadosPessoais = dadosPessoais;
        this.conta = conta;
    }

    public Pessoa getDadosPessoais() {
        return dadosPessoais;
    }

    public Conta getConta() {
        return conta;
    }
}