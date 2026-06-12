import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = System.getProperty("db.url", "jdbc:postgresql://localhost:5433/postgres");
        String user = System.getProperty("db.user", "usuario_teste");
        String pwd = System.getProperty("db.password", "1234");
        String name = System.getProperty("db.name", "sistema_bancario");

        String sql = "CREATE DATABASE " + name;
        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Banco criado: " + name);
        } catch (SQLException e) {
            if ("42P04".equals(e.getSQLState())) {
                System.out.println("Banco já existe: " + name);
            } else {
                System.err.println("Falha ao criar banco: " + e.getMessage());
                for (Throwable t = e; t != null; t = t.getCause()) {
                    System.err.println(t.getClass().getName() + ": " + t.getMessage());
                }
                System.exit(1);
            }
        }
    }
}
