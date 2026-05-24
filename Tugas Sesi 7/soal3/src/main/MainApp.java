package main;

import model.Mahasiswa;
import model.Dosen;
import collection.Repository;
import abstract_class.Person;

public class MainApp {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     SISTEM INFORMASI AKADEMIK        ║");
        System.out.println("║  Generic, Collection & OOP Concepts  ║");
        System.out.println("╚══════════════════════════════════════╝");

        // CLASS & OBJECT 
        System.out.println("\n>>> [CLASS & OBJECT] Membuat objek Mahasiswa dan Dosen");
        Mahasiswa m1 = new Mahasiswa("M001", "Ferdi",  "Jl. Merdeka 1", "Informatika", 3.85);
        Mahasiswa m2 = new Mahasiswa("M002", "Andi",   "Jl. Sudirman 2", "Sistem Informasi", 3.50);
        Mahasiswa m3 = new Mahasiswa("M003", "Citra",  "Jl. Gatot 3",   "Informatika", 3.90);
        Dosen     d1 = new Dosen("D001", "Dr. Siti",  "Jl. Ahmad 5",   "Algoritma",  "Dr.");
        Dosen     d2 = new Dosen("D002", "Prof. Budi", "Jl. Diponegoro 7", "Basis Data", "Prof.");

        // INHERITANCE & POLYMORPHISM 
        System.out.println("\n>>> [INHERITANCE & POLYMORPHISM] tampilkanInfo() berbeda tiap class:");
        Person[] semuaOrang = {m1, d1}; 
        for (Person p : semuaOrang) {
            p.tampilkanInfo(); //
        }

        // ENCAPSULATION 
        System.out.println(">>> [ENCAPSULATION] Update IPK via setter:");
        System.out.println("IPK lama " + m1.getNama() + " : " + m1.getIpk());
        m1.setIpk(3.95);
        System.out.println("IPK baru " + m1.getNama() + " : " + m1.getIpk());

        // GENERIC & COLLECTION (ArrayList)
        System.out.println("\n>>> [GENERIC + ARRAYLIST] Repository Mahasiswa:");
        Repository<Mahasiswa> repoMahasiswa = new Repository<>();
        repoMahasiswa.tambah(m1);
        repoMahasiswa.tambah(m2);
        repoMahasiswa.tambah(m3);

        System.out.println("Total mahasiswa : " + repoMahasiswa.jumlah());

        System.out.println("\nCari mahasiswa ID 'M002':");
        Mahasiswa hasil = repoMahasiswa.cariById("M002");
        if (hasil != null) hasil.tampilkanInfo();

        System.out.println("Hapus Andi dari daftar:");
        repoMahasiswa.hapus(m2);
        System.out.println("Total setelah hapus: " + repoMahasiswa.jumlah());

        System.out.println("\nSemua mahasiswa tersisa:");
        repoMahasiswa.tampilkanSemua();

        // GENERIC & COLLECTION (ArrayDeque)
        System.out.println(">>> [GENERIC + ARRAYDEQUE] Antrian Konsultasi Dosen:");
        Repository<Dosen> repoDosen = new Repository<>();
        repoDosen.tambah(d1);
        repoDosen.tambah(d2);

        System.out.println("\nMahasiswa masuk antrian konsultasi:");
        repoMahasiswa.masukAntrian(m1);
        repoMahasiswa.masukAntrian(m3);
        repoMahasiswa.tampilkanAntrian();

        System.out.println("\nProses layani antrian:");
        repoMahasiswa.layaniAntrian();
        repoMahasiswa.layaniAntrian();
        repoMahasiswa.layaniAntrian(); // antrian kosong

        // INTERFACE
        System.out.println("\n>>> [INTERFACE] Semua class implements Anggota:");
        interfaces.Anggota[] anggota = {m1, m3, d1, d2};
        for (interfaces.Anggota a : anggota) {
            System.out.println("ID: " + a.getId() + " | Nama: " + a.getNama());
        }

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║         Program Selesai              ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}