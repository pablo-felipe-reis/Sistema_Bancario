/*
 * INTERFACE - OperacoesBancarias
 * 
 * Interface é um "contrato" que define O QUE a classe deve fazer
 * mas não COMO fazer (quem implementa decide como)
 * 
 * Conceitos:
 * - Todos os métodos são automaticamente public e abstract
 * - Uma classe pode implementar várias interfaces
 */

public interface IOperacoesBancarias {
      
    // Métodos que TODA conta bancária deve ter
    // Não têm corpo (implementação), apenas a assinatura
    
    void depositar(double valor);
    
    boolean sacar(double valor);
    
    double consultarSaldo();
    
    void transferir(ContaCliente destino, double valor);
    
    String getTipoConta();
}
    

