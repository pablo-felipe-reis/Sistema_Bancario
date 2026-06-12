import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContaClienteDAO {

    public ContaClienteDAO() {
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement()) {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS conta_cliente (" +
                    "agencia INTEGER, " +
                    "num_conta INTEGER PRIMARY KEY, " +
                    "tipo_conta TEXT, " +
                    "saldo REAL, " +
                    "limite_credito REAL, " +
                    "nome TEXT, " +
                    "cpf TEXT, " +
                    "endereco TEXT, " +
                    "telefone TEXT, " +
                    "email TEXT");
        } catch (SQLException e) {
            throw new IllegalStateException("Erro ao inicializar tabela conta_cliente: " + e.getMessage(), e);
        }
    }

    public void salvar(ContaCliente c) throws SQLException {
        String sql = "INSERT OR REPLACE INTO conta_cliente (agencia, num_conta, tipo_conta, saldo, limite_credito, nome, cpf, endereco, telefone, email) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getAgenciaBancaria());
            ps.setInt(2, c.getNumConta());
            ps.setString(3, c.getTipoConta());
            ps.setDouble(4, c.getSaldo());
            ps.setDouble(5, c.getLimiteCredito());
            ps.setString(6, c.getNome());
            ps.setString(7, c.getCpf());
            ps.setString(8, c.getEndereco());
            ps.setString(9, c.getTelefone());
            ps.setString(10, c.getEmail());
            ps.executeUpdate();
        }
    }

    public void atualizar(ContaCliente c) throws SQLException {
        String sql = "UPDATE conta_cliente SET agencia=?, tipo_conta=?, saldo=?, limite_credito=?, nome=?, cpf=?, endereco=?, telefone=?, email=? WHERE num_conta=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getAgenciaBancaria());
            ps.setString(2, c.getTipoConta());
            ps.setDouble(3, c.getSaldo());
            ps.setDouble(4, c.getLimiteCredito());
            ps.setString(5, c.getNome());
            ps.setString(6, c.getCpf());
            ps.setString(7, c.getEndereco());
            ps.setString(8, c.getTelefone());
            ps.setString(9, c.getEmail());
            ps.setInt(10, c.getNumConta());
            ps.executeUpdate();
        }
    }

    public ContaCliente buscarPorNumero(int numConta) throws SQLException {
        String sql = "SELECT * FROM conta_cliente WHERE num_conta = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numConta);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ContaCliente c = mapResultSet(rs);
                    return c;
                }
            }
        }
        return null;
    }

    public List<ContaCliente> listarTodos() throws SQLException {
        String sql = "SELECT * FROM conta_cliente";
        List<ContaCliente> lista = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapResultSet(rs));
            }
        }
        return lista;
    }

    public void deletar(int numConta) throws SQLException {
        String sql = "DELETE FROM conta_cliente WHERE num_conta = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numConta);
            ps.executeUpdate();
        }
    }

    private ContaCliente mapResultSet(ResultSet rs) throws SQLException {
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        String endereco = rs.getString("endereco");
        int agencia = rs.getInt("agencia");
        int numConta = rs.getInt("num_conta");
        String tipo = rs.getString("tipo_conta");
        double saldo = rs.getDouble("saldo");
        ContaCliente c = new ContaCliente(nome, cpf, endereco, agencia, numConta, tipo, saldo);
        return c;
    }
}
