class BankBNI extends Bank {
    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Logika Bonus Challenge: Biaya transfer
        int biayaAdmin = bankTujuan.equalsIgnoreCase("BNI") ? 0 : 6500;
        System.out.println("[BNI] Transfer ke " + bankTujuan + " (" + rekeningTujuan + ") senilai Rp" + jumlah + ". Biaya Admin: Rp" + biayaAdmin);
    }
}

class BankBCA extends Bank {
    @Override
    void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        // Logika Bonus Challenge: Biaya transfer
        int biayaAdmin = bankTujuan.equalsIgnoreCase("BCA") ? 0 : 2500;
        System.out.println("[BCA] Transfer ke " + bankTujuan + " (" + rekeningTujuan + ") senilai Rp" + jumlah + ". Biaya Admin: Rp" + biayaAdmin);
    }
}