import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

public class IMCGUI extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelMenu;
    private JButton guardarButton;
    private JButton listarButton;
    private JTextField txtFldPeso;
    private JTextField txtFldAltura;
    private JButton createButton;
    private JTable tableInfoIMC;
    private JTextField txtFldCantidadAMostrar;
    private JButton mostrarButton;
    private JPanel panelGuardar;
    private JPanel panelListar;
    private JLabel infoNewLabel;
    private JButton menuPrincipalButton;
    private JScrollPane panelScrollTable;

    public IMCGUI() {
        super("Índice de Masa Corporal");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 400);
        setLocationRelativeTo(null);
        panelGuardar.setVisible(false);
        panelListar.setVisible(false);

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(false);
                panelGuardar.setVisible(true);
            }
        });
        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(false);
                panelListar.setVisible(true);
                infoNewLabel.setText("");
            }
        });
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    create();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    menuPrincipalButton.doClick();
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showIMC();
                    txtFldCantidadAMostrar.setText("");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(true);
                panelListar.setVisible(false);
                panelGuardar.setVisible(false);
                txtFldAltura.setText("");
                txtFldPeso.setText("");
                txtFldCantidadAMostrar.setText("");
                tableInfoIMC.setVisible(false);
            }
        });
    }

    public void create() throws SQLException {
        ImcDTO imcDTO = new ImcDTO();
        imcDTO.startConnexion();
        float imc = calculateIMC();
        if (imc > 0) {
            imcDTO.insertData(LocalDate.now(), imc);
            infoNewLabel.setText(String.format("IMC: %.2f", imc));
        } else {
            infoNewLabel.setText("");
        }
        imcDTO.stopConnexion();
    }

    public void showIMC() throws SQLException {
        ImcDTO imcDTO = new ImcDTO();
        imcDTO.startConnexion();
        try{
            String[][] data = imcDTO.requestData(Integer.parseInt(txtFldCantidadAMostrar.getText()));
            String[] columnas = {"id", "Fecha medida", "IMC"};
            DefaultTableModel table = new DefaultTableModel(data, columnas);
            tableInfoIMC.setModel(table);
            centerTable(tableInfoIMC);
            tableInfoIMC.setVisible(true);
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Número invalido", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }

        imcDTO.stopConnexion();
    }

    public void centerTable(JTable table){
        DefaultTableCellRenderer centerCell = new DefaultTableCellRenderer();
        centerCell.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerCell);
        }
    }

    public float calculateIMC() {
        try {
            float altura = Float.parseFloat(txtFldAltura.getText());
            float peso = Float.parseFloat(txtFldPeso.getText());
            return (float) (peso / (Math.pow(altura, 2)));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Altura o Peso invalido", this.getTitle(), JOptionPane.ERROR_MESSAGE);
            return -1f;
        }
    }
}
