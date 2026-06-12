public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA BANCÁRIO =====\n");

        // variáveis de exemplo removidas (não usadas diretamente neste fluxo)

        // Criação de contas (clientes)
        ContaCliente conta1 = new ContaCliente(
            "Maria Silva", "123.456.789-09", "Rua A, 100", 1, 1001);
        ContaCliente conta2 = new ContaCliente(
            "João Souza", "987.654.321-00", "Rua B, 200",
            1, 1002, "Especial", 1000.0);

        // Funcionário
        Funcionario func = new Funcionario(
            "Ana Costa", "111.222.333-44", "Av. Central, 50", "F-001", "Gerente");

        // Exibindo dados básicos (polimorfismo via Pessoa)
        Pessoa[] pessoas = { conta1, conta2, func };
        for (Pessoa p : pessoas) {
            System.out.println(p.obterIdentificacao());
        }
        System.out.println();

        // Operações bancárias
        conta1.depositar(500.0);
        conta1.sacar(200.0);
        conta1.consultarSaldo();

        System.out.println("\n--- Transferência ---");
        conta1.transferir(conta2, 100.0);
        conta2.consultarSaldo();

        // Validação de documentos
        System.out.println("\n--- Validação de Documentos ---");
        System.out.println("CPF formatado de Maria: " + conta1.getDocumentoFormatado());
        System.out.println("Documento válido? " + conta1.validarDocumento("12345678909"));

        // Atendimento
        func.atenderCliente(conta1, "Atualização cadastral");

        // Dados completos
        System.out.println("\n--- Dados Completos ---");
        System.out.println(conta2.exibirDadosBasicos());
    }
}
