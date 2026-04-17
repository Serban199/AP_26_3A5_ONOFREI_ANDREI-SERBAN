package hm;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/movies_db");
        config.setUsername("postgres");
        config.setPassword("1234");

        config.setMaximumPoolSize(10);

        dataSource = new HikariDataSource(config);
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("pool-ul de conexiuni a fost inchis.");
        }
    }
}