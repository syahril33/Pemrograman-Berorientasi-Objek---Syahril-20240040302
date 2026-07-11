package service;

import database.DatabaseConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService {

    public void tambahCustomer(Customer customer) {

        String sql =
                "INSERT INTO customer(nama_customer,no_hp) VALUES (?,?)";

        try (

                Connection conn =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setString(1, customer.getNamaCustomer());
            ps.setString(2, customer.getNoHp());

            int hasil = ps.executeUpdate();

            if (hasil > 0) {

                System.out.println("\nCustomer berhasil ditambahkan.");

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public void tampilkanCustomer() {

        String sql =
                "SELECT * FROM customer";

        try (

                Connection conn =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql);

                ResultSet rs =
                        ps.executeQuery()

        ) {

            System.out.println("\n===== DATA CUSTOMER =====");

            while (rs.next()) {

                System.out.println("--------------------------");

                System.out.println(
                        "ID      : "
                                + rs.getInt("id_customer"));

                System.out.println(
                        "Nama    : "
                                + rs.getString("nama_customer"));

                System.out.println(
                        "No HP   : "
                                + rs.getString("no_hp"));

            }

            System.out.println("--------------------------");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public Customer cariCustomer(int idCustomer) {

        String sql =
                "SELECT * FROM customer WHERE id_customer=?";

        try (

                Connection conn =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {

            ps.setInt(1, idCustomer);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Customer(

                        rs.getInt("id_customer"),

                        rs.getString("nama_customer"),

                        rs.getString("no_hp")

                );

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return null;

    }

}