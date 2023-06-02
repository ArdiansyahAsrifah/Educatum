package Educatum.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConfig {
    private static final String DB_URL = "jdbc:sqlite:db/pendidikan.db";
    private static Connection conn;
    public static Connection getConnection() {
    try {
            if (conn == null || conn.isClosed()) {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection(DB_URL);
                System.out.println("Database Connected");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
        }
}

