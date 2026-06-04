public class ContaPoupanca extends Conta {
    
    private String tipo = "Poupança";
    private boolean investimentoCDI = true;

    @Override
    public String getTipoConta() {
        return tipo;
    }
}