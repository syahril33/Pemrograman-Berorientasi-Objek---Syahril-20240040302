package model;


import java.time.LocalDate;



public class LaundryTransaction {


    private int idTransaksi;
    private Customer customer;
    private double beratKg;
    private double hargaPerKg;
    private double totalHarga;
    private LocalDate tanggalMasuk;



    public LaundryTransaction(
            int idTransaksi,
            Customer customer,
            double beratKg,
            double hargaPerKg
    ){


        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.beratKg = beratKg;
        this.hargaPerKg = hargaPerKg;

        this.totalHarga = beratKg * hargaPerKg;

        this.tanggalMasuk = LocalDate.now();


    }



    public double getTotalHarga(){

        return totalHarga;

    }



    public Customer getCustomer(){

        return customer;

    }



    public double getBeratKg(){

        return beratKg;

    }



    public LocalDate getTanggalMasuk(){

        return tanggalMasuk;

    }


}