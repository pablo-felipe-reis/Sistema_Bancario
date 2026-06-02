/*
 * INTERFACE - ValidacaoDocumentos
 * 
 * Interface para validação de documentos do cliente
 * Demonstra que uma classe pode implementar múltiplas interfaces
 */
public interface IValidarDocumentos {
    boolean validarDocumento(String documento);
    
    String getDocumentoFormatado();
    
    boolean isDocumentoObrigatorio();
}
