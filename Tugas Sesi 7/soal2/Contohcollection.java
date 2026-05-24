import java.util.ArrayList;
import java.util.ArrayDeque;

public class Contohcollection {

    public static void main(String[] args) {

        // ══════════════════════════════════════
        //  BAGIAN 1 - ArrayList
        // ══════════════════════════════════════
        System.out.println("======= ARRAYLIST =======");
        ArrayList<String> daftarMahasiswa = new ArrayList<>();

        // Tambah data
        daftarMahasiswa.add("Ferdi");
        daftarMahasiswa.add("Andi");
        daftarMahasiswa.add("Budi");
        daftarMahasiswa.add("Citra");

        System.out.println("Daftar awal     : " + daftarMahasiswa);
        System.out.println("Mahasiswa ke-2  : " + daftarMahasiswa.get(1));
        System.out.println("Jumlah          : " + daftarMahasiswa.size());

        // Hapus berdasarkan nama
        daftarMahasiswa.remove("Andi");
        System.out.println("Setelah hapus   : " + daftarMahasiswa);

        // Cek keberadaan
        System.out.println("Ada 'Ferdi'?    : " + daftarMahasiswa.contains("Ferdi"));

        // Iterasi
        System.out.println("Iterasi list:");
        for (String nama : daftarMahasiswa) {
            System.out.println("  -> " + nama);
        }

        // ══════════════════════════════════════
        //  BAGIAN 2 - ArrayDeque
        // ══════════════════════════════════════
        System.out.println("\n======= ARRAYDEQUE (sebagai Queue / Antrian) =======");
        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Masuk antrian (dari belakang)
        antrian.offer("Mahasiswa A");
        antrian.offer("Mahasiswa B");
        antrian.offer("Mahasiswa C");

        System.out.println("Antrian         : " + antrian);
        System.out.println("Yang paling depan : " + antrian.peek());

        // Keluar antrian (dari depan - FIFO)
        System.out.println("Dilayani        : " + antrian.poll());
        System.out.println("Antrian sekarang: " + antrian);

        System.out.println("\n======= ARRAYDEQUE (sebagai Stack / Tumpukan) =======");
        ArrayDeque<String> tumpukan = new ArrayDeque<>();

        // Masuk tumpukan (dari atas)
        tumpukan.push("Buku 1");
        tumpukan.push("Buku 2");
        tumpukan.push("Buku 3");

        System.out.println("Tumpukan        : " + tumpukan);
        System.out.println("Paling atas     : " + tumpukan.peek());

        // Ambil dari atas (LIFO)
        System.out.println("Diambil         : " + tumpukan.pop());
        System.out.println("Tumpukan sekarang: " + tumpukan);
    }
}