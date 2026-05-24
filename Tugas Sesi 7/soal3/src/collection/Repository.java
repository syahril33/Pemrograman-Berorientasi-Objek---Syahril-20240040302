package collection;

import interfaces.Anggota;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Repository<T extends Anggota> {
    private ArrayList<T> daftarList    = new ArrayList<>();  // ArrayList: akses by index
    private ArrayDeque<T> antriQueue   = new ArrayDeque<>(); // ArrayDeque: antrian FIFO

    // ── ArrayList operations ────────────────────
    public void tambah(T item) {
        daftarList.add(item);
        System.out.println("[LIST] '" + item.getNama() + "' ditambahkan ke daftar.");
    }

    public void hapus(T item) {
        if (daftarList.remove(item)) {
            System.out.println("[LIST] '" + item.getNama() + "' dihapus dari daftar.");
        } else {
            System.out.println("[LIST] Data tidak ditemukan.");
        }
    }

    public T cariById(String id) {
        for (T item : daftarList) {
            if (item.getId().equals(id)) return item;
        }
        return null;
    }

    public void tampilkanSemua() {
        if (daftarList.isEmpty()) {
            System.out.println("Daftar kosong.");
            return;
        }
        for (T item : daftarList) {
            item.tampilkanInfo();
        }
    }

    public int jumlah() { return daftarList.size(); }

    // ── ArrayDeque operations (antrian) ─────────
    public void masukAntrian(T item) {
        antriQueue.offer(item);
        System.out.println("[ANTRIAN] '" + item.getNama() + "' masuk antrian.");
    }

    public T layaniAntrian() {
        T item = antriQueue.poll();
        if (item != null) {
            System.out.println("[ANTRIAN] Melayani: " + item.getNama());
        } else {
            System.out.println("[ANTRIAN] Antrian kosong.");
        }
        return item;
    }

    public void tampilkanAntrian() {
        System.out.println("[ANTRIAN] Isi antrian: " + antriQueue);
    }
}