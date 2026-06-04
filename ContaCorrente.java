public class ContaCorrente extends Conta {
    
    private String tipo = "Corrente";
    private boolean investimentoCDI = false;
    private boolean pgtoDebitoAutomatico = true;
    private double limiteChequeEspecial = 3000.0;

    @Override
    public String getTipoConta() {
        return tipo;
    }
}