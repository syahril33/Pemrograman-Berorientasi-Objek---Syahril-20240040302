package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import database.DatabaseConnection;
import model.Admin;
import model.User;
import model.Staff;
import model.Customer;
import model.LaundryTransaction;
import service.CustomerService;
import service.TransactionService;

public class MainApp {

    public static void main(String[] args) {

        DatabaseConnection.getConnection();

        User user = new Staff(2, "Budi");

        // Contoh polymorphism
        user.showRole();

        System.out.println("Nama User : " + user.getNama());

        Scanner input = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        TransactionService transactionService = new TransactionService();

        boolean jalan = true;

        while (jalan) {

            try {

                System.out.println("\n==============================");
                System.out.println(" APLIKASI MANAJEMEN LAUNDRY ");
                System.out.println("==============================");
                System.out.println("1. Kelola Pelanggan");
                System.out.println("2. Transaksi Laundry");
                System.out.println("3. Keluar");
                System.out.print("Pilih Menu : ");

                int menu = input.nextInt();
                input.nextLine();

                switch (menu) {

                    case 1:

                        boolean menuCustomer = true;

                        while (menuCustomer) {

                            System.out.println("\n===== KELOLA PELANGGAN =====");
                            System.out.println("1. Tambah Pelanggan");
                            System.out.println("2. Lihat Pelanggan");
                            System.out.println("3. Kembali");
                            System.out.print("Pilih : ");

                            int pilih = input.nextInt();
                            input.nextLine();

                            switch (pilih) {

                                case 1:

                                    System.out.print("Nama Customer : ");
                                    String nama = input.nextLine();

                                    System.out.print("No HP : ");
                                    String hp = input.nextLine();

                                    Customer customer = new Customer(0, nama, hp);

                                    customerService.tambahCustomer(customer);

                                    break;

                                case 2:

                                    customerService.tampilkanCustomer();

                                    break;

                                case 3:

                                    menuCustomer = false;

                                    break;

                                default:

                                    System.out.println("Menu tidak tersedia.");

                            }

                        }

                        break;

                    case 2:

                        boolean menuTransaksi = true;

                        while (menuTransaksi) {

                            System.out.println("\n===== TRANSAKSI LAUNDRY =====");
                            System.out.println("1. Tambah Transaksi");
                            System.out.println("2. Lihat Riwayat");
                            System.out.println("3. Kembali");
                            System.out.print("Pilih : ");

                            int pilih = input.nextInt();

                            switch (pilih) {

                                case 1:

                                    customerService.tampilkanCustomer();

                                    System.out.print("\nMasukkan ID Customer : ");
                                    int idCustomer = input.nextInt();

                                    Customer customer =
                                            customerService.cariCustomer(idCustomer);

                                    if (customer == null) {

                                        System.out.println("Customer tidak ditemukan.");
                                        break;

                                    }

                                    System.out.print("Berat Laundry (Kg) : ");
                                    double berat = input.nextDouble();

                                    LaundryTransaction transaksi =
                                            new LaundryTransaction(
                                                    0,
                                                    customer,
                                                    berat,
                                                    7000
                                            );

                                    transactionService.tambahTransaksi(transaksi);

                                    break;

                                case 2:

                                    transactionService.tampilkanRiwayat();

                                    break;

                                case 3:

                                    menuTransaksi = false;

                                    break;

                                default:

                                    System.out.println("Menu tidak tersedia.");

                            }

                        }

                        break;

                    case 3:

                        jalan = false;

                        System.out.println("\nTerima kasih telah menggunakan aplikasi.");

                        break;

                    default:

                        System.out.println("Menu tidak tersedia.");

                }

            } catch (InputMismatchException e) {

                System.out.println("\nInput harus berupa angka.");

                input.nextLine();

            }

        }

        input.close();

    }

}