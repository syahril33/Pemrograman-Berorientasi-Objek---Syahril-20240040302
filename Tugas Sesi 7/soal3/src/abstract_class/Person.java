package abstract_class;

import interfaces.Anggota;

// ABSTRACT CLASS
// Implements interface Anggota
public abstract class Person implements Anggota {
    // ENCAPSULATION — field private, akses via getter/setter
    private String id;
    private String nama;
    private String alamat;

    public Person(String id, String nama, String alamat) {
        this.id    = id;
        this.nama  = nama;
        this.alamat = alamat;
    }

    // Getter
    @Override
    public String getId()   { return id; }
    @Override
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }

    // Setter
    public void setAlamat(String alamat) { this.alamat = alamat; }

    // Method abstract
    public abstract String getPeran();

    // Method konkret
    @Override
    public void tampilkanInfo() {
        System.out.println("---------------------------");
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Alamat : " + alamat);
        System.out.println("Peran  : " + getPeran());
    }
}