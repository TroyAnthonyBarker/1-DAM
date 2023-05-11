import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JPanel panelPrincipal;
    private JButton buttonParImpar;
    private JButton miniCalculadoraIButton;
    private JButton miniCalculadoraIIButton;
    private JButton validarNIFButton;
    private JButton generarNumeroAleatorioButton;
    private JButton dadosDeRolButton;
    private JButton informacionDelSistemaButton;
    private JButton tablasDeMultiplicarButton;
    private JButton usuariosButton;
    private JButton editorDeTextoButton;

    public Principal() {
        super("Principal");
        setContentPane(panelPrincipal);
        buttonParImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parImpar();
            }
        });
        miniCalculadoraIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miniCalculadoraI();
            }
        });
        miniCalculadoraIIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miniCalculadoraII();
            }
        });
        validarNIFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validadorNIF();
            }
        });
        generarNumeroAleatorioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new NumeroAleatorio();
                    }
                });
            }
        });
        dadosDeRolButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new Dados();
                    }
                });
            }
        });
        informacionDelSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new InformacionSistema()  ;
                    }
                });
            }
        });
        tablasDeMultiplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new TablasMultiplicar();
                    }
                });
            }
        });
        usuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new Usuarios();
                    }
                });
            }
        });
        editorDeTextoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JFrame frame = new Editor();
                    }
                });
            }
        });
    }

    public void parImpar() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ParImpar();
            }
        });
    }

    public void miniCalculadoraI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MiniCalculadoraI();
            }
        });
    }

    public void miniCalculadoraII() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MiniCalculadoraII();
            }
        });
    }

    public void validadorNIF(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ValidarNif();
            }
        });
    }
}
