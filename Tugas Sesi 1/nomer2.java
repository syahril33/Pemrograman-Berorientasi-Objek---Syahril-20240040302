import javax.swing.JOptionPane;

public class nomer2 {
    public static void main(String[] args) {
        // Memunculkan kotak input
        String pelajaran = JOptionPane.showInputDialog(null, "Anda sedang belajar apa?");

        // Memunculkan kotak pesan dengan hasil input tadi
        if (pelajaran != null) {
            JOptionPane.showMessageDialog(null, "Belajar " + pelajaran + " sangat mudah");
        }
    }
}