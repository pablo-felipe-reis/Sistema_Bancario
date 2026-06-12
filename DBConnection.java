import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {
    private static final String DEFAULT_URL = "jdbc:postgresql://localhost:5432/sistema_bancario";
    private static final String URL = System.getProperty("db.url", DEFAULT_URL);
    private static final String USER = System.getProperty("db.user", "usuario_teste");
    private static final String PWD = System.getProperty("db.password", "1234");

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(
                    "Driver JDBC do PostgreSQL nao encontrado no classpath. " +
                            "Adicione o arquivo postgresql-*.jar nas dependencias do modulo.",
                    e
            );
        }
    }

    private DBConnection() {
        // utilitário
    }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (SQLException e) {
            throw new SQLException("Falha ao obter conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}