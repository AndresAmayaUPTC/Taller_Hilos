package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIBet extends JFrame {

    private JTextField jtBet;
    private JButton btnOne;
    public GUIBet(){
        setTitle("Apuesta");
        setSize(480,240);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        begin();
    }

    public void begin() {

        beginComponents();

        addComponents();

    }

    private void beginComponents() {

        jtBet = new JTextField();

        btnOne = new JButton("INICIAR");
    }

    private void addComponents() {

        JPanel pnlCenter = new JPanel();

        pnlCenter.setLayout(null);

        jtBet.setBounds(0,0,480,100);
        jtBet.setBackground(Color.red);
        jtBet.setOpaque(true);
        jtBet.setHorizontalAlignment(SwingConstants.CENTER);

        btnOne.setBounds(0,100,480,130);

        pnlCenter.add(jtBet);

        pnlCenter.add(btnOne);

        this.add(pnlCenter, BorderLayout.CENTER);

        btnOne.addActionListener((e) -> {

            GUIGame game = new GUIGame();

            game.begin(jtBet.getText());

            dispose();
        });


    }

}
