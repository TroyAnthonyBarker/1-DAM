import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MiniCalculadoraII extends JFrame{
    private JTextField txtFldNum1;
    private JTextField txtFldNum2;
    private JRadioButton sumatorioRadioButton;
    private JRadioButton productorioRadioButton;
    private JRadioButton elevacionRadioButton;
    private JButton buttonCalcular;
    private JLabel labelTitulo;
    private JLabel labelNum1;
    private JLabel labelNum2;
    private JLabel labelResultado;
    private JPanel panelPrincipal;
    private JPanel panelInput;

    private int num1;
    private int num2;

    public MiniCalculadoraII() throws HeadlessException {
        super("Mini Calculadora");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);

        txtFldNum1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\t' || e.getKeyChar() == '\n'){
                    txtFldNum2.requestFocus();
                }
            }
        });
        buttonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacion();
            }
        });
        txtFldNum2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    operacion();
                }
            }
        });
    }

    private void operacion(){
        try {
            if (sumatorioRadioButton.isSelected()) {
                sumatorio();
            } else if (productorioRadioButton.isSelected()) {
                productorio();
            } else if (elevacionRadioButton.isSelected()) {
                elevacion();
            }
        } catch (InvalidInputException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "INVALID INPUT", JOptionPane.ERROR_MESSAGE);
        } finally {
            txtFldNum1.setText("");
            txtFldNum2.setText("");
            txtFldNum1.requestFocus();
        }
    }

    private void sumatorio() throws InvalidInputException {
        setNum1AndNum2();

        if (num1 > num2){
            throw new InvalidInputException("El numero 1 tiene que ser menor que el numero 2");
        }

        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += i;
        }
        resultado("El sumatorio de " + num1 + " a " + num2 + " es: " + sum);
    }

    private void productorio() throws InvalidInputException {
        setNum1AndNum2();

        if (num1 > num2){
            throw new InvalidInputException("El numero 1 tiene que ser menor que el numero 2");
        }

        int produc = 1;
        for (int i = num1; i <= num2; i++) {
            produc *= i;
        }
        resultado("El productorio de " + num1 + " a " + num2 + " es: " + produc);
    }

    private void elevacion() {
        setNum1AndNum2();
        int elev = 1;
        for (int i = 0; i < num2; i++) {
            elev *= num1;
        }
        resultado(num1 + "^" + num2 + " = " + elev);
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

    public void resultado(String resultado){
        labelResultado.setText(resultado);
    }

}
