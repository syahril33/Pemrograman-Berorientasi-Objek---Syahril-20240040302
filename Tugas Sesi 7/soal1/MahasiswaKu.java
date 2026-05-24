public class MahasiswaKu {

    public static void main(String[] args) {
        // Tipe generik: NIM=String, Name=String, Kelas=Integer
        Mahasiswa<String, String, Integer> m = new Mahasiswa<>();
        m.setNim("1102020");
        m.setName("Ferdi");
        m.setClas(21);

        System.out.println("=== DATA MAHASISWA ===");
        System.out.println("NIM   : " + m.getNim());
        System.out.println("Nama  : " + m.getName());
        System.out.println("Kelas : " + m.getClas());
    }
}