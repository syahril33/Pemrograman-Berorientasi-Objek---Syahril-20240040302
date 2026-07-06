import java.io.*;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\ASUS\\Documents\\Semester 4\\Pemrograman Berorientasi Objek\\Tugas Sesi 11\\student.csv";
        String destinationFile = "C:\\Users\\ASUS\\Documents\\Semester 4\\Pemrograman Berorientasi Objek\\Tugas Sesi 11\\copy_student.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File berhasil disalin ke " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}