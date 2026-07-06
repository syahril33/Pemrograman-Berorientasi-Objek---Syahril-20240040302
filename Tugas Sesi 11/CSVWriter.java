import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\ASUS\\Documents\\Semester 4\\Pemrograman Berorientasi Objek\\Tugas Sesi 11\\student.csv";
        Scanner scanner = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            System.out.print("Masukkan jumlah data yang ingin ditambahkan: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            for (int i = 0; i < jumlah; i++) {
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan Umur: ");
                String umur = scanner.nextLine();
                System.out.print("Masukkan Prodi: ");
                String prodi = scanner.nextLine();

                // tulis data ke file
                String line = nim + ", " + nama + ", " + umur + ", " + prodi;
                bw.write(line);
                bw.newLine(); // penting supaya data masuk di baris baru
            }
            System.out.println("Data berhasil ditulis ke file " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}