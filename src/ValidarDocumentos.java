/*
 * INTERFACE - ValidacaoDocumentos
 * 
 * Interface para validação de documentos do cliente
 * Demonstra que uma classe pode implementar múltiplas interfaces
 */
public interface ValidarDocumentos {
    boolean validarDocumento(String documento);
    
    String getDocumentoFormatado();
    
    boolean isDocumentoObrigatorio();
}
