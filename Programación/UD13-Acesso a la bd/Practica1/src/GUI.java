import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class GUI extends JFrame {
    private JPanel panelPrincipal;
    private JTable tablePacientes;
    private JPanel panelPacientes;
    private JPanel panelInfoPaciente;
    private JTextField txtNombrePaciente;
    private JTextField txtDireccionPaciente;
    private JTextField txtTelefonoPaciente;
    private JTextField txtCiudad;
    private JTextField txtGentilicio;
    private JTextField txtFechaNac;
    private JTextField txtTurno;
    private JCheckBox diabetesCheckBox;
    private JTable tableVisitas;
    private JButton volverButton;
    private JButton eliminarButton;
    private JButton modificarButton;
    private JLabel labelIdPaciente;
    private JTextField txtFldBuscar;
    private JButton buscarButton;
    private JButton crearButton;
    private JButton cancelarButton;
    private JButton confirmarButton;
    private JButton eliminarVisitaButton;
    private JButton crearVisitaButton;
    private JPanel panelCrearPaciente;
    private JButton resetearCreacionPaciente;
    private JTextField txtNewNombrePaciente;
    private JTextField txtNewTelefonoPaciente;
    private JTextField txtNewFechaNac;
    private JTextField txtNewTurno;
    private JTextField txtNewDireccionPaciente;
    private JTextField txtNewCiudad;
    private JTextField txtNewGentilicio;
    private JCheckBox newDiabetesCheckBox;
    private JButton confirmaCrearPacienteButton;
    private JButton volver2Button;
    private JPanel panelDefaultInfoPacienteButtons;
    private JPanel panelModifyInfoPacienteButtons;
    private JPanel panelCrearVisita;
    private JTextField txtFldNewFechaVisita;
    private JTextField txtFldNewEnfermedad;
    private JTextField txtFldNewImporte;
    private JTextField txtFldNewPorcentajePago;
    private JTextField txtFldNewProximaVisita;
    private JButton confirmCrearVisitaButton;
    private JButton cancelarCrearVisitaButton;
    private static final int ROW_INTERVALS = 16;
    private static final Dimension PANEL_PACIENTES_SIZE = new Dimension(400, 500);
    private static final Dimension PANEL_PACIENTES_INFO_SIZE = new Dimension(1000, 500);
    private static final Dimension PANEL_CREAR_PACIENTE_SIZE = new Dimension(700, 250);

    private static final Dimension PANEL_CREAR_VISITA_SIZE = new Dimension(1000, 150);

    public GUI() {
        super("CLINICA");
        setLocationRelativeTo(null);
        setSize(PANEL_PACIENTES_SIZE);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);
        panelInfoPaciente.setVisible(false);
        panelCrearPaciente.setVisible(false);
        panelModifyInfoPacienteButtons.setVisible(false);
        panelCrearVisita.setVisible(false);

        DBManager.connect();

        cargarPacientes();
        tablePacientes.addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                super.componentAdded(e);
                panelPacientes.setVisible(false);
                panelInfoPaciente.setVisible(true);
                configPanelInfoPaciente(e.getChild().getY());
                setSize(PANEL_PACIENTES_INFO_SIZE);
            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInfoPaciente.setVisible(false);
                panelCrearPaciente.setVisible(false);
                panelPacientes.setVisible(true);
                cargarPacientes();
                setSize(PANEL_PACIENTES_SIZE);
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPacientes.setVisible(false);
                panelCrearPaciente.setVisible(true);
                setSize(PANEL_CREAR_PACIENTE_SIZE);
            }
        });
        resetearCreacionPaciente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearPanelCrearPaciente();
            }
        });
        volver2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverButton.doClick();
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activateEditInfoPaciente();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateEditInfoPaciente();
            }
        });
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres confirmar?", getTitle(), JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {
                    updatePaciente();
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres Eliminar el paciente?", getTitle(), JOptionPane.YES_NO_OPTION);
                if (confirm == 0) {
                    deletePaciente();
                }
            }
        });
        eliminarVisitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input = JOptionPane.showInputDialog(null, "¿Que visita?\nIntroduce el id", "");
                if (input != null) {
                    try {
                        int codigoVisita = Integer.parseInt(input);
                        DBManager.deleteVisita(codigoVisita);
                        cargarVisitasPaciente(getIdPacienteFromlabeLIdPaciente());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El id introducido no es valido", getTitle(), JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        crearVisitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelInfoPaciente.setVisible(false);
                panelCrearVisita.setVisible(true);
                setSize(PANEL_CREAR_VISITA_SIZE);
            }
        });
        cancelarCrearVisitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCrearVisita.setVisible(false);
                panelInfoPaciente.setVisible(true);
                clearCreateVisitas();
                setSize(PANEL_PACIENTES_INFO_SIZE);
            }
        });
        confirmCrearVisitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearVisitaDePaciente(getIdPacienteFromlabeLIdPaciente());
            }
        });
        confirmaCrearPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPacienteNuevo();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        txtFldBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n') {
                    buscarButton.doClick();
                }
            }
        });
    }

    private void buscar() {
        String paciente = txtFldBuscar.getText();
        if (isNumbers(paciente)) {
            buscarPorCodigo(Integer.parseInt(paciente));
        } else if (paciente.equals("")) {
            cargarPacientes();
        } else {
            buscarPorNombre(paciente);
        }
        txtFldBuscar.setText("");
    }

    private void buscarPorNombre(String nombrePaciente) {
        String where = " WHERE LOWER(NOMBRE) LIKE '%" + nombrePaciente.toLowerCase() + "%'";
        String[] columnas = {"CODIGO", "NOMBRE"};
        String[][] datos = getDataResultSetPaciente(Objects.requireNonNull(DBManager.selectPacientesWhere(where)));
        fillTablePacientes(datos, columnas);
    }

    private void buscarPorCodigo(int idPaciente) {
        String[] columnas = {"CODIGO", "NOMBRE"};
        String[][] datos = getDataResultSetPaciente(Objects.requireNonNull(DBManager.selectPacientesWhere(" WHERE CODIGO = " + idPaciente)));
        fillTablePacientes(datos, columnas);
    }

    private boolean isNumbers(String stg) {
        return stg.matches("[0-9]+");
    }

    private void crearPacienteNuevo() {
        String mensajeErrorNumeros = "El telefono introducino no es valido";
        try {
            String nombre = txtNewNombrePaciente.getText();
            String direccion = txtNewDireccionPaciente.getText();
            String ciudad = txtNewCiudad.getText();
            int telefono = Integer.parseInt(txtNewTelefonoPaciente.getText());
            boolean diabetico = newDiabetesCheckBox.isSelected();
            Date fechaNac = Date.valueOf(txtNewFechaNac.getText());
            mensajeErrorNumeros = "El turno introducino no es valido";
            int turno = Integer.parseInt(txtNewTurno.getText());
            String gentilicio = txtNewGentilicio.getText();
            if (gentilicio.length() > 3) {
                throw new Exception("Gentilicio no valido");
            }
            DBManager.insertPaciente(nombre, direccion, ciudad, telefono, diabetico, fechaNac, turno, gentilicio);
            clearCreateVisitas();
            volverButton.doClick();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mensajeErrorNumeros, this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento introducido no es valido.\nFormato (YYYY-MM-dd)", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nMáximo 3 caracteres", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearCreateVisitas() {
        txtFldNewFechaVisita.setText("");
        txtFldNewEnfermedad.setText("");
        txtFldNewImporte.setText("");
        txtFldNewPorcentajePago.setText("");
        txtFldNewProximaVisita.setText("");
    }

    private void crearVisitaDePaciente(int idPaciente) {
        String fechaErrorTextMessage = "La fecha de visita introducido no es valido.";
        String mensajeErrorNumeros = "El importe introducido no es valido";
        try {
            Date fechaVisita = Date.valueOf(txtFldNewFechaVisita.getText());
            String enfermedad = txtFldNewEnfermedad.getText();
            fechaErrorTextMessage = "La fecha de la próxima visita introducido no es valido.";
            Date fechaProximaVisita = Date.valueOf(txtFldNewProximaVisita.getText());
            int importe = Integer.parseInt(txtFldNewImporte.getText());
            mensajeErrorNumeros = "El porcentaje introducido no es valido";
            int porcentajePago = Integer.parseInt(txtFldNewPorcentajePago.getText());

            DBManager.insertVisita(idPaciente, fechaVisita, enfermedad, importe, porcentajePago, fechaProximaVisita);
            cargarVisitasPaciente(idPaciente);
            cancelarCrearVisitaButton.doClick();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mensajeErrorNumeros, this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, fechaErrorTextMessage + "\nFormato (YYYY-MM-dd)", this.getTitle(), JOptionPane.ERROR_MESSAGE);

        }
    }

    private void deletePaciente() {
        int codigo = getIdPacienteFromlabeLIdPaciente();
        DBManager.deletePaciente(codigo);
        volverButton.doClick();
    }

    private int getIdPacienteFromlabeLIdPaciente() {
        return Integer.parseInt(labelIdPaciente.getText().split(" ")[3]);
    }

    private void updatePaciente() {
        int codigo = getIdPacienteFromlabeLIdPaciente();
        String mensajeErrorNumeros = "El telefono introducino no es valido";
        try {
            String nombre = txtNombrePaciente.getText();
            String direccion = txtDireccionPaciente.getText();
            String ciudad = txtCiudad.getText();
            int telefono = Integer.parseInt(txtTelefonoPaciente.getText());
            boolean diabetico = diabetesCheckBox.isSelected();
            Date fechaNac = Date.valueOf(txtFechaNac.getText());
            mensajeErrorNumeros = "El turno introducino no es valido";
            int turno = Integer.parseInt(txtTurno.getText());
            String gentilicio = txtGentilicio.getText();
            if (gentilicio.length() > 3) {
                throw new Exception("Gentilicio no valido");
            }
            DBManager.editPaciente(codigo, nombre, direccion, ciudad, telefono, diabetico, fechaNac, turno, gentilicio);
            deactivateEditInfoPaciente();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mensajeErrorNumeros, this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento introducino no es valido.\nFormato (YYYY-MM-dd)", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nMáximo 3 caracteres", this.getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deactivateEditInfoPaciente() {
        panelDefaultInfoPacienteButtons.setVisible(true);
        panelModifyInfoPacienteButtons.setVisible(false);
        txtNombrePaciente.setEditable(false);
        txtDireccionPaciente.setEditable(false);
        txtCiudad.setEditable(false);
        txtTelefonoPaciente.setEditable(false);
        txtFechaNac.setEditable(false);
        txtTurno.setEditable(false);
        txtGentilicio.setEditable(false);
        diabetesCheckBox.setEnabled(false);

        fillDatosPaciente(getIdPacienteFromlabeLIdPaciente());
    }

    private void activateEditInfoPaciente() {
        panelDefaultInfoPacienteButtons.setVisible(false);
        panelModifyInfoPacienteButtons.setVisible(true);
        txtNombrePaciente.setEditable(true);
        txtDireccionPaciente.setEditable(true);
        txtCiudad.setEditable(true);
        txtTelefonoPaciente.setEditable(true);
        txtFechaNac.setEditable(true);
        txtTurno.setEditable(true);
        txtGentilicio.setEditable(true);
        diabetesCheckBox.setEnabled(true);
    }

    private void clearPanelCrearPaciente() {
        txtNewNombrePaciente.setText("");
        txtNewDireccionPaciente.setText("");
        txtNewCiudad.setText("");
        txtNewTelefonoPaciente.setText("");
        txtNewFechaNac.setText("");
        txtNewTurno.setText("");
        txtNewGentilicio.setText("");
        newDiabetesCheckBox.setSelected(false);
    }

    private void cargarPacientes() {
        String[] columnas = {"CODIGO", "NOMBRE"};
        String[][] datos = getDataResultSetPaciente(Objects.requireNonNull(DBManager.selectAllPacientes()));
        fillTablePacientes(datos, columnas);
    }

    private void configPanelInfoPaciente(int y) {
        int rowLine = y / ROW_INTERVALS;
        int idPaciente = Integer.parseInt((String) tablePacientes.getValueAt(rowLine, 0));
        labelIdPaciente.setText("Datos del paciente " + idPaciente);
        fillDatosPaciente(idPaciente);
    }

    private void fillDatosPaciente(int idPaciente) {
        String[][] datosPaciente = getDataResultSetPaciente(Objects.requireNonNull(DBManager.selectPacientesWhere(" WHERE CODIGO = " + idPaciente)));

        txtNombrePaciente.setText(datosPaciente[0][1]);
        txtDireccionPaciente.setText(datosPaciente[0][2]);
        txtCiudad.setText(datosPaciente[0][3]);
        txtTelefonoPaciente.setText(datosPaciente[0][4]);
        txtFechaNac.setText(datosPaciente[0][6]);
        txtTurno.setText(datosPaciente[0][7]);
        txtGentilicio.setText(datosPaciente[0][8]);
        diabetesCheckBox.setSelected(Boolean.parseBoolean(datosPaciente[0][5]));

        cargarVisitasPaciente(idPaciente);
    }

    private void cargarVisitasPaciente(int idPaciente) {
        String[][] visitasPaciente = getDataResultSetVisitas(Objects.requireNonNull(DBManager.selectVisitas(idPaciente)));
        String[] columnasVisitas = {"codigo", "fechaVisita", "enfermedad", "importe", "porcentajePago", "proximaVisita"};
        fillTableVisitas(visitasPaciente, columnasVisitas);
    }

    public String[][] getDataResultSetPaciente(ResultSet rs) {
        try {
            String[][] result = new String[rs.getFetchSize()][9];
            int count = 0;
            while (rs.next()) {
                result[count][0] = String.valueOf(rs.getInt("CODIGO"));
                result[count][1] = rs.getString("NOMBRE");
                result[count][2] = rs.getString("DIRECCION");
                result[count][3] = rs.getString("CIUDAD");
                result[count][4] = String.valueOf(rs.getInt("TELEFONO"));
                result[count][5] = String.valueOf(rs.getBoolean("DIABETICO"));
                result[count][6] = String.valueOf(rs.getDate("FECHANAC"));
                result[count][7] = String.valueOf(rs.getInt("TURNO"));
                result[count][8] = rs.getString("GENTILICIO");
                count++;
            }
            return deleteNulls(result);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String[][] getDataResultSetVisitas(ResultSet rs) {
        try {
            String[][] result = new String[rs.getFetchSize()][7];
            int count = 0;
            while (rs.next()) {
                if (result[count] != null) {
                    result[count][0] = String.valueOf(rs.getInt("codigo"));
                    result[count][1] = rs.getDate("fechaVisita").toString();
                    result[count][2] = rs.getString("enfermedad");
                    result[count][3] = rs.getInt("importe") + " €";
                    result[count][4] = rs.getInt("porcentajePago") + " %";
                    result[count][5] = rs.getDate("proximaVisita").toString();
                }
                count++;
            }
            return deleteNulls(result);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void fillTablePacientes(String[][] data, String[] columnas) {
        DefaultTableModel table = new DefaultTableModel(data, columnas);
        tablePacientes.setModel(table);
        centerTable(tablePacientes);
        tablePacientes.setVisible(true);
    }

    private String[][] deleteNulls(String[][] data) {
        int count = 0;
        for (String[] strings : data) {
            if (strings[0] != null) {
                count++;
            }
        }
        String[][] result = new String[count][data[0].length];
        count = 0;
        for (String[] datum : data) {
            if (datum[0] != null) {
                System.arraycopy(datum, 0, result[count], 0, datum.length);
                count++;
            }
        }
        return result;
    }

    public void fillTableVisitas(String[][] data, String[] columnas) {
        DefaultTableModel table = new DefaultTableModel(data, columnas);
        tableVisitas.setModel(table);
        centerTable(tableVisitas);
        tableVisitas.setVisible(true);
    }

    public void centerTable(JTable table) {
        DefaultTableCellRenderer centerCell = new DefaultTableCellRenderer();
        centerCell.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerCell);
        }
    }
}
