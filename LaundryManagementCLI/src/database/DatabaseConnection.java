package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_laundry";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            Connection connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );

            System.out.println("Koneksi database berhasil.");

            return connection;

        } catch (SQLException e) {

            System.out.println("Koneksi gagal.");

            System.out.println(e.getMessage());

            return null;

        }

    }

}