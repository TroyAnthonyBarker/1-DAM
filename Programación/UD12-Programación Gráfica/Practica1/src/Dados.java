import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dados extends JFrame{
    private JPanel panelPrincipal;
    private JPanel dadoSeisCaras;
    private JPanel dadoOchoCaras;
    private JPanel dadoDiezCaras;
    private JPanel dadoDoceCaras;
    private JPanel dadoVeinteCaras;
    private JTabbedPane tabbedPane1;

    private final ImageIcon dadoSeisImg = new ImageIcon("Dados/dado6caras.png");
    private final ImageIcon dadoOchoImg = new ImageIcon("Dados/dado8caras.png");
    private final ImageIcon dadoDiezImg = new ImageIcon("Dados/dado10caras.png");
    private final  ImageIcon dadoDoceImg = new ImageIcon("Dados/dado12caras.png");
    private final  ImageIcon dadoVeinteImg = new ImageIcon("Dados/dado20caras.png");

    private JLabel dadoSeis;
    private JLabel dadoOcho;
    private JLabel dadoDiez;
    private JLabel dadoDoce;
    private JLabel dadoVeinte;
    private JButton generate1to8Button;
    private JButton generate1to6Button;
    private JButton generate1to10Button;
    private JButton generate1to12Button;
    private JButton generate1to20Button;

    public Dados(){
        super("Dados de rol");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);

        dadoOcho.setFont(dadoSeis.getFont());
        dadoDiez.setFont(dadoSeis.getFont());
        dadoDoce.setFont(dadoSeis.getFont());
        dadoVeinte.setFont(dadoSeis.getFont());


        dadoSeis.setIcon(rescale(dadoSeisImg, 200, 200));
        dadoOcho.setIcon(rescale(dadoOchoImg, 200, 200));
        dadoDiez.setIcon(rescale(dadoDiezImg, 200, 200));
        dadoDoce.setIcon(rescale(dadoDoceImg, 200, 200));
        dadoVeinte.setIcon(rescale(dadoVeinteImg, 200, 200));
        generate1to6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadoSeis.setText(String.valueOf(randomNumber(1, 6)));
            }
        });
        generate1to8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadoOcho.setText(String.valueOf(randomNumber(1, 8)));
            }
        });
        generate1to10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadoDiez.setText(String.valueOf(randomNumber(1, 10)));
            }
        });
        generate1to12Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadoDoce.setText(String.valueOf(randomNumber(1, 12)));
            }
        });
        generate1to20Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dadoVeinte.setText(String.valueOf(randomNumber(1, 20)));
            }
        });
    }

    public ImageIcon rescale(ImageIcon imagen, int width, int height){
        Image imagenOriginal = imagen.getImage();
        Image imagenEscalada = imagenOriginal.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }

    public int randomNumber(int min, int max){
        return (int)(Math.random()*(max-min+1)+min);
    }

}
