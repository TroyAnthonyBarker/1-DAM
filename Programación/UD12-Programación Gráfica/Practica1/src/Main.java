import javax.swing.*;
import java.awt.image.ImageObserver;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Principal();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(400, 400);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });
    }
}
