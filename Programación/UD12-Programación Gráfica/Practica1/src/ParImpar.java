import javax.swing.*;
import java.awt.event.*;

public class ParImpar extends JFrame {
    private JTextField txtFdlNumero;
    private JPanel panelPrincipal;
    private JButton bComprobar;
    private JLabel LabelParImpar;

    public ParImpar() {
        super("¿Par o Impar?");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        bComprobar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result();
                txtFdlNumero.setText("");
            }
        });
        txtFdlNumero.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    result();
                    txtFdlNumero.setText("");
                }
            }
        });
    }
    public boolean isPar (int num){
        return (num % 2) == 0;
    }


    public void result () {
        String resultado = "El número introducido es par";
        String in = txtFdlNumero.getText();
        try {
            int num = Integer.parseInt(in);
            if (!isPar(num)) {
                resultado = "El número introducido es impar";
            }
            JOptionPane.showMessageDialog(null, resultado, this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No se ha introducido un número válido", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
}
