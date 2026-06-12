import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        try {
            Path sqlPath = Paths.get("dbFinanceiro.SQL");
            String sql = Files.readString(sqlPath);

            try (Connection conn = DBConnection.getConnection();
                 Statement stmt = conn.createStatement()) {
                for (String statement : sql.split(";")) {
                    String trimmed = statement.trim();
                    if (!trimmed.isEmpty()) {
                        stmt.execute(trimmed);
                    }
                }
            }

            System.out.println("Esquema SQL executado com sucesso.");
        } catch (java.io.IOException | java.sql.SQLException e) {
            System.err.println("Falha ao executar o script SQL: " + e.getMessage());
            for (Throwable t = e; t != null; t = t.getCause()) {
                System.err.println(t.getClass().getName() + ": " + t.getMessage());
            }
            System.exit(1);
        }
    }
}
