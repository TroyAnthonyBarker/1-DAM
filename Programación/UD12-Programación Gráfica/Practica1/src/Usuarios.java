import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Usuarios extends JFrame {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPane1;
    private JPanel panelInicioSesion;
    private JPanel panelCrearUsuario;
    private JTextField txtFldNewUserName;
    private JPasswordField passFldNewUserPass;
    private JPasswordField passFldConfirmNewUserPass;
    private JButton crearButton;
    private JButton cancelarButton;
    private JTextField txtFldUserName;
    private JPasswordField passFldUserPass;
    private JButton iniciarSesionButton;
    private final File usuarios = new File("Usuarios.txt");
    private final List<User> users = new ArrayList<>();

    public Usuarios() {
        super("Inicio Usuarios");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);

        readUsers();


        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (checkUser(new User(txtFldUserName.getText(), passFldUserPass.getText()))) {
                        JOptionPane.showMessageDialog(null, "Sesión iniciado correctamente", getTitle(), JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña o Usuarios incorrecto", getTitle(), JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InvalidInputException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
                }
                clearInputFields();
            }
        });
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validUser()) {
                    createNewUser();
                    writeUsers();
                    JOptionPane.showMessageDialog(null, "Usuario creado correctamente", getTitle(), JOptionPane.INFORMATION_MESSAGE);
                    readUsers();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña invalido", getTitle(), JOptionPane.ERROR_MESSAGE);
                }
                clearInputFields();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputFields();
            }
        });
        txtFldNewUserName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    passFldNewUserPass.requestFocus();
                }
            }
        });
        passFldNewUserPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    passFldConfirmNewUserPass.requestFocus();
                }
            }
        });
        passFldConfirmNewUserPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    crearButton.doClick();
                }
            }
        });
        txtFldUserName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    passFldUserPass.requestFocus();
                }
            }
        });
        passFldUserPass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (e.getKeyChar() == '\n'){
                    iniciarSesionButton.doClick();
                }
            }
        });
    }

    public void readUsers() {
        users.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(usuarios));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] u = line.split(" ");
                users.add(new User(u[0], u[1]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void writeUsers() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(usuarios));
            users.forEach(user -> {
                writeUser(writer, user);
            });
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeUser(BufferedWriter writer, User user) {
        try {
            writer.write(user.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(User u) {
        boolean ok = false;
        for (User user : users) {
            ok = u.equals(user);
            if (ok) break;
        }
        return ok;
    }

    public boolean validUser() {
        return validUserName() && validPass();
    }

    public boolean validPass() {
        if (passFldNewUserPass.getText().contains(" ")) {
            return false;
        }
        return passFldNewUserPass.getText().equals(passFldConfirmNewUserPass.getText());
    }

    public boolean validUserName() {
        boolean ok = true;
        String newUserName = txtFldNewUserName.getText();
        if (newUserName.contains(" ")) {
            return false;
        }
        for (User user : users) {
            if (user.getName().equals(newUserName)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public void createNewUser() {
        try {
            User newUser = new User(txtFldNewUserName.getText(), passFldNewUserPass.getText());
            users.add(newUser);
        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearInputFields(){
        txtFldUserName.setText("");
        txtFldNewUserName.setText("");
        passFldNewUserPass.setText("");
        passFldConfirmNewUserPass.setText("");
        passFldUserPass.setText("");
    }
}
