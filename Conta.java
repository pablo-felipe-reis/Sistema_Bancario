public class Conta implements IOperacoesBancarias {
    
    private int agencia;
    private int numero;
    private int digito;
    private double saldo;

    public void imprimirSaudacao() {
        System.out.println("Seja Bem Vindo");
    }

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
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado. Saldo: R$ %.2f\n", valor, saldo);
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }

    @Override
    public double consultarSaldo() {
        System.out.printf("Saldo: R$ %.2f\n", saldo);
        return saldo;
    }

    @Override
    public void transferir(ContaCliente destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada para conta %d\n", valor, destino.getNumConta());
        }
    }

    @Override
    public String getTipoConta() {
        return "Conta";
    }
}