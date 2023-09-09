package GUI;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class MainWindow extends JFrame {
    private JButton btnOne,btnRules,btnRecord;

    public MainWindow() {

        setTitle("Ejemplo de Hilos");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        begin();
    }

    public void begin() {

        beginComponents();

        addComponents();

    }

    private void beginComponents() {

        btnOne = new JButton("CONTINUAR");
        btnRules = new JButton("REGLAS");
        btnRecord = new JButton("HISTORIAL");
    }

    private void addComponents() {

        JLabel hour = new JLabel();

        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout());
        panel.add(hour);

        this.add(panel, BorderLayout.NORTH);

        new Thread(() -> {
            while (true) {
                LocalTime time = LocalTime.now();

                hour.setText(time.getHour() + " : " + time.getMinute() + " : " + time.getSecond());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        JPanel pnlCenter = new JPanel();

        pnlCenter.setLayout(new GridLayout(3,1));

        pnlCenter.add(btnRules);
        pnlCenter.add(btnOne);
        pnlCenter.add(btnRecord);

        this.add(pnlCenter, BorderLayout.CENTER);

        btnOne.addActionListener((e) -> {
            new GUIBet();
            dispose();
        });

        btnRules.addActionListener((e) -> {
            new GUIRules();
            dispose();
        });

        btnRecord.addActionListener((e) -> {
            new GUIRecord();
            dispose();
        });

    }
}
