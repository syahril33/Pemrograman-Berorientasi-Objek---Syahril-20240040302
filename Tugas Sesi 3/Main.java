import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int jumlah;

        System.out.print("Jumlah Mahasiswa : ");
        jumlah = input.nextInt();
        input.nextLine();

        Mahasiswa[] mhs = new Mahasiswa[jumlah];

        int lulus = 0;
        int tidakLulus = 0;

        int A = 0, B = 0, C = 0, D = 0, E = 0;

        String namaLulus = "";
        String namaTidakLulus = "";

        String namaA = "";
        String namaB = "";
        String namaC = "";
        String namaD = "";
        String namaE = "";

        double totalNilai = 0;
        String rumusNilai = "";

        for(int i = 0; i < jumlah; i++){

            mhs[i] = new Mahasiswa();

            System.out.println("\nData Mahasiswa ke-" + (i+1));

            System.out.print("NIM : ");
            mhs[i].nim = input.nextLine();

            System.out.print("Nama : ");
            mhs[i].nama = input.nextLine();

            System.out.print("Nilai : ");
            mhs[i].nilai = input.nextInt();
            input.nextLine();

            if(mhs[i].nilai < 0 || mhs[i].nilai > 100){
                System.out.println("Input nilai anda salah");
                i--;
                continue;
            }

            mhs[i].hitungGrade();

            totalNilai += mhs[i].nilai;

            if(i == 0){
                rumusNilai += mhs[i].nilai;
            }else{
                rumusNilai += "+" + mhs[i].nilai;
            }

            if(mhs[i].lulus()){
                lulus++;
                namaLulus += mhs[i].nama + ", ";
            }else{
                tidakLulus++;
                namaTidakLulus += mhs[i].nama + ", ";
            }

            switch(mhs[i].grade){

                case 'A':
                    A++;
                    namaA += mhs[i].nama + ", ";
                    break;

                case 'B':
                    B++;
                    namaB += mhs[i].nama + ", ";
                    break;

                case 'C':
                    C++;
                    namaC += mhs[i].nama + ", ";
                    break;

                case 'D':
                    D++;
                    namaD += mhs[i].nama + ", ";
                    break;

                case 'E':
                    E++;
                    namaE += mhs[i].nama + ", ";
                    break;
            }
        }

        System.out.println("\n===== DATA MAHASISWA =====");

        for(int i=0;i<jumlah;i++){
            mhs[i].tampilData();
        }

        double rata = totalNilai / jumlah;

        System.out.println("Jumlah Mahasiswa : " + jumlah);

        System.out.println("Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + namaLulus);
        System.out.println("Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + namaTidakLulus);

        System.out.println("Jumlah Mahasiswa dengan Nilai A = " + A + " yaitu " + namaA);
        System.out.println("Jumlah Mahasiswa dengan Nilai B = " + B + " yaitu " + namaB);
        System.out.println("Jumlah Mahasiswa dengan Nilai C = " + C + " yaitu " + namaC);
        System.out.println("Jumlah Mahasiswa dengan Nilai D = " + D + " yaitu " + namaD);
        System.out.println("Jumlah Mahasiswa dengan Nilai E = " + E + " yaitu " + namaE);

        System.out.println("Rata-rata nilai mahasiswa adalah : " + rumusNilai + " / " + jumlah + " = " + rata);

        input.close();
    }
}