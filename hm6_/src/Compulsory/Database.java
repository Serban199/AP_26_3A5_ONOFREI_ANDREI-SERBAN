package Compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/movies_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connection = null;


    private Database() {}

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);///ramane deschisa  cat timp realizez actiunea
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Nu s-a putut conecta la baza de date: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Eroare la închiderea conexiunii: " + e.getMessage());
            }
        }
    }
}