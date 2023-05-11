import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Editor extends JFrame{
    private JPanel panelPrincipal;
    private JTextArea textArea1;
    private JButton abrirButton;
    private JButton guardarButton;

    private File ficheroEditar;

    public Editor(){
        super("Editor de Texto");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        abrirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elegirFichero()){
                    showFichero();
                }
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
    }

    public boolean elegirFichero() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            ficheroEditar = fileChooser.getSelectedFile();
            return true;
        }
        return false;
    }
    public void showFichero(){
        try {
            BufferedReader rd = new BufferedReader(new FileReader(ficheroEditar));
            String line;
            while ((line = rd.readLine()) != null){
                textArea1.append(line + "\n");
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(){
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(ficheroEditar));
            wr.write(textArea1.getText());
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
