package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/seubanco";
    private static final String USER = "seuusuario";
    private static final String PASSWORD = "suasenha";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Erro ao carregar o driver JDBC", e);
        }
    }
}

