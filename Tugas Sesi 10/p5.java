public class p5 {
    public static void main(String[] args) {

        int bil = 10;

        try {

            System.out.println(bil / 0);

        } catch (ArithmeticException e) {

            System.out.println("Pesan Error:");
            System.out.println(e.getMessage());

            System.out.println("Info Stack Trace");

            e.printStackTrace();

            e.printStackTrace(System.out);

        } catch (Exception e) {

            System.out.println("Ini menghandle error yang terjadi");

        }

    }

}
