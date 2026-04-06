public class Bank {
    // Overloading 1: Transfer sesama bank
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " (Sesama Bank) berhasil.");
    }

    // Overloading 2: Transfer beda bank
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke " + bankTujuan + " (" + rekeningTujuan + ") berhasil.");
    }

    // Overloading 3: Transfer dengan berita
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke " + bankTujuan + " (" + rekeningTujuan + ") dengan berita: '" + berita + "' berhasil.");
    }

    void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }
}