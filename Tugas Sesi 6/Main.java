
import interfaces.Laptop;
import model.LaptopUser;
import model.Lenovo;
import model.Macbook; 
import model.Toshiba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Laptop Lenovo = new Lenovo();
        Laptop Macbook = new Macbook();
        Laptop Toshiba = new Toshiba();

        //ganti Argument/Parameter sesuai kebutuhan
        LaptopUser syahriLaptopUser = new LaptopUser(Lenovo);

        boolean isRunning = true;

        System.out.println("=== KONTROL LAPTOP ===");
        System.out.println("On: Menyalakan laptop");
        System.out.println("Off: Mematikan laptop");
        System.out.println("Volume Up: Menambah volume");
        System.out.println("Volume Down: Mengurangi volume");
        System.out.println("Exit: Keluar dari program");
        System.out.println("======================");

        while (isRunning) {
            System.out.print("\nMasukkan perintah: ");
            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "ON":
                    syahriLaptopUser.turnOnLaptop();
                    break;
                case "OFF":
                    syahriLaptopUser.turnOffLaptop();
                    break;
                case "VOLUME UP":
                    syahriLaptopUser.makeLaptopLouder();
                    break;
                case "VOLUME DOWN":
                    syahriLaptopUser.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program dihentikan.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
                    break;
            }
        }
        
        scanner.close();
    }
}