import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TablasMultiplicar extends JFrame{
    private JPanel panelPrincipal;
    private JTable tablaMultiplicar;
    private JTextField txtFldMax;
    private JButton generateTables;
    private JTextField txtFldMin;

    public TablasMultiplicar(){
        super("Tablas de multiplicar");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(842, 400);
        setLocationRelativeTo(null);
        fillTable(1, 10);
        generateTables.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int min = Integer.parseInt(txtFldMin.getText());
                    int max = Integer.parseInt(txtFldMax.getText());
                    if (min > max){
                        throw new InvalidInputException("Parámetros inválidos.\nEjemplo: De: 1 Hasta: 10");
                    }
                    fillTable(
                            min,
                            max
                    );
                    txtFldMin.setText("");
                    txtFldMax.setText("");
                    txtFldMin.requestFocus();
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "No se ha introducido un número válido", getTitle(), JOptionPane.ERROR_MESSAGE);
                    txtFldMin.setText("");
                    txtFldMax.setText("");
                    txtFldMin.requestFocus();
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
                    txtFldMin.setText("");
                    txtFldMax.setText("");
                    txtFldMin.requestFocus();
                }

            }
        });
        txtFldMin.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\t' || e.getKeyChar() == '\n'){
                    txtFldMax.requestFocus();
                }
            }
        });
        txtFldMax.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    generateTables.doClick();
                }

            }
        });
    }

    public void fillTable(int min, int max){
        String[] columnas = {
                "Tabla",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10"
        };

        int cantidad = max - min + 1;
        int count = min;

        String[][] datos = new String[cantidad][11];

        for (int i = 0; i < datos.length; i++) {
            datos[i][0] = "Tabla del " + (count) + ":";
            for (int j = 1; j < datos[i].length; j++) {
                datos[i][j] = String.valueOf((count)*(j));
            }
            count++;
        }

        DefaultTableModel table = new DefaultTableModel(datos, columnas);
        tablaMultiplicar.setModel(table);
    }
}
