package GUI;

import javax.swing.*;
import java.awt.*;

public class GUIBet extends JFrame {

    private JTextField jtBet;
    private JButton btnOne, btnBack;
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

        btnBack=new JButton("VOLVER");
    }

    private void addComponents() {

        JPanel pnlCenter = new JPanel();

        pnlCenter.setLayout(new GridLayout(2,1));

        jtBet.setOpaque(true);
        jtBet.setHorizontalAlignment(SwingConstants.CENTER);


        pnlCenter.add(jtBet);

        pnlCenter.add(btnOne);

        this.add(pnlCenter, BorderLayout.CENTER);

        this.add(btnBack,BorderLayout.SOUTH);

        btnBack.addActionListener((e) -> {
            new MainWindow();
            dispose();
        });

        btnOne.addActionListener((e) -> {

            try {

                Integer.parseInt(jtBet.getText());

                GUIGame game = new GUIGame();

                dispose();

                game.begin(jtBet.getText());

            } catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null,"Valor de apuesta invalido");
                jtBet.setText(null);
            }

        });


    }

}
