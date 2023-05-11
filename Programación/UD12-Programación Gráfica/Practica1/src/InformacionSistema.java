import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class InformacionSistema extends JFrame{
    private JProgressBar progressBarCpu;
    private JProgressBar progressBarRam;
    private JTable tableInfo;
    private JButton GenerateInfo;
    private JPanel panelPrincipal;

    public InformacionSistema(){
        super("Información del Sistema");
        setContentPane(panelPrincipal);
        setVisible(true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        updateInfoSystem();
        GenerateInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInfoSystem();
            }
        });
    }

    public void updateInfoSystem(){
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
        Runtime runtime = Runtime.getRuntime();

        double cpuLoad = osBean.getSystemLoadAverage();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        double memoryLoad = ((double) usedMemory / totalMemory) * 100;
        String cpuLoadString = String.format("%.2f%%", cpuLoad);

        if (cpuLoad < 0){
            cpuLoadString = "No disponible";
        }

        progressBarCpu.setStringPainted(true);
        progressBarRam.setStringPainted(true);

        progressBarCpu.setValue((int) cpuLoad);
        progressBarCpu.setString(cpuLoadString);
        progressBarRam.setValue((int) memoryLoad);
        progressBarRam.setString(String.format("%.2f%%", memoryLoad));
    }
}
