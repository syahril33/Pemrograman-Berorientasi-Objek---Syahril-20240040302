package model;

import abstract_class.Person;

// INHERITANCE
public class Mahasiswa extends Person {
    private String jurusan;
    private double ipk;

    public Mahasiswa(String id, String nama, String alamat,
                     String jurusan, double ipk) {
        super(id, nama, alamat);
        this.jurusan = jurusan;
        this.ipk     = ipk;
    }

    // POLYMORPHISM 
    @Override
    public String getPeran() {
        return "Mahasiswa";
    }

   
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // panggil milik Person
        System.out.println("Jurusan: " + jurusan);
        System.out.printf("IPK    : %.2f%n", ipk);
        System.out.println("---------------------------");
    }

    public String getJurusan() { return jurusan; }
    public double getIpk()     { return ipk; }
    public void setIpk(double ipk) { this.ipk = ipk; }
}