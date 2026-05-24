package model;

import abstract_class.Person;

// INHERITANCE 
public class Dosen extends Person {
    private String mataKuliah;
    private String gelar;

    public Dosen(String id, String nama, String alamat,
                 String mataKuliah, String gelar) {
        super(id, nama, alamat);
        this.mataKuliah = mataKuliah;
        this.gelar      = gelar;
    }

    // POLYMORPHISM
    @Override
    public String getPeran() {
        return "Dosen";
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Gelar  : " + gelar);
        System.out.println("MK     : " + mataKuliah);
        System.out.println("---------------------------");
    }

    public String getMataKuliah() { return mataKuliah; }
    public String getGelar()      { return gelar; }
}