public class ContaCorrente extends Conta {
    
    private final String tipo = "Corrente";
    private final boolean investimentoCDI = false;
    private final boolean pgtoDebitoAutomatico = true;
    private final double limiteChequeEspecial = 3000.0;

    @Override
    public String getTipoConta() {
        return tipo;
    }

    public boolean isInvestimentoCDI() {
        return investimentoCDI;
    }

    public boolean isPgtoDebitoAutomatico() {
        return pgtoDebitoAutomatico;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}