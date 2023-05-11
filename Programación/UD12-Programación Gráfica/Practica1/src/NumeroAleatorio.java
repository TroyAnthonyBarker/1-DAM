import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumeroAleatorio extends JFrame {
    private JSlider slider0_100;
    private JButton generarButton;
    private JLabel tituloLabel;
    private JLabel resultadoLabel;
    private JPanel panelPrincipal;

    public NumeroAleatorio() {
    super("Generador de números");
    setContentPane(panelPrincipal);
    setVisible(true);
    setSize(400, 400);
    setLocationRelativeTo(null);
    generarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            generateNumber();
        }
    });
}

    public void generateNumber(){
        int max = slider0_100.getValue();
        int min = slider0_100.getMinimum();
        int random = (int)(Math.random()*(max-min+1)+min);
        resultadoLabel.setText(String.valueOf(random));
    }
}
