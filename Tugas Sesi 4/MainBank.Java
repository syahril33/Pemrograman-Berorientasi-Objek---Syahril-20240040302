public class MainBank {
    public static void main(String[] args) {
        Bank bankUmum = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("--- Demo Method Overloading ---");
        bankUmum.transferUang(500000, "12345678");
        bankUmum.transferUang(1000000, "888999", "Mandiri");
        bankUmum.transferUang(250000, "777666", "BRI", "Bayar Kost");
        bankUmum.sukuBunga();

        System.out.println("\n--- Demo Method Overriding ---");
        bni.sukuBunga();
        bca.sukuBunga();

        System.out.println("\n--- Demo Bonus Challenge (Biaya Transfer) ---");
        // Transfer dari BNI ke BCA (Beda bank, kena admin)
        bni.transferUang(2000000, "999111", "BCA");
        
        // Transfer dari BCA ke BCA (Sesama bank, admin 0)
        bca.transferUang(500000, "222333", "BCA");
    }
}
