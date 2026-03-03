public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // Perbaikan: Posisi public void, gunakan 'this' untuk merujuk ke atribut class
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;
        this.tahun_pembuatan = tahun_pembuatan;
    }

    // Perbaikan: Tambahkan body method dan return value
    String getJenisHP() {
        return jenis_hp;
    }

    // Perbaikan: Tambahkan body method dan return value
    int getTahunPembuatan() {
        return tahun_pembuatan;
    }

    // Perbaikan: Urutan 'public static void main'
    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        
        // Mengisi data
        hp.setDataHP("Iphone", 2025);
        
        // Menampilkan data
        System.out.println("Jenis HP: " + hp.getJenisHP());
        System.out.println("Tahun: " + hp.getTahunPembuatan());
    }
}