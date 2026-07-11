package service;

import database.DatabaseConnection;
import model.LaundryTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TransactionService {


    public void tambahTransaksi(LaundryTransaction transaksi) {


        String sql = "CALL tambah_transaksi_laundry(?,?,?)";


        try (

                Connection conn =
                        DatabaseConnection.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)

        ) {


            ps.setInt(
                    1,
                    transaksi.getCustomer().getIdCustomer()
            );


            ps.setDouble(
                    2,
                    transaksi.getBeratKg()
            );


            ps.setDouble(
                    3,
                    7000
            );


            int hasil = ps.executeUpdate();


            if (hasil > 0) {


                System.out.println();

                System.out.println("==============================");
                System.out.println("TRANSAKSI BERHASIL DISIMPAN");
                System.out.println("==============================");


            }


        } catch (SQLException e) {


            System.out.println();

            System.out.println("Gagal menyimpan transaksi.");

            System.out.println(e.getMessage());


        }


    }



    public void tampilkanRiwayat() {


        String sql =
                "SELECT * FROM view_riwayat_laundry";



        try (

                Connection conn =
                        DatabaseConnection.getConnection();


                PreparedStatement ps =
                        conn.prepareStatement(sql);


                ResultSet rs =
                        ps.executeQuery()


        ) {



            System.out.println();

            System.out.println("==============================================");
            System.out.println("          RIWAYAT TRANSAKSI LAUNDRY");
            System.out.println("==============================================");



            boolean adaData = false;



            while (rs.next()) {


                adaData = true;


                System.out.println("----------------------------------------------");


                System.out.println(
                        "ID Transaksi : "
                        + rs.getInt("id_transaksi")
                );


                System.out.println(
                        "Customer     : "
                        + rs.getString("nama_customer")
                );


                System.out.println(
                        "Berat        : "
                        + rs.getDouble("berat_kg")
                        + " Kg"
                );


                System.out.println(
                        "Harga/Kg     : Rp "
                        + rs.getDouble("harga_per_kg")
                );


                System.out.println(
                        "Total Harga  : Rp "
                        + rs.getDouble("total_harga")
                );


                System.out.println(
                        "Tanggal      : "
                        + rs.getDate("tanggal_masuk")
                );


            }



            if (!adaData) {


                System.out.println();

                System.out.println("Belum ada transaksi.");


            }


            System.out.println("----------------------------------------------");



        } catch (SQLException e) {



            System.out.println();

            System.out.println("Gagal mengambil riwayat transaksi.");

            System.out.println(e.getMessage());


        }


    }



}