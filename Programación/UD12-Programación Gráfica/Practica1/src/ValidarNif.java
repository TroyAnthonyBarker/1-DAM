import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValidarNif extends JFrame{
    private JFormattedTextField fTxtFldNif;
    private JPanel panel1;
    private JButton testButton;
    private JLabel titleLabel;
    private JTextField txtFldNif;

    private MaskFormatter NIF_FORMAT;

    public ValidarNif() {
        super("Validador NIF");
        setContentPane(panel1);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);

        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (checkNIF(txtFldNif.getText())){
                        JOptionPane.showMessageDialog(null, "NIF correcto", getTitle(), JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "NIF incorrecto", getTitle(), JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InvalidInputException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public boolean checkNIF(String nif) throws InvalidInputException {
        boolean ok = false;
        if(nif.matches("\\d{8}[A-Z a-z]") || nif.matches("[A-Z a-z]\\d{7}[A-Z a-z]")){
            char digitoEsperado = nif.toUpperCase().charAt(nif.length()-1);
            if (nif.matches("\\d{8}[A-Z a-z]")){
                int numNif = Integer.parseInt(nif.substring(0, 8));
                ok = digitoEsperado == digitoControlReal(numNif);
            } else {
                char digitoExtranjero = nif.charAt(0);
                String numNifString = nif.substring(1, 8);
                switch (digitoExtranjero){
                    case 'X' ->{
                        numNifString = "0" + numNifString;
                    }
                    case 'Y' -> {
                        numNifString = "1" + numNifString;
                    }
                    case 'Z' -> {
                        numNifString = "2" + numNifString;
                    }
                }
                int numNif = Integer.parseInt(numNifString);
                ok = digitoEsperado == digitoControlReal(numNif);
            }
        }
        return ok;
    }

    public char digitoControlReal(int num) throws InvalidInputException {
        int res = num % 23;
        char digito;
        switch (res){
            case 0 -> {
                digito = 'T';
            }
            case 1 -> {
                digito = 'R';
            }
            case 2 -> {
                digito = 'W';
            }
            case 3 -> {
                digito = 'A';
            }
            case 4 ->{
                digito = 'G';
            }
            case 5 ->{
                digito = 'M';
            }
            case 6 ->{
                digito = 'Y';
            }
            case 7 ->{
                digito = 'F';
            }
            case 8 ->{
                digito = 'P';
            }
            case 9 ->{
                digito = 'D';
            }
            case 10 ->{
                digito = 'X';
            }
            case 11 ->{
                digito = 'B';
            }
            case 12 ->{
                digito = 'N';
            }
            case 13 ->{
                digito = 'J';
            }
            case 14 ->{
                digito = 'Z';
            }
            case 15 ->{
                digito = 'S';
            }
            case 16 ->{
                digito = 'Q';
            }
            case 17 ->{
                digito = 'V';
            }
            case 18 ->{
                digito = 'H';
            }
            case 19 ->{
                digito = 'L';
            }
            case 20 ->{
                digito = 'C';
            }
            case 21 ->{
                digito = 'K';
            }
            case 22 ->{
                digito = 'E';
            }
            default -> {
                throw new InvalidInputException("NIF erróneo");
            }
        }
        return digito;
    }
}
