package GUI;

import Logic.ThreadCount;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class MainWindow extends JFrame {
    private JLabel jlRules;
    private JButton btnOne;

    public MainWindow() {

        setTitle("Ejemplo de Hilos");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void begin() {

        beginComponents();

        addComponents();

    }

    private void beginComponents() {

        jlRules = new JLabel("REGLAS DEL JUEGO");

        btnOne = new JButton("CONTINUAR");
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

        pnlCenter.setLayout(null);

        jlRules.setBounds(0,0,400,400);
        jlRules.setBackground(Color.red);
        jlRules.setOpaque(true);
        jlRules.setHorizontalAlignment(SwingConstants.CENTER);

        btnOne.setBounds(0,400,400,150);

        pnlCenter.add(jlRules);

        pnlCenter.add(btnOne);

        this.add(pnlCenter, BorderLayout.CENTER);

        btnOne.addActionListener((e) -> {
            Game game = new Game();
            game.begin();
            game.setVisible(true);
        });


    }
}
