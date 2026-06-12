public class ContaPoupanca extends Conta {
    
    private final String tipo = "Poupança";
    private final boolean investimentoCDI = true;

    @Override
    public String getTipoConta() {
        return tipo;
    }

    public boolean isInvestimentoCDI() {
        return investimentoCDI;
    }
}