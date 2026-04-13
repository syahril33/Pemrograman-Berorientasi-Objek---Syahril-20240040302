import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("============================================");
        System.out.println("   SISTEM INFORMASI AKADEMIK - SIMULASI    ");
        System.out.println("============================================");

        // ── Input data Mahasiswa ──────────────────────
        System.out.println("\n--- Input Data Mahasiswa ---");
        System.out.print("Masukkan nama mahasiswa  : ");
        String studentName = scanner.nextLine();

        System.out.print("Masukkan alamat mahasiswa: ");
        String studentAddress = scanner.nextLine();

        Student student = new Student(studentName, studentAddress);
        System.out.println("Mahasiswa berhasil dibuat: " + student);

        // ── Input mata kuliah & nilai mahasiswa ───────
        System.out.println("\n--- Input Mata Kuliah dan Nilai Mahasiswa ---");
        System.out.print("Berapa mata kuliah yang ingin ditambahkan? ");
        int numStudentCourses = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numStudentCourses; i++) {
            System.out.print("  Nama mata kuliah ke-" + (i + 1) + ": ");
            String course = scanner.nextLine();
            System.out.print("  Nilai untuk " + course + "        : ");
            int grade = Integer.parseInt(scanner.nextLine().trim());
            student.addCourseGrade(course, grade);
        }

        // ── Tampilkan nilai mahasiswa ─────────────────
        System.out.println("\n--- Rekap Nilai Mahasiswa ---");
        student.printGrades();

        // ── Input data Dosen ──────────────────────────
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Masukkan nama dosen  : ");
        String teacherName = scanner.nextLine();

        System.out.print("Masukkan alamat dosen: ");
        String teacherAddress = scanner.nextLine();

        Teacher teacher = new Teacher(teacherName, teacherAddress);
        System.out.println("Dosen berhasil dibuat: " + teacher);

        // ── Input mata kuliah dosen ───────────────────
        System.out.println("\n--- Input Mata Kuliah yang Diampu Dosen ---");
        System.out.print("Berapa mata kuliah yang ingin ditambahkan? ");
        int numTeacherCourses = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numTeacherCourses; i++) {
            System.out.print("  Nama mata kuliah ke-" + (i + 1) + ": ");
            String course = scanner.nextLine();
            boolean added = teacher.addCourse(course);
            if (added) {
                System.out.println("  -> \"" + course + "\" berhasil ditambahkan.");
            } else {
                System.out.println("  -> \"" + course + "\" GAGAL ditambahkan (sudah ada).");
            }
        }

        // ── Coba tambah duplikat ──────────────────────
        System.out.println("\n--- Uji Coba: Menambah Mata Kuliah Duplikat ---");
        System.out.print("Masukkan nama mata kuliah yang ingin dicoba ditambah lagi: ");
        String dupCourse = scanner.nextLine();
        boolean dupResult = teacher.addCourse(dupCourse);
        System.out.println("Hasil addCourse(\"" + dupCourse + "\"): "
                + (dupResult ? "true (berhasil)" : "false (sudah ada, gagal ditambahkan)"));

        // ── Tampilkan mata kuliah dosen ───────────────
        System.out.println("\n--- Daftar Mata Kuliah Dosen ---");
        teacher.printCourses();

        // ── Hapus mata kuliah dosen ───────────────────
        System.out.println("\n--- Hapus Mata Kuliah Dosen ---");
        System.out.print("Masukkan nama mata kuliah yang ingin dihapus: ");
        String removeCourse = scanner.nextLine();
        boolean removed = teacher.removeCourse(removeCourse);
        System.out.println("Hasil removeCourse(\"" + removeCourse + "\"): "
                + (removed ? "true (berhasil dihapus)" : "false (mata kuliah tidak ada)"));

        // ── Daftar setelah penghapusan ────────────────
        System.out.println("\n--- Daftar Mata Kuliah Dosen (setelah penghapusan) ---");
        teacher.printCourses();

        // ── Ubah alamat via setAddress ────────────────
        System.out.println("\n--- Update Alamat ---");
        System.out.print("Masukkan alamat baru untuk mahasiswa " + student.getName() + ": ");
        String newAddress = scanner.nextLine();
        student.setAddress(newAddress);
        System.out.println("Alamat berhasil diubah. toString() sekarang: " + student);

        // ── Ringkasan akhir ───────────────────────────
        System.out.println("\n============================================");
        System.out.println("               RINGKASAN AKHIR             ");
        System.out.println("============================================");
        System.out.println("Mahasiswa : " + student);
        System.out.printf("Rata-rata : %.2f%n", student.getAverageGrade());
        System.out.println("Dosen     : " + teacher);
        teacher.printCourses();
        System.out.println("============================================");

        scanner.close();
    }
}