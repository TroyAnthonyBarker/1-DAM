import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MiniCalculadoraI extends JFrame{
    private JButton buttonSuma;
    private JPanel panelPrincipal;
    private JButton buttonResta;
    private JButton buttonMultiplica;
    private JButton buttonDivide;
    private JTextField txtFldNum1;
    private JTextField txtFldNum2;
    private JLabel labelResultado;
    private JLabel labelTitulo;
    private JLabel labelNum1;
    private JLabel labelNum2;

    private int num1;
    private int num2;

    public MiniCalculadoraI() throws HeadlessException {
        super("Mini Calculadora");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(700, 400);
        setLocationRelativeTo(null);
        buttonSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                suma();
            }
        });
        buttonResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resta();
            }
        });
        buttonMultiplica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplicar();
            }
        });
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dividir();
            }
        });
        txtFldNum1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\t' || e.getKeyChar() == '\n'){
                    txtFldNum2.requestFocus();
                }
            }
        });
    }

    public void setNum1AndNum2(){
        try {
            String in = txtFldNum1.getText();
            num1 = Integer.parseInt(in);
            in = txtFldNum2.getText();
            num2 = Integer.parseInt(in);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "No se ha introducido un número válido", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void suma(){
        setNum1AndNum2();
        resultado(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    public void resta(){
        setNum1AndNum2();
        resultado(num1 + " - " + num2 + " = " + (num1 - num2));
    }

    public void multiplicar(){
        setNum1AndNum2();
        resultado(num1 + " x " + num2 + " = " + (num1 * num2));
    }

    public void dividir(){
        setNum1AndNum2();
        if (num2 == 0) {
            txtFldNum1.setText("");
            txtFldNum2.setText("");
            JOptionPane.showMessageDialog(null, "No se pude dividir entre 0", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } else {
            resultado(num1 + " / " + num2 + " = " + (num1 / num2));
        }
    }

    public void resultado(String resultado){
        labelResultado.setText(resultado);
        txtFldNum1.setText("");
        txtFldNum2.setText("");
    }
}
